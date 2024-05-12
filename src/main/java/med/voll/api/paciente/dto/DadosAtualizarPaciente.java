package med.voll.api.paciente.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dto.DadosEndereco;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) { }
