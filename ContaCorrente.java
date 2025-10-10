public class ContaCorrente extends Conta implements ITributavel {
    private static final double TAXA_SAQUE = 0.05;
    private static final double TAXA_TRIBUTO = 0.01;

    public ContaCorrente(String cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor * (1 + TAXA_SAQUE);
        if (valor > 0 && saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            System.out.println("Saque de R$ " + valor + " realizado. Taxa: R$ " + (valor * TAXA_SAQUE));
            return true;
        }
        System.out.println("Saldo insuficiente para saque!");
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " para conta " + contaDestino.getNumero() + " realizada!");
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
