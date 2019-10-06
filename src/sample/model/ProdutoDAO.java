package sample.model;

import java.util.ArrayList;
import java.util.Objects;

public class ProdutoDAO {
    private static ProdutoDAO instancia = new ProdutoDAO();
    private ArrayList<Produto> listaDeProdutos;

    private ProdutoDAO(){
        this.listaDeProdutos = new ArrayList<>();
        this.listaDeProdutos.add(new Produto(1,"Abaixo de Zero: Hello Hell","Novo album do Black Alien",10,"CD"));
        this.listaDeProdutos.add(new Produto(2,"FIFA 20","Jogo de PS4",20,"Blue-Ray"));
        this.listaDeProdutos.add(new Produto(3,"Xiaomi Redmi AirDots","Fones de ouvido Bluetooth preto",10,"Fones Bluetooth"));
        System.out.println("Lista de Produtos iniciada!");
    }

    public static ProdutoDAO getInstance(){
        return instancia;
    }

    public boolean validaCodigo (int codigo){
        for(Produto p : this.listaDeProdutos) {
            if (Objects.equals(p.getCodigoDoProduto(), codigo)) {
                return false;
            }
        }
        return true;
    }

    public boolean validaNome (String nome){
        for(Produto p : this.listaDeProdutos) {
            if (p.getNomeDoProduto().equals(nome)) {
                return false;
            }
        }
        return true;
    }

    public void addProduto(int novoCodigo, String novoNome, String novaDescricao, int novaQntEtoque, String novaCategoria){
        if(validaNome(novoNome)){
            if(validaCodigo(novoCodigo)){
                this.listaDeProdutos.add(new Produto(novoCodigo,novoNome,novaDescricao,novaQntEtoque,novaCategoria));
                System.out.println("Novo produto cadastrado com sucesso");
            }else {
                System.out.println("Codigo do produto já cadastrado");
            }
        }else{
            System.out.println("Nome do produto ja cadastrado");
        }

    }

    public ArrayList<Produto> getListaDeProdutos(){return listaDeProdutos;}

    public Produto getProduto(int codProduto){
        for(Produto p : this.listaDeProdutos){
            if(p.getCodigoDoProduto()== codProduto){
                return p;
            }
        }
        return null;
    }

}
