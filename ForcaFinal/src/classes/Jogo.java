package classes;

import java.util.Random;

/**
 *
 * @author Pichau
 */
public class Jogo {

    private Palavra colecao[];
    private int erros;

    private Palavra sorteada;

    private int tentativas;

    private char letras[], letrasCertas[];

    private int totLetras;

    public Jogo() {
        colecao = new Palavra[10];
        montaColecao();
        sorteiaPalavra();
        letras = new char[sorteada.getPalavra().length() + 7];
        letrasCertas = new char[sorteada.getPalavra().length() + 1];
        totLetras = 0;
        tentativas = 6;
        trocaImagem();

    }

    public Palavra getSorteada() {
        return sorteada;
    }

    private void sorteiaPalavra() {
        Random sorteio = new Random();
        sorteada = colecao[sorteio.nextInt(colecao.length)];
    }

    private void montaColecao() {
        colecao[0] = new Palavra("cachorro", "4 patas");
        colecao[1] = new Palavra("lamparina", "Luz");
        colecao[2] = new Palavra("porta", "Abre e fecha");
        colecao[3] = new Palavra("paralelepipedo", "Rua");
        colecao[4] = new Palavra("vassoura", "Limpa");
        colecao[5] = new Palavra("java", "Programação");
        colecao[6] = new Palavra("carro", "Motorizado");
        colecao[7] = new Palavra("celular", "Eletrônico");
        colecao[8] = new Palavra("leiaute", "Design");
        colecao[9] = new Palavra("zebra", "Listrada");
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas() {
        tentativas--;
    }

    public void setLetrasCertas() {
        for (int i = 0; i < letrasCertas.length; i++) {
            letrasCertas[i] = '_';
        }
    }

    public String trocaImagem() {
        String imagem = "";
        switch (tentativas) {
            case 0:
                imagem = "/imagens/forca1.jpg";
                break;
            case 1:
                imagem = "/imagens/forca2.jpg";
                break;
            case 2:
                imagem = "/imagens/forca3.jpg";
                break;
            case 3:
                imagem = "/imagens/forca4.jpg";
                break;
            case 4:
                imagem = "/imagens/forca5.jpg";
                break;
            case 5:
                imagem = "/imagens/forca6.jpg";
                break;
            case 6:
                imagem = "/imagens/forca7.jpg";
                break;
        }
        return imagem;
    }

    public int adiciona(char letra) {
        if (tentativas > 0) {
            if (!existeLetra(letra)) {
                letras[totLetras] = letra;
                totLetras++;
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public boolean existeLetra(char letra) {
        for (int i = 0; i < totLetras; i++) {
            if (letras[i] == letra) {
                return true;
            }
        }
        return false;
    }

    public String letrasUsadas() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < totLetras; i++) {
            saida.append(letras[i]).append(" ");
        }

        return saida.toString();
    }

    public boolean acertos(char letra) {
        boolean acertou = false;
        int[] posiçoes = new int[letrasCertas.length];
        for (int i = 0; i < sorteada.getPalavra().length(); i++) {
            if (sorteada.getPalavra().charAt(i) == letra) {
                for (int j = 0; j < posiçoes.length; j++) {
                    posiçoes[j] = i;
                }
                for (int k = 0; k < letrasCertas.length; k++) {
                    letrasCertas[posiçoes[k]] = letra;
                }
                acertou = true;
            }
        }
        return acertou;
    }

    public boolean palavraFinal(String palavra) {
        if (sorteada.getPalavra().equalsIgnoreCase(palavra)) {
            return true;
        }
        setTentativas();
        return false;
    }

    public boolean perdeu() {
        if (tentativas == 0) {
            return true;
        }
        return false;
    }

    public String letrasAcertadas() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < letrasCertas.length - 1; i++) {
            saida.append(letrasCertas[i]).append(" ");
        }

        return saida.toString();
    }

}
