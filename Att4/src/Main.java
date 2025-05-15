import java.util.ArrayList;
import java.util.List;

class Pedido{

    private List<Item> itens;
    private int idPedido;
    private double preco;

    public Pedido(int PedidoId){
        this.idPedido = PedidoId;
        this.itens = new ArrayList<>();
        this.preco = 0;
    }


    public void addItem(String nome, double preco){
        Item item = new Item(nome, preco);
        this.itens.add(item);
    }

    public double getTotal(){
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    private class Item{

        private String nome;
        private double preco;

        public Item(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public double getPreco() {
            return preco;
        }


    }
}



public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(1);
        pedido.addItem("Caneta", 2.50);
        pedido.addItem("Caderno", 10.00);
        pedido.addItem("Lápis", 1.25);

        System.out.println("Total do pedido: R$ " + pedido.getTotal());
    }
}