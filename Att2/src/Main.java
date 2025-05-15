import java.util.Scanner;

class Conta{
    public int conta;
    int agencia;
    private double saldo;
    private static int contadorContas = 0;

    public Conta(int conta, int agencia) {
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = 0.0;
        contadorContas++;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getTotalContas() {
        return contadorContas;
    }
}

class ContaPoupanca extends Conta{
    public ContaPoupanca(int conta, int agencia) {
        super(conta, agencia);
    }


}

class  ContaCorrente extends Conta{
    private static final double TAXA_SAQUE = 2.5;

    public ContaCorrente(int conta, int agencia) {
        super(conta, agencia);
    }
    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE;
        return super.sacar(valorComTaxa);
    }

}

public class Main {
    public static void main(String[] args) {

        ContaPoupanca poupanca = new ContaPoupanca(1234, 100);
        ContaCorrente corrente = new ContaCorrente(5678, 200);

        poupanca.depositar(500);
        corrente.depositar(500);

        poupanca.sacar(100);
        corrente.sacar(100);

        System.out.println("Conta Poupança: " + poupanca.conta + " | Agência: " + poupanca.agencia + " | Saldo: " + poupanca.getSaldo());
        System.out.println("Conta Corrente: " + corrente.conta + " | Agência: " + corrente.agencia + " | Saldo: " + corrente.getSaldo());
        System.out.println("Total de contas criadas: " + Conta.getTotalContas());

    }
}