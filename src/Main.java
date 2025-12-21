import java.time.LocalDateTime;

public class Main {

    //Iniciando variáveis "globais"
    public static String[] titulos = new String[10];
    public static String[] notas = new String[10];
    public static LocalDateTime[] datas = new LocalDateTime[10];
    public static int quantidadeDeCadastros = 0;

    public static void main(String[] args) {
        //Funções do programa
        String[] funcoesDoPrograma = {"Ver Notas", "Cadastrar nova Nota", "Modificar Nota",
                "Deletar Nota", "Encerrar Programa"};

        //Iniciando variáveis do metodo
        boolean saida = false;


        //Loop Principal do Programa
        while (!saida) {
            Paginas.menuPrincipal(funcoesDoPrograma);
            int entrada = PedirDados.pedirEntrada();
            switch (entrada) {
                case 1:
                    Paginas.lerNotas();
                    break;
                case 2:
                    Paginas.cadastrarNotas();
                    break;
            }
        }

    }
}
