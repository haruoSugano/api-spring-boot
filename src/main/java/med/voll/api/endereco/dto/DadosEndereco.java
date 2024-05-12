package med.voll.api.endereco.dto;

public record DadosEndereco (
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
