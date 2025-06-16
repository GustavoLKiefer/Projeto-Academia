package model;
import java.util.Date;

public class Aluno {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private String dataNascimentoFormatada;

    // Usando Integer ao invés de int para caso de valores nulos e para listar os objetos (segundo a internet só assim funciona)

    public Aluno() {}
    public Aluno(String nome, String cpf, Date dataNascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }


    public Aluno(Integer id, String nome, String cpf, Date dataNascimento, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataFormatada) {
        this.dataNascimento = dataFormatada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimentoFormatada() {
        return dataNascimentoFormatada;
    }

    public void setDataNascimentoFormatada(String dataNascimentoFormatada) {
        this.dataNascimentoFormatada = dataNascimentoFormatada;
    }

    @Override
    public String toString() {
        return "| Aluno \n" +
               "| ID: " + id + "\n" +
               "| Nome: " + nome + "\n" +
               "| CPF: " + cpf + "\n" +
               "| Data de nascimento: " + dataNascimentoFormatada + "\n" +
               "| Telefone: " + telefone + "\n" +
               "| Email: " + email + "\n" +
               "|-----------------------------";
    }

}
