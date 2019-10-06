package sample.model;

import java.util.ArrayList;

public class Cliente {
    private String nomeDoCliente;
    private int codigoDoCliente;
    private String CPF;
    private String email;
    private String senha;
    private ArrayList<Endereco> enderecos;

    public Cliente(String nome, int codigo, String cpf, String email, String senha) {
        this.nomeDoCliente = nome;
        this.codigoDoCliente = codigo;
        this.CPF = cpf;
        this.email = email;
        this.senha = senha;
        this.enderecos = new ArrayList<>();
    }

    public void addEndereco(String rua, String bairro, String cidade, String cep, String pais, int n){
        this.enderecos.add(new Endereco(rua, bairro, cidade, cep, pais, n));
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
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

    public ArrayList<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public static class Produto {
    }
}

