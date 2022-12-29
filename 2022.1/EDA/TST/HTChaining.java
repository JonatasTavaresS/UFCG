import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HTChaining {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TabelaHash tabelaHash = new TabelaHash(in.nextInt());
        while (true) {
            String[] operacao = in.nextLine().split(" ");
            if (operacao[0].equals("end")) {
                return;
            } else if (operacao[0].equals("put")) {
                tabelaHash.put(Integer.parseInt(operacao[1]), new Pair(Integer.parseInt(operacao[1]), operacao[2]));
                System.out.println(tabelaHash.toString());
            } else if (operacao[0].equals("keys")) {
                System.out.println(tabelaHash.keys());
            } else if (operacao[0].equals("values")) {
                System.out.println(tabelaHash.values());
            }
        }
    }
}

class TabelaHash {

    private ArrayList<Pair>[] tabela;

    public TabelaHash(int tamanho) {
        this.tabela = new ArrayList[tamanho];
    }

    public int hash(int chave) {
        return chave % this.tabela.length;
    }

    public void put(int chave, Pair valor) {
        int hash = this.hash(chave);
        ArrayList<Pair> pairs = this.tabela[hash];

        if (pairs == null) {
            pairs = new ArrayList<Pair>();
            pairs.add(valor);
            this.tabela[hash] = pairs;
        } else {
            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).getKey() == chave) {
                    pairs.set(i, valor);
                    return;
                }
            }
            pairs.add(valor);
        }
    }

    public Pair remove(int chave) {
        Pair removido = null;
        return removido;
    }

    public String keys() {
        String chaves = "[";
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                for (Pair pair : tabela[i]) {
                    if (chaves.equals("[")) {
                        chaves += pair.getKey();
                    } else {
                        chaves += ", " + pair.getKey();
                    }
                }
            }
        }
        return chaves + "]";
    }

    public String values() {
        String valores = "[";
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                for (Pair pair : tabela[i]) {
                    if (valores.equals("[")) {
                        valores += pair.getValue();
                    } else {
                        valores += ", " + pair.getValue();
                    }
                }
            }
        }
        ;
        return valores + "]";
    }

    @Override
    public String toString() {
        return Arrays.toString(tabela);
    }
}

class Pair {

    private int key;
    private String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }
}