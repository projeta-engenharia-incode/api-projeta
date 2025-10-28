package br.com.projeta_api.controller;


import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.repository.CicloRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class CsvHelper {

    private final CicloRepository cicloRepository;
    public CsvHelper(CicloRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }

    @GetMapping("/ciclo/exportar")
    public ResponseEntity<Resource> exportarUsuarios() throws IOException {
        List<Ciclo> usuarios = cicloRepository.findAll();

        // Cria o conteúdo CSV em memória
        StringBuilder csv = new StringBuilder();
        csv.append("ID,Nome,CreatedAt,UpdatedAt\n");
        for (Ciclo u : usuarios) {
            csv.append(u.getId()).append(",")
                    .append(u.getNome()).append(",")
                    .append(u.getCreatedAt()).append(",")
                    .append(u.getUpdatedAt()).append("\n");
        }

        // Converte para recurso (simula um arquivo)
        ByteArrayResource resource = new ByteArrayResource(csv.toString().getBytes(StandardCharsets.UTF_8));

        // Define cabeçalhos para download
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=usuarios.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .contentLength(resource.contentLength())
                .body(resource);
    }



    @GetMapping("/ciclos/exportar-xlsx")
    public ResponseEntity<ByteArrayResource> exportarCiclosXlsx() throws IOException {
        List<Ciclo> ciclos = cicloRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ciclos");

        // Estilo do cabeçalho (com cor e negrito)
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(font);
        headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Cabeçalho
        Row header = sheet.createRow(0);
        String[] colunas = {"ID", "Nome", "CreatedAt", "UpdatedAt"};
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(colunas[i]);
            cell.setCellStyle(headerStyle);
        }

        // Dados
        int rowIdx = 1;
        for (Ciclo c : ciclos) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(c.getId());
            row.createCell(1).setCellValue(c.getNome());
            row.createCell(2).setCellValue(c.getCreatedAt().toString());
            row.createCell(3).setCellValue(c.getUpdatedAt().toString());
        }

        // Auto-ajusta o tamanho das colunas
        for (int i = 0; i < colunas.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Gera o arquivo em memória
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ciclos.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }


}
