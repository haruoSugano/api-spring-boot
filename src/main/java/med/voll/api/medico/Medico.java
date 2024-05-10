package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarMedico dadosAtualizarMedico) {

        if (dadosAtualizarMedico.nome() != null) {
            this.nome = dadosAtualizarMedico.nome();
        }

        if (dadosAtualizarMedico.telefone() != null) {
            this.telefone = dadosAtualizarMedico.telefone();
        }

        if (dadosAtualizarMedico.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizarMedico.endereco());
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
