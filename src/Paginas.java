public class Paginas {

    public static void menuPrincipal(String[] opcoes) {
        PadroesDePagina.cabecalho("    MENU PRINCIPAL");
        System.out.println("Escolha sua opção: ");
        for (int opc = 0; opc < opcoes.length; opc++) {
            System.out.printf(" %d - %s\n", (opc + 1), opcoes[opc]);
        }
    }

    public static void lerNotas() {
        PadroesDePagina.cabecalho("Notas Salvas");
        for (int opc = 0; opc < Main.titulos.length; opc++) {
            if (Main.titulos[opc] != null) {
                System.out.println("Nota número: " + (opc + 1));
                PadroesDePagina.linhas();
                System.out.println("Título: " + Main.titulos[opc]);
                System.out.println("Anotação: " + Main.notas[opc]);
                System.out.println("Data da anotação: " + Main.datas[opc]);
                PadroesDePagina.linhas();
            }
        }
    }

    public static void cadastrarNotas() {
        while (true) {
            PadroesDePagina.cabecalho("Cadastrar nova Nota");
            String tituloAtual = PedirDados.pedirTitulo();
            boolean tituloValido = ValidarDados.validarTitulo(tituloAtual);
            boolean titulUnico = ValidarDados.validarSeTituloExiste(tituloAtual, Main.titulos);
            if (!tituloValido) { //Validando Titulo, se invalido imprime a mensagem
                System.out.println("<Erro: Valor Inválido> Tente um título ue tenha entre 3 a 20 caractéres!");
                continue;
            }
            if (!titulUnico) { // Testa se o titulo já existe, se existe imprime a mensagem
                System.out.println("Erro: Título duplicado> Tente novamente!");
                continue;
            }
            String notaAtual = PedirDados.pedirDescricao(); //Pegando o conteúdo da anotação

            if (titulUnico && tituloValido) {
                ManipularDados.cadastrarTitulo(tituloAtual, Main.quantidadeDeCadastros);
                ManipularDados.cadastrarNota(notaAtual, Main.quantidadeDeCadastros);
                ManipularDados.cadastrarData(Main.quantidadeDeCadastros);
                Main.quantidadeDeCadastros++;
                break;
            }


        }
    }
}