package odontosoft.model.domain;

/**
 *
 *  Classe utilizada para popular a tabela de procedimentos relacionados a consulta
 * tal tabela é mostrada ao clicar no botão procedimentos presente na tela de agenda
 */
public class ConsultaProcedimento {
    private String descricaoProcedimento;
    private int idProcedimento,quantidade;
    private double precoProcedimento;

    public ConsultaProcedimento(String nomeProcedimento, int idProcedimento, int quantidade, double precoProcedimento) {
        this.descricaoProcedimento = nomeProcedimento;
        this.idProcedimento = idProcedimento;
        this.quantidade = quantidade;
        this.precoProcedimento = precoProcedimento;
    }

    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    public void setDescricaoProcedimento(String nomeProcedimento) {
        this.descricaoProcedimento = nomeProcedimento;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoProcedimento() {
        return precoProcedimento;
    }

    public void setPrecoProcedimento(double precoProcedimento) {
        this.precoProcedimento = precoProcedimento;
    }
    
    
}
