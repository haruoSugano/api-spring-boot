package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.dto.DadosAtualizarPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void desativar(Long id) {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizarPaciente $dadosPaciente) {
        if ($dadosPaciente.nome() != null) {
            this.nome = $dadosPaciente.nome();
        }

        if ($dadosPaciente.telefone() != null) {
            this.telefone = $dadosPaciente.telefone();
        }

        if ($dadosPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes($dadosPaciente.endereco());
        }
    }
}
