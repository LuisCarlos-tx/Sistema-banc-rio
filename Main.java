import java.util.Scanner;

public class Main {
    private GerenciadorContas gerenciador;
    private Scanner scanner;

    public Main() {
        this.gerenciador = new GerenciadorContas();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        System.out.println("=== SISTEMA BANCÁRIO BOE ===");
        
        int opcao;
        do {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                switch (opcao) {
                    case 1 -> criarConta();
                    case 2 -> realizarDeposito();
                    case 3 -> realizarSaque();
                    case 4 -> realizarTransferencia();
                    case 5 -> listarContas();
                    case 6 -> calcularTributos();
                    case 7 -> System.out.println("Saindo do sistema... Obrigado!");
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um número válido!");
                scanner.nextLine(); // Limpar buffer em caso de erro
                opcao = 0;
            }
        } while (opcao != 7);
        
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Criar Conta");
        System.out.println("2. Realizar Depósito");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Realizar Transferência");
        System.out.println("5. Listar Contas");
        System.out.println("6. Calcular Total de Tributos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void criarConta() {
        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();
        
        System.out.print("Tipo de conta (C-Corrente/P-Poupança): ");
        String tipo = scanner.nextLine();
        
        gerenciador.criarConta(cliente, tipo);
    }

    private void realizarDeposito() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor do depósito: R$ ");
        double valor = scanner.nextDouble();
        
        gerenciador.depositar(numero, valor);
    }

    private void realizarSaque() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor do saque: R$ ");
        double valor = scanner.nextDouble();
        
        gerenciador.sacar(numero, valor);
    }

    private void realizarTransferencia() {
        System.out.print("Conta de origem: ");
        int origem = scanner.nextInt();
        System.out.print("Conta de destino: ");
        int destino = scanner.nextInt();
        System.out.print("Valor da transferência: R$ ");
        double valor = scanner.nextDouble();
        
        gerenciador.transferir(origem, destino, valor);
    }

    private void listarContas() {
        gerenciador.listarContas();
    }

    private void calcularTributos() {
        double total = gerenciador.calcularTotalTributos();
        System.out.println("\n==================================================");
        System.out.printf("Total de tributos a recolher: R$ %.2f%n", total);
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.executar();
    }
}
