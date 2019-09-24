package sample.model;

public class Cliente {
    private String nomeDoCliente;
    private int codigoDoCliente;
    private String CPF;
    private String email;
    private String senha;
    //todo lista de enderecos

    public Cliente(String nome, int codigo, String cpf, String email, String senha) {
        this.nomeDoCliente = nome;
        this.codigoDoCliente = codigo;
        this.CPF = cpf;
        this.email = email;
        this.senha = senha;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String novaSenha) {
        if(novaSenha.equals(this.senha)) {
            System.out.println("Senha nao pode ser igual a senha antiga!");
        } else if (novaSenha.length() >= 5) {
            this.senha = novaSenha;
        } else {
            System.out.println("Senha muito curta! Deve ter pelo menos 5 caracteres.");
        }
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}

