package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAO {
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String telefone;
    private String email;

    public AlunoDAO(String nome, String cpf, Date data_nascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public void cadastrar(Connection conn, Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.executeUpdate();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public String listar(Connection conn) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(new java.util.Date(rs.getDate("data_nascimento").getTime()));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEmail(rs.getString("email"));
                alunos.add(aluno);
            }
        }

        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Aluno aluno : alunos){
            sb.append("|Aluno\n");
            sb.append("|ID: ").append(aluno.getId()).append("\n");
            sb.append("|Nome: ").append(aluno.getNome()).append("\n");
            sb.append("|CPF: ").append(aluno.getCpf()).append("\n");
            sb.append("|Data de Nascimento: ")
            .append(aluno.getDataNascimento() != null ? sdf.format(aluno.getDataNascimento()) : "N/A").append("\n");
            sb.append("|Telefone: ").append(aluno.getTelefone()).append("\n");
            sb.append("|Email: ").append(aluno.getEmail()).append("\n");
            sb.append("-----------------------------\n");
        }
        return sb.toString(); // Nesse ponto eu nem sei mais se isso é necessário
    }

    public void atualizarAluno(Connection conn, Aluno aluno) throws SQLException{
        String sql = "UPDATE alunos SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.setInt(6, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirAluno(Connection conn, Aluno aluno) throws SQLException{
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, aluno.getId());
            stmt.executeUpdate();
        }
    }
    
    public Aluno buscarPorId(Connection conn, int id) throws SQLException{
            String sql = "SELECT * FROM alunos WHERE id = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        Aluno aluno = new Aluno();
                        aluno.setId(rs.getInt("Id -> "));
                        aluno.setNome(rs.getString("Nome -> "));
                        aluno.setCpf(rs.getString("CPF -> "));
                        java.sql.Date dataSql = rs.getDate("Data de nascimento -> ");
                        if (dataSql != null){
                            aluno.setDataNascimento(new java.util.Date(dataSql.getTime()));
                        }
                        aluno.setTelefone(rs.getString("Telefone -> "));
                        aluno.setEmail(rs.getString("Email -> "));
                        return aluno;
                    }
                }
            }
            return null; // Essa parte é para caso não seja encontrado o aluno :P
            
    }

    public List<Aluno> buscarPorNome(Connection conn, String nome) throws SQLException {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    java.sql.Date dataSql = rs.getDate("data_nascimento");
                    if (dataSql != null) {
                        aluno.setDataNascimento(new java.util.Date(dataSql.getTime()));
                    }
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setEmail(rs.getString("email"));
                    alunos.add(aluno);
                }
            }
        }
        return alunos;
    }
}
