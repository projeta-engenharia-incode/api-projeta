package br.com.projeta_api.controller;


import br.com.projeta_api.dto.export.*;
import br.com.projeta_api.model.*;
import br.com.projeta_api.repository.*;
import br.com.projeta_api.service.ExcelExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/export")
@RequiredArgsConstructor
public class ExportController {

    private final ExcelExportService excelExportService;

    private final CicloRepository cicloRepository;

    private final RejeicoesRevisaoRepository rejeicoesRevisaoRepository;

    private final RevisoesDocRepository  revisoesDocRepository;

    private final UsuarioRepository usuarioRepository;

    private final CobrancasRepository cobrancasRepository;

    private final ProjetoRepository projetoRepository;

    private final ResponsaveisDocumentoRepository responsaveisDocumentoRepository;

    private final ContratoRepository contratoRepository;

    private final PreContratoRepository  preContratoRepository;

    private final OrcamentoRepository orcamentoRepository;

    private final MedicoesDocumentosRepository medicoesDocumentosRepository;

    private final PagamentosFornecedoresRepository pagamentosFornecedoresRepository;

    private final PrecosUnitariosRepository  precosUnitariosRepository;

    private final RecursoRepository recursoRepository;

    private final TiposRejeicoesRepository tiposRejeicoesRepository;

    private final UsoRecursosRepository  usoRecursosRepository;

    private final EntregasCicloRepository  entregasCicloRepository;

    private final EmissoesDocumentoRepository  emissoesDocumentoRepository;

    private final FornecedoresRepository fornecedoresRepository;

    private final ChamadosRepository  chamadosRepository;


