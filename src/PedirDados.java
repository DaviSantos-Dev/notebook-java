import java.util.Scanner;

public class PedirDados {
    static Scanner scan = new Scanner(System.in);

    static String pedirTitulo() {
        System.out.println("Digite o Titulo: ");
        return scan.nextLine();
    }

    static String pedirDescricao() {
        System.out.println("Digite o descricao: ");
        return scan.nextLine();
    }

    static String confirmarSaida() {
        while (true) {
            System.out.println("Realmente deseja sair? (S/N)");
            String saida = scan.nextLine();
            if (saida.equals("S")) {
                return "Sair";
            } else if (saida.equals("N")) {
                return "Não sair";
            } else {
                System.out.println("<ERRO: Valor Inválido> Favor tente novamente.");
            }
        }
    }

    static int pedirEntrada() {
        System.out.println("Qual sua opção? ");
        int entrada = Integer.parseInt(scan.nextLine());
        return entrada;
    }
}
