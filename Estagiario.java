public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalho;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasTrabalho, String supervisor) {
        super(nome, matricula);
        this.horasTrabalho = horasTrabalho;
        this.supervisor = supervisor;
    }

    public int getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {
        return 600.0 + horasTrabalho * 10.0;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso do estagiário...");
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Matrícula: " + getMatricula() + ", Salário: R$" + calcularSalario();
    }
}
