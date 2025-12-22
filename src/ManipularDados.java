import java.time.LocalDateTime;

public class ManipularDados {

    static void cadastrarTitulo(String tituloTemp, int index) {
        Main.titulos[index] = tituloTemp;
    }

    static void cadastrarNota(String notaTemp, int index) {
        Main.notas[index] = notaTemp;
    }

    static void cadastrarData(int index) {
        Main.datas[index] = LocalDateTime.now();
    }

    static void excluirTitulo(int index) {
        Main.titulos[index] = null;
    }

    static void excluirNota(int index) {
        Main.notas[index] = null;
    }

    static void excluirData(int index) {
        Main.datas[index] = null;
    }
}
