public class ValidarDados {

    static boolean validarTitulo(String titulo) {
        if (titulo.length() > 3 && titulo.length() < 21) {
            return true;
        } else {
            return false;
        }

    }

    static boolean validarSeTituloExiste(String titulo, String[] lista) {
        boolean status = false;
        for (String tituloTemp : lista) {
            if (tituloTemp == titulo) {
                status = false;
                break;
            } else {
                status = true;
            }
        }
        return status;
    }

}
