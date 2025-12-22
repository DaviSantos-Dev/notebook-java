public class ValidarDados {

    static boolean validarTitulo(String titulo) {
        if (titulo.length() > 3 && titulo.length() < 21) {
            return true;
        } else {
            return false;
        }

    }

    static boolean validarSeTituloExiste(String titulo) {
        boolean status = false;
        for (String tituloTemp : Main.titulos) {
            if (titulo.equals(tituloTemp)) {
                status = true;
                break;
            } else {
                status = false;
            }
        }
        return status;
    }

    static int encontrarIndex(String notaDeBusca) {
        for (int i = 0; i < Main.titulos.length; i++) {
            if (notaDeBusca.equals(Main.titulos[i])) {
                return i;
            }
        }
        return -1;
    }

    static int verificarIndexLivre() {
        for (int i = 0; i < Main.titulos.length; i++) {
            if (Main.titulos[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
