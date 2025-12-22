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
        if (Main.quantidadeDeCadastros == 10) { //Retorna para o menu principal caso lista esteja cheia
            System.out.println("Máximo de notas atingido, para adicionar uma nova nota, exclua outra já existente");
        }
        while (true) {
            PadroesDePagina.cabecalho("Cadastrar nova Nota");
            String tituloAtual = PedirDados.pedirTitulo();
            boolean tituloValido = ValidarDados.validarTitulo(tituloAtual);
            boolean tituloExiste = ValidarDados.validarSeTituloExiste(tituloAtual);
            if (!tituloValido) { //Validando Titulo, se invalido imprime a mensagem
                System.out.println("<Erro: Valor Inválido> Tente um título ue tenha entre 3 a 20 caractéres!");
                continue;
            }
            if (tituloExiste) { // Testa se o titulo já existe, se existe imprime a mensagem
                System.out.println("Erro: Título duplicado> Tente novamente!");
                continue;
            }
            String notaAtual = PedirDados.pedirDescricao(); //Pegando o conteúdo da anotação

            if (!tituloExiste && tituloValido) {
                int indexLivre = ValidarDados.verificarIndexLivre();
                ManipularDados.cadastrarTitulo(tituloAtual, indexLivre);
                ManipularDados.cadastrarNota(notaAtual, indexLivre);
                ManipularDados.cadastrarData(indexLivre);
                Main.quantidadeDeCadastros++;
                break;
            }
        }
    }

    public static void modificarNota() {
        while (true) {
            if (Main.quantidadeDeCadastros == 0) { // Se não houver cadastros ainda, volta para página inicial.
                System.out.println("Não há cadastros feitos ainda.");
                break;
            }
            PadroesDePagina.cabecalho("Alterar Nota");
            String tituloLocal = PedirDados.pedirTitulo();
            boolean tituloExiste = ValidarDados.validarSeTituloExiste(tituloLocal);
            int notaIndex = ValidarDados.encontrarIndex(tituloLocal);
            if (tituloExiste && notaIndex != -1) {
                String alteracao = PedirDados.pedirDescricao();
                Main.notas[notaIndex] = alteracao;
                System.out.println("Alteração feita com sucesso!");
                break;
            } else {
                System.out.println("<Erro: Valor inexistente> Essa nota não existe!");
            }

        }
    }

    public static void deletarNota() {
        while (true) {
            if (Main.quantidadeDeCadastros == 0) { // Se não houver cadastros ainda, volta para página inicial.
                System.out.println("Não há cadastros feitos ainda.");
                break;
            }
            PadroesDePagina.cabecalho("Deletar Nota");
            String tituloLocal = PedirDados.pedirTitulo();
            boolean tituloExiste = ValidarDados.validarSeTituloExiste(tituloLocal);
            int notaIndex = ValidarDados.encontrarIndex(tituloLocal);
            if (tituloExiste && notaIndex != -1) {
                ManipularDados.excluirNota(notaIndex);
                ManipularDados.excluirTitulo(notaIndex);
                ManipularDados.excluirData(notaIndex);
                Main.quantidadeDeCadastros--;
                break;
            }
        }
    }

    public static boolean encerrarPrograma() {
        PadroesDePagina.cabecalho("Encerrar Programa");
        String saida = PedirDados.confirmarSaida();
        if (saida.equals("Sair")) {
            return true;
        } else
            System.out.println("Continuando o programa!");
        return false;

    }

}