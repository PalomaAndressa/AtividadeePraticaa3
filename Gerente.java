public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;

    public Gerente(String nome, int matricula, double bonusAnual) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public void setBonusAnual(double bonusAnual) {
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double calcularSalario() {
        // Lógica para calcular o salário do gerente
        // Exemplo simples apenas para compilar
        return 5000.0 + bonusAnual; // Exemplo simples de cálculo
    }

    @Override
    public void trabalhar() {
        // Implementação específica para o trabalho do gerente
        System.out.println("Gerente trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        // Implementação específica para relatar progresso do gerente
        System.out.println("Relatando progresso do gerente...");
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Matrícula: " + getMatricula() + ", Salário: R$" + calcularSalario() + ", Bonus Anual: R$" + bonusAnual;
    }
}
