package med.voll.api.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        if (dadosEndereco.logradouro() != null) {
            this.logradouro = dadosEndereco.logradouro();
        }

        if (dadosEndereco.bairro() != null) {
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.cep() != null) {
            this.cep = dadosEndereco.cep();
        }

        if (dadosEndereco.logradouro() != null) {
            this.numero = dadosEndereco.numero();
        }

        if (dadosEndereco.complemento() != null) {
            this.complemento = dadosEndereco.complemento();
        }

        if (dadosEndereco.logradouro() != null) {
            this.cidade = dadosEndereco.cidade();
        }

        if (dadosEndereco.logradouro() != null) {
            this.uf = dadosEndereco.uf();
        }
    }
}
