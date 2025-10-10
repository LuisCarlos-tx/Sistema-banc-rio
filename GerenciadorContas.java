import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Conta> contas;

    public GerenciadorContas() {
        this.contas = new ArrayList<>();
    }

    public void criarConta(String cliente, String tipoConta) {
        Conta novaConta;
        if (tipoConta.equalsIgnoreCase("C") || tipoConta.equalsIgnoreCase("CORRENTE")) {
            novaConta = new ContaCorrente(cliente);
        } else if (tipoConta.equalsIgnoreCase("P") || tipoConta.equalsIgnoreCase("POUPANCA")) {
            novaConta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido!");
            return;
        }
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumero());
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null && valor > 0) {
            conta.depositar(valor);
            return true;
        }
        System.out.println("Conta não encontrada ou valor inválido!");
        return false;
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null && valor > 0) {
            return conta.sacar(valor);
        }
        System.out.println("Conta não encontrada ou valor inválido!");
        return false;
    }

    public boolean transferir(int contaOrigem, int contaDestino, double valor) {
        Conta origem = buscarConta(contaOrigem);
        Conta destino = buscarConta(contaDestino);
        
        if (origem != null && destino != null && valor > 0) {
            return origem.transferir(valor, destino);
        }
        System.out.println("Conta de origem, destino ou valor inválido!");
        return false;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        
        System.out.println("\n=== LISTA DE CONTAS ===");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public double calcularTotalTributos() {
        double total = 0.0;
        for (Conta conta : contas) {
            if (conta instanceof ITributavel) {
                ITributavel tributavel = (ITributavel) conta;
                total += tributavel.calculaTributos();
            }
        }
        return total;
    }
}
