package sample.model;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String pais;

    public Endereco(String rua, String bairro, String cidade, String cep, String pais){
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getPais() {
        return pais;
    }
}
