import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[] simbolos = {'X', 'O'};
        int posicao = 0;
        boolean ganhou = false;
        String tab = Tabuleiro.tabuleiro();
        Scanner leitor = new Scanner(System.in);
        char[] arrayTab;
        int n = 0;
        int j;

        inicializa();

        String[] jogadores = Jogador.getJogador(leitor, tab);
        Jogador.mostraJogardores(jogadores, simbolos);

        while (!ganhou) {
            n = n + 2;
            for (int i = 0; i < jogadores.length; i++) {
                String jogador = jogadores[i];
                char simbolo = simbolos[i];
                System.out.println("Vez da " + jogador);
                posicao = Jogador.getJogadas(leitor, tab);
                arrayTab = Tabuleiro.tabToArray(tab);



                if (posicao > 9 || posicao < 1) {
                    System.out.println("O jogo só aceita números entre 1 e 9");
                    i--;

                    continue;
                }

                j = posicao -1;
                while (arrayTab[j] == 'X' || arrayTab[j] == 'O') {
                    System.out.println("Posição já selecionada, tente outra");
                    posicao = Jogador.getJogadas(leitor, tab);
                    j = posicao -1;

                }

                tab = Tabuleiro.mudaTabuleiro(tab, posicao, simbolo);
                arrayTab = Tabuleiro.tabToArray(tab);
                ganhou = Ganhou.ganhou(arrayTab, jogador, tab);


                    if (ganhou) {
                        System.out.println("Quer jogar outra partida? s/n");
                        char resposta = leitor.next().charAt(0);
                        if (Character.toLowerCase(resposta)== 's')

                        {
                        System.out.println("|---------------Iniciando outra partida----------------|" );

                        Jogador.mostraJogardores(jogadores, simbolos);
                        tab = Tabuleiro.tabuleiro();
                        n = 0;
                        ganhou = false;
                        break;

                        }
                        else if (Character.toLowerCase(resposta)== 'n')
                        {
                            System.out.println("|---------------Encerrando Jogo--------------|");
                            break;
                        }


                    }
                    if (n == 10) {
                        System.out.println(tab);
                        System.out.println("Deu velhaa!!");
                        System.out.println("Quer jogar outra partida? s/n");
                        char resposta = leitor.next().charAt(0);
                        if (Character.toLowerCase(resposta)== 's') {
                            Jogador.mostraJogardores(jogadores, simbolos);
                            tab = Tabuleiro.tabuleiro();
                            System.out.println("|---------------Iniciando outra partida--------------|");
                            n = 0;

                        } else if (Character.toLowerCase(resposta)== 'n') {

                            System.out.println("|---------------Encerrando Jogo--------------|");
                            break;

                        }
                        break;
                    }
                System.out.println(tab);

            }
        }
    }

    private static void inicializa() {
        System.out.println("|-----------------------------------------------------|");
        System.out.println("|--------------------JOGO DA VELHA--------------------|");
        System.out.println("|-----------------------------------------------------|");

    }
}