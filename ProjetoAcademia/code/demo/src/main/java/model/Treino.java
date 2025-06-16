package model;

import java.sql.Date;

public class Treino {
    private int idTreino;
    private int aluno_id;
    private String tipo_treino;
    private String descricao;
    private int duracao_minutos;
    private Date data_inicio;

    public int getIdTreino() {
        return idTreino;
    }
    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }
    public int getIdAluno() {
        return aluno_id;
    }
    public void setIdAluno(int idAluno) {
        this.aluno_id = idAluno;
    }
    public String getTipoTreino() {
        return tipo_treino;
    }
    public void setTipoTreino(String tipoTreino) {
        this.tipo_treino = tipoTreino;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getDuracaoMinutos() {
        return duracao_minutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracao_minutos = duracaoMinutos;
    }
    public Date getDataInicio() {
        return data_inicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.data_inicio = dataInicio;
    }

    @Override
    public String toString() {
        return "| Treino: \n" +
               "| ID: " + idTreino + "\n" +
               "|  AlunoID=" + aluno_id + "\n" +
               "| Tipo='" + tipo_treino + "\n" +
               "| Descrição='" + descricao + "\n" +
               "| Duração=" + duracao_minutos + " minutos\n" +
               "| Início=" + data_inicio + "\n" +
               "|-----------------------------";
    } // Agora a listagem deve funcionar da forma certa, eu não entendi o que estava errado e precisei usar IA pra corrigir isso
}
