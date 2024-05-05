import java.util.ArrayList;
import java.util.List;

public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private List<String> tecnologias;

    public Desenvolvedor(String nome, int matricula) {
        super(nome, matricula);
        this.tecnologias = new ArrayList<>();
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void adicionarTecnologia(String tecnologia) {
        this.tecnologias.add(tecnologia);
    }

    @Override
    public double calcularSalario() {
        
        return 2000.0;
    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso do desenvolvedor...");
    }
}
