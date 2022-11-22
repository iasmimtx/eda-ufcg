
import java.util.Arrays;
import java.util.Scanner;

public class MyHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        HashSetInt lista = new HashSetInt(tamanho);
        String entrada = sc.nextLine();

        while (!entrada.equals("end")) {
            String[] entradah = entrada.split(" ");
            switch (entradah[0]) {
                case "put":
                    lista.put(Integer.parseInt(entradah[1]));
                    System.out.println(lista);
                    break;
                case "remove":
                    lista.remove(Integer.parseInt(entradah[1]));
                    System.out.println(lista);
                    break;
                case "contains":
                    System.out.println(lista.contains(Integer.parseInt(entradah[1])));
                    break;
            }
            entrada = sc.nextLine();
        }
    }
}


class HashSetInt {

    private Integer[] tabela;
    private int elementos;


    public HashSetInt(int tamanho) {
        this.tabela = new Integer[tamanho];
        this.elementos = 0;
    }

    private int hash(int chave) {
        return chave % tabela.length;
    }

    public void put(int element) {
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (hash(element) + sondagem) % tabela.length;
            if (tabela[hash] == null || tabela[hash].equals(element)) {
                tabela[hash] = element;
                return;
            }
            sondagem++;
        }
    }

    public boolean contains(int element) {
        try {
            boolean contem = false;
            int sondagem = 0;
            int hash;
            while (sondagem < tabela.length) {
                hash = (hash(element) + sondagem) % tabela.length;
                if (tabela[hash].equals(element)) {
                    contem = true;
                    break;
                }
                sondagem++;
            }
            return contem;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void remove(int element) {
        int sondagem = 0;
        int hash;
        while (sondagem <= tabela.length+1) {
            hash = (hash(element) + sondagem) % tabela.length;
            if (tabela[hash] != null && tabela[hash].equals(element)) {
                tabela[hash] = null;
                return;
            }
            sondagem++;
        }
    }

    public String toString() {
        return Arrays.toString(tabela);
    }

    public boolean isEmpty() {
        return (this.elementos == 0);
    }
}
