import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamento {
    private List<Funcionario> funcionarios;
    private Scanner scanner;

    public SistemaGerenciamento() {
        this.funcionarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorMatricula(int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                return funcionario;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaGerenciamento sistema = new SistemaGerenciamento();
        sistema.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Buscar Funcionário por Nome");
            System.out.println("5. Buscar Funcionário por Matrícula");
            System.out.println("0. Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionarioMenu();
                    break;
                case 2:
                    removerFuncionarioMenu();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionarioPorNomeMenu();
                    break;
                case 5:
                    buscarFuncionarioPorMatriculaMenu();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void adicionarFuncionarioMenu() {
        System.out.println("\n=== Adicionar Funcionário ===");
        System.out.println("1. Adicionar Gerente");
        System.out.println("2. Adicionar Desenvolvedor");
        System.out.println("3. Adicionar Estagiário");
        System.out.println("0. Voltar");

        System.out.print("\nEscolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                adicionarGerente();
                break;
            case 2:
                adicionarDesenvolvedor();
                break;
            case 3:
                adicionarEstagiario();
                break;
            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public void adicionarGerente() {
        scanner.nextLine();

        System.out.println("\n=== Adicionar Gerente ===");
        System.out.print("Nome do gerente: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do gerente: ");
        int matricula = scanner.nextInt();
        System.out.print("Bônus anual do gerente: ");
        double bonusAnual = scanner.nextDouble();
        scanner.nextLine();

        Gerente gerente = new Gerente(nome, matricula, bonusAnual);
        adicionarFuncionario(gerente);
        System.out.println("Gerente adicionado com sucesso!");
    }

    public void adicionarDesenvolvedor() {
        scanner.nextLine();

        System.out.println("\n=== Adicionar Desenvolvedor ===");
        System.out.print("Nome do desenvolvedor: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do desenvolvedor: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, matricula);

        System.out.println("Adicione as tecnologias que o desenvolvedor domina (digite 'fim' para encerrar):");
        String tecnologia;
        do {
            System.out.print("Tecnologia: ");
            tecnologia = scanner.nextLine();
            if (!tecnologia.equalsIgnoreCase("fim")) {
                desenvolvedor.adicionarTecnologia(tecnologia);
            }
        } while (!tecnologia.equalsIgnoreCase("fim"));

        adicionarFuncionario(desenvolvedor);
        System.out.println("Desenvolvedor adicionado com sucesso!");
    }

    public void adicionarEstagiario() {
        scanner.nextLine();
        System.out.println("\n=== Adicionar Estagiário ===");
        System.out.print("Nome do estagiário: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do estagiário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Horas de trabalho do estagiário: ");
        int horasTrabalho = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do supervisor do estagiário: ");
        String nomeSupervisor = scanner.nextLine();

        Estagiario estagiario = new Estagiario(nome, matricula, horasTrabalho, nomeSupervisor);
        adicionarFuncionario(estagiario);
        System.out.println("Estagiário adicionado com sucesso!");
    }

    public void removerFuncionarioMenu() {
        scanner.nextLine();
        System.out.println("\n=== Remover Funcionário ===");
        System.out.print("Nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();
        Funcionario funcionario = buscarFuncionarioPorNome(nome);
        if (funcionario != null) {
            removerFuncionario(funcionario);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void buscarFuncionarioPorNomeMenu() {
        scanner.nextLine();
        System.out.println("\n=== Buscar Funcionário por Nome ===");
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        Funcionario funcionario = buscarFuncionarioPorNome(nome);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void buscarFuncionarioPorMatriculaMenu() {
        scanner.nextLine();
        System.out.println("\n=== Buscar Funcionário por Matrícula ===");
        System.out.print("Matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        Funcionario funcionario = buscarFuncionarioPorMatricula(matricula);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}