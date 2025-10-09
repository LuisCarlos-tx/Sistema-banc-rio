import java.util.Scanner;

public class Main {
    private GerenciadorContas gerenciador;
    private Scanner scanner;

    public Main() {
        this.gerenciador = new GerenciadorContas();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> realizarDeposito();
                case 3 -> realizarSaque();
                case 4 -> realizarTransferencia();
                case 5 -> listarContas();
                case 6 -> calcularTributos();
                case 7 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.executar();
    }
}
