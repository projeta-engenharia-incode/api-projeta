package br.com.projeta_api.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;


@Service
public class ExcelExportService {

    public <T> ResponseEntity<ByteArrayResource>
    exportar(String nomeArquivo, List<T> dados, Class<T> clazz) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Dados");

            // Estilo do cabeçalho
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            headerStyle.setFont(font);
            headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Cria o cabeçalho com base nos campos da classe
            Field[] fields = clazz.getDeclaredFields();
            Row header = sheet.createRow(0);
            for (int i = 0; i < fields.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(fields[i].getName());
                cell.setCellStyle(headerStyle);
            }

            // Popula os dados
            int rowIdx = 1;
            for (T item : dados) {
                Row row = sheet.createRow(rowIdx++);
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(item);
                    row.createCell(i).setCellValue(value != null ? value.toString() : "");
                }
            }

            // Ajusta o tamanho das colunas
            for (int i = 0; i < fields.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Gera o arquivo em memória
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=" + nomeArquivo + ".xlsx")
                    .contentType(MediaType.parseMediaType(
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(resource);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar Excel: " + e.getMessage(), e);
        }
    }
}
