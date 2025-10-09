import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Conta> contas;

    public GerenciadorContas() {
        this.contas = new ArrayList<>();
    }

    public void criarConta(String cliente, String tipoConta) {
        Conta novaConta;
        if (tipoConta.equalsIgnoreCase("C")) {
            novaConta = new ContaCorrente(cliente);
        } else {
            novaConta = new ContaPoupanca(cliente);
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
        return false;
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        return conta != null && conta.sacar(valor);
    }

    public boolean transferir(int contaOrigem, int contaDestino, double valor) {
        Conta origem = buscarConta(contaOrigem);
        Conta destino = buscarConta(contaDestino);
        
        if (origem != null && destino != null) {
            return origem.transferir(valor, destino);
        }
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

    public List<Conta> getContas() {
        return contas;
    }
}
