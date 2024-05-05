import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int numero = scanner.nextInt();
        scanner.nextLine(); 
        return numero;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double numero = scanner.nextDouble();
        scanner.nextLine(); 
        return numero;
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
