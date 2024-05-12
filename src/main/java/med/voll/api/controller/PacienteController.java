package med.voll.api.controller;

import med.voll.api.paciente.dto.DadosAtualizarPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return pacienteRepository
                .findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativar(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.desativar(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizarPaciente $dadosPaciente) {
        var paciente = pacienteRepository.getReferenceById($dadosPaciente.id());
        paciente.atualizarInformacoes($dadosPaciente);
    }
}
