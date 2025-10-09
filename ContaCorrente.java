public class ContaCorrente extends Conta implements Tributavel {
    private static final double TAXA_SAQUE = 0.05;
    private static final double TAXA_TRIBUTO = 0.01;

    public ContaCorrente(String cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor * (1 + TAXA_SAQUE);
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public double calculaTributos() {
        return saldo * TAXA_TRIBUTO;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Conta Corrente";
    }
}
