package br.com.projeta_api.service;

import br.com.projeta_api.model.Chamados;
import br.com.projeta_api.repository.ChamadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamadosService {

    private final ChamadosRepository chamadosRepository;

    public Chamados criarChamado(Chamados chamado){
        return chamadosRepository.save(chamado);
    }

    public List<Chamados> listarTodos(){
        return chamadosRepository.findAll();
    }

    public Chamados buscarPorId(Long id){
        return chamadosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chamado não encontrado com o ID: " + id));
    }

    public Chamados atulizarChamado(Long id, Chamados chamadoAtualizado){
        Chamados chamadoExistente = buscarPorId(id);

        chamadoExistente.setCoordenador(chamadoAtualizado.getCoordenador());
        chamadoExistente.setAtendido(chamadoAtualizado.getAtendido());
        chamadoExistente.setNomeProjeto(chamadoAtualizado.getNomeProjeto());
        chamadoExistente.setCodigoCliente(chamadoAtualizado.getCodigoCliente());
        chamadoExistente.setDataAbertura(chamadoAtualizado.getDataAbertura());
        chamadoExistente.setDataAgendamento(chamadoAtualizado.getDataAgendamento());
        chamadoExistente.setDataVisita(chamadoAtualizado.getDataVisita());
        chamadoExistente.setDataEstimativa(chamadoAtualizado.getDataEstimativa());
        chamadoExistente.setCreatedAt(chamadoAtualizado.getCreatedAt());

        return chamadosRepository.save(chamadoExistente);
    }

    public void deletarChamado(Long id){
        Chamados chamado = buscarPorId(id);
        chamadosRepository.delete(chamado);
    }

    public boolean existeChamado(Long id){
        return chamadosRepository.existsById(id);
    }
}