    @GetMapping("/ciclos")
    public ResponseEntity<ByteArrayResource> exportarCiclos() {
        return excelExportService.exportar("ciclos", cicloRepository.findAll(), Ciclo.class);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<ByteArrayResource> exportarRecursos() {
        return excelExportService.exportar("recursos", usuarioRepository.findAll(), Usuario.class);
    }

    @GetMapping("/recursos")
    public ResponseEntity<ByteArrayResource> exportarUsuarios() {
        return excelExportService.exportar("recursos", recursoRepository.findAll(), Recurso.class);
    }

    @GetMapping("/cobrancas")
    public ResponseEntity<ByteArrayResource> exportarCobrancas() {
        List<CobrancaExportDto> dtos = cobrancasRepository.findAll()
                .stream()
                .map(CobrancaExportDto::new)
                .toList();

        return excelExportService.exportar("cobrancas", dtos, CobrancaExportDto.class);
    }

    @GetMapping("/cobrancas2")
    public ResponseEntity<ByteArrayResource> exportarCiclo() {
        List<ExportCobrancaDto> dtos = cobrancasRepository.findAll()
                .stream()
                .map(ExportCobrancaDto::new)
                .toList();

        return excelExportService.exportar("cobrancas", dtos, ExportCobrancaDto.class);
    }

    @GetMapping("/projeto")
    public ResponseEntity<ByteArrayResource> exportarProjeto() {
        List<ExportProjetoDto> dtos = projetoRepository.findAll()
                .stream()
                .map(ExportProjetoDto::new)
                .toList();

        return excelExportService.exportar("projetos", dtos, ExportProjetoDto.class);
    }

    @GetMapping("/orcamentos")
    public ResponseEntity<ByteArrayResource> exportarOrcamento() {
        List<ExportOrcamentoDto> dtos = orcamentoRepository.findAll()
                .stream()
                .map(ExportOrcamentoDto::new)
                .toList();

        return excelExportService.exportar("orcamentos", dtos, ExportOrcamentoDto.class);
    }

    @GetMapping("/pre-contratos")
    public ResponseEntity<ByteArrayResource> exportarPreContrato() {
        List<ExportPreContratoDto> dtos = preContratoRepository.findAll()
                .stream()
                .map(ExportPreContratoDto::new)
                .toList();

        return excelExportService.exportar("pre-contratos", dtos, ExportPreContratoDto.class);
    }


    @GetMapping("/medicoes-documentos")
    public ResponseEntity<ByteArrayResource> exportarMedicoesDocumentos() {
        List<ExportMedicoesDocumentos> dtos = medicoesDocumentosRepository.findAll()
                .stream()
                .map(ExportMedicoesDocumentos::new)
                .toList();

        return excelExportService.exportar("medicoes-doc", dtos, ExportMedicoesDocumentos.class);
    }

    @GetMapping("/pagamemto-fornecedores")
    public ResponseEntity<ByteArrayResource> exportarPagamentosFornecedores() {
        List<ExportPagamentoFornecedoresDto> dtos = pagamentosFornecedoresRepository.findAll()
                .stream()
                .map(ExportPagamentoFornecedoresDto::new)
                .toList();

        return excelExportService.exportar("pagamentos-forncedores", dtos, ExportPagamentoFornecedoresDto.class);
    }

    @GetMapping("/preco-unitario")
    public ResponseEntity<ByteArrayResource> exportarPrecoUnitario() {
        List<ExportPrecosUnitariosDto> dtos = precosUnitariosRepository.findAll()
                .stream()
                .map(ExportPrecosUnitariosDto::new)
                .toList();

        return excelExportService.exportar("preco-unitario", dtos, ExportPrecosUnitariosDto.class);
    }


    @GetMapping("/rejeicoes-revisao")
    public ResponseEntity<ByteArrayResource> exportarRejeicoesRevisao() {
        List<ExportRejeicoesRevisaoDto> dtos = rejeicoesRevisaoRepository.findAll()
                .stream()
                .map(ExportRejeicoesRevisaoDto::new)
                .toList();

        return excelExportService.exportar("rejeicoes-revisao", dtos, ExportRejeicoesRevisaoDto.class);
    }

    @GetMapping("/responsaveis-documentos")
    public ResponseEntity<ByteArrayResource> exportarResponsaveisDocumentos() {
        List<ExportResponsaveisDocumentosDto> dtos = responsaveisDocumentoRepository.findAll()
                .stream()
                .map(ExportResponsaveisDocumentosDto::new)
                .toList();

        return excelExportService.exportar("responsaveis-documentos", dtos, ExportResponsaveisDocumentosDto.class);
    }

    @GetMapping("/revisoes-doc")
    public ResponseEntity<?> exportarRevisoesDoc() {
        try {
            List<ExportRevisoesDoc> dtos = revisoesDocRepository.findAll()
                    .stream()
                    .map(ExportRevisoesDoc::new)
                    .toList();

            return excelExportService.exportar("revisoes-doc", dtos, ExportRevisoesDoc.class);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro " + e.getMessage());
        }

    }

    @GetMapping("/tipos-rejeicoes")
    public ResponseEntity<ByteArrayResource> exportarTiposRejeicoes() {
        List<ExportTiposRejeicoes> dtos = tiposRejeicoesRepository.findAll()
                .stream()
                .map(ExportTiposRejeicoes::new)
                .toList();

        return excelExportService.exportar("tipos-rejeicoes", dtos, ExportTiposRejeicoes.class);
    }


    @GetMapping("/uso-recursos")
    public ResponseEntity<ByteArrayResource> exportarUsoRecursos() {
        List<ExportUsoRecurso> dtos = usoRecursosRepository.findAll()
                .stream()
                .map(ExportUsoRecurso::new)
                .toList();

        return excelExportService.exportar("uso-recursos", dtos, ExportUsoRecurso.class);
    }


    @GetMapping("/entrega-ciclos")
    public ResponseEntity<ByteArrayResource> exportarEntregasCiclo() {
        List<ExportEntregasCicloDto> dtos = entregasCicloRepository.findAll()
                .stream()
                .map(ExportEntregasCicloDto::new)
                .toList();

        return excelExportService.exportar("entrega-ciclos", dtos, ExportEntregasCicloDto.class);
    }

    @GetMapping("/emissao-documentos")
    public ResponseEntity<ByteArrayResource> exportarEmissoesDocuementos() {
        List<ExportEmissaoDocumentoDto> dtos = emissoesDocumentoRepository.findAll()
                .stream()
                .map(ExportEmissaoDocumentoDto::new)
                .toList();

        return excelExportService.exportar("emissao-documentos", dtos, ExportEmissaoDocumentoDto.class);
    }


    @GetMapping("/fornecedores")
    public ResponseEntity<ByteArrayResource> exportarFornecedores() {
        List<ExportForncedoresDto> dtos = fornecedoresRepository.findAll()
                .stream()
                .map(ExportForncedoresDto::new)
                .toList();

        return excelExportService.exportar("fornecedores", dtos, ExportForncedoresDto.class);
    }


    @GetMapping("/contratos")
    public ResponseEntity<ByteArrayResource> exportarContratos() {
        List<ExportContratoDto> dtos = contratoRepository.findAll()
                .stream()
                .map(ExportContratoDto::new)
                .toList();

        return excelExportService.exportar("contratos", dtos, ExportContratoDto.class);
    }


    @GetMapping("/chamados")
    public ResponseEntity<ByteArrayResource> exportarChamados() {
        List<ExportChamadosDto> dtos = chamadosRepository.findAll()
                .stream()
                .map(ExportChamadosDto::new)
                .toList();

        return excelExportService.exportar("chamados", dtos, ExportChamadosDto.class);
    }






}
