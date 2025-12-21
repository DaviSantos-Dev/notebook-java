import java.time.LocalDateTime;

public class ManipularDados {

    static String[] cadastrarTitulo(String tituloTemp, int index) {
        Main.titulos[index] = tituloTemp;
        return Main.titulos;
    }

    static String[] cadastrarNota(String notaTemp, int index) {
        Main.notas[index] = notaTemp;
        return Main.notas;
    }

    static LocalDateTime[] cadastrarData (int index) {
        Main.datas[index] = LocalDateTime.now();
        return Main.datas;
    }
}



