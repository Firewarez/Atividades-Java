
interface Pagamento {
    void processarPagamento(double valor);
}

class PagamentoDinheiro implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento em dinheiro no valor de R$ " + valor);
    }
}

class PagamentoCartao implements Pagamento {
    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("pagamento com cartão número " + numeroCartao + " no valor de R$ " + valor);
    }
}

class Venda {
    private Pagamento formaPagamento;
    private double valor;

    public Venda(double valor, Pagamento formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public void processarVenda() {
        System.out.println("Iniciando processamento da venda...");
        formaPagamento.processarPagamento(valor);
        System.out.println("Venda processada com sucesso!\n");
    }
}


public class Main {
    public static void main(String[] args) {

        Pagamento pagamentoDinheiro = new PagamentoDinheiro();
        Venda vendaDinheiro = new Venda(150.0, pagamentoDinheiro);
        vendaDinheiro.processarVenda();

        Pagamento pagamentoCartao = new PagamentoCartao("5260 9871 0528 0673");
        Venda vendaCartao = new Venda(300.0, pagamentoCartao);
        vendaCartao.processarVenda();
    }
}
