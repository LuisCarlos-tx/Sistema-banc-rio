public class ContaPoupanca extends Conta {
    public ContaPoupanca(String cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
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
    public String toString() {
        return super.toString() + " | Tipo: Conta Poupança";
    }
}
