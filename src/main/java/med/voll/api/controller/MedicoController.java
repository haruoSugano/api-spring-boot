package med.voll.api.controller;

import med.voll.api.medico.*;
import med.voll.api.medico.dto.DadosAtualizarMedico;
import med.voll.api.medico.dto.DadosCadastroMedico;
import med.voll.api.medico.dto.DadosListagemMedico;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dadosMedico){
        medicoRepository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return medicoRepository
                .findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizarMedico dadosMedico) {
        var medico = medicoRepository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
    }

    // exclusao fisica (deletar o dados do bd)
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void deletar(@PathVariable Long id) {
//        medicoRepository.deleteById(id);
//    }

    // inativar
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
    }
}

