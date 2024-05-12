package med.voll.api.medico.dto;

import med.voll.api.endereco.dto.DadosEndereco;
import med.voll.api.medico.Especialidade;

public record DadosCadastroMedico(
        String nome,
        String telefone,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
