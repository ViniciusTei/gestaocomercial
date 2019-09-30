package sample.model;

import java.util.ArrayList;

public class SistemaDAO {
    private static SistemaDAO instancia = new SistemaDAO();
    private ArrayList<Cliente> lisdaDeClientes;
    //todo lista de produtos e lista de vendas

    private SistemaDAO() {
        this.lisdaDeClientes = new ArrayList<>();;
        this.lisdaDeClientes.add(new Cliente("vinicius", 1, "112.970.396-70", "viniteixeirap@hotmail.com", "199725"));
        this.lisdaDeClientes.add(new Cliente("vitoria", 2, "111.999.396-70", "vitoria@hotmail.com", "199725"));
        this.lisdaDeClientes.add(new Cliente("camila", 3, "112.000.333-77", "camila@hotmail.com", "199725"));
        this.lisdaDeClientes.add(new Cliente("selina", 4, "110.123.123-12", "selina@hotmail.com", "199725"));
        this.lisdaDeClientes.add(new Cliente("vinicius", 5,"000.000.000-00", "email@email.com", "senha123"));
        System.out.println("Lista de clientes iniciada!");
    }

    public static SistemaDAO getInstance() {
        return instancia;
    }

    private boolean validaCPF (String cpf) {
        for(Cliente c : this.lisdaDeClientes) {
            if(c.getCPF().equals(cpf)) {
                return false;
            }
        }

        return true;
    }

    private boolean validaEmail (String email) {
        for(Cliente c : this.lisdaDeClientes) {
            if(c.getEmail().equals(email)) {
                return false;
            }
        }

        return true;
    }

    public void addCliente(String novoNome, int novoCodigo, String novoCpf, String novoEmail, String novaSenha){
        if(validaCPF(novoCpf)) {
            if (validaEmail(novoEmail)) {
                this.lisdaDeClientes.add(new Cliente(novoNome, novoCodigo, novoCpf, novoEmail, novaSenha));
                System.out.println("novo cliente cadastrado com sucesso!");
            } else {
                System.out.println("Email ja cadastrado!");
            }
        } else {
            System.out.println("cpf ja cadastrado!");
        }
    }

    /* Método que retorna uma lista de clientes com o mesmmo nome
     */
    public ArrayList<Cliente> buscaCliente(String nome) {
        ArrayList<Cliente> newlist = new ArrayList<>();
        for (Cliente clienteBuscado : lisdaDeClientes) {
            if(clienteBuscado.getNomeDoCliente().equals(nome)) {
                newlist.add(clienteBuscado);
            }
        }

        return newlist;
    }

    public ArrayList<Cliente> getLisdaDeClientes() {
        return lisdaDeClientes;
    }
}
