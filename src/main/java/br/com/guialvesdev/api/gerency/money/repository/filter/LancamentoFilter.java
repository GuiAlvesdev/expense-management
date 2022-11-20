package br.com.guialvesdev.api.gerency.money.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private localDate dataVencimentoDe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private localDate dataVencimentoAte;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public localDate getDataVencimentoDe() {
        return dataVencimentoDe;
    }

    public void setDataVencimentoDe(localDate dataVencimentoDe) {
        this.dataVencimentoDe = dataVencimentoDe;
    }

    public localDate getDataVencimentoAte() {
        return dataVencimentoAte;
    }

    public void setDataVencimentoAte(localDate dataVencimentoAte) {
        this.dataVencimentoAte = dataVencimentoAte;
    }


}
