package sample.model;


public class Produto {
    private int codigoDoProduto;
    private String nomeDoProduto;
    private String descricao;
    private int qntEtoque;
    private String categoriaDoProduto;

    public Produto(int codigoDoProduto, String nomeDoProduto, String descricao, int qntEtoque, String categoriaDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
        this.nomeDoProduto = nomeDoProduto;
        this.descricao = descricao;
        this.qntEtoque = qntEtoque;
        this.categoriaDoProduto = categoriaDoProduto;
    }

    public void setCodigoDoProduto(int codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQntEtoque(int qntEtoque) {
        this.qntEtoque = qntEtoque;
    }

    public void setCategoriaDoProduto(String categoriaDoProduto) {
        this.categoriaDoProduto = categoriaDoProduto;
    }

    public int getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQntEtoque() {
        return qntEtoque;
    }

    public String getCategoriaDoProduto() {
        return categoriaDoProduto;
    }
}
