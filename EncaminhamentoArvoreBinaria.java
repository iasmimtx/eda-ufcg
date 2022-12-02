import java.util.Scanner;

public class EncaminhamentoArvoreBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);


    }

    private static int[] arrInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return  saida;
    }


}

class BST{
    private Nod3 raiz;


    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void addRecusrive(int elemento){
        if(isEmpty()){
            this.raiz = new Nod3(elemento);
        } else {
            addRecusrive(this.raiz, elemento);
        }
    }

    private void addRecusrive(Nod3 raiz, int elemento) {

    }

}


class Nod3 {

    int value;
    Nod3 lef, right, parent;

    public Nod3(int v) {
        this.value = v;
    }
}
