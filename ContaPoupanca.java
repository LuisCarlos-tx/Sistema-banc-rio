public class ContaPoupanca extends Conta {
    public ContaPoupanca(String cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
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
    public String toString() {
        return super.toString() + " | Tipo: Conta Poupança";
    }
}
