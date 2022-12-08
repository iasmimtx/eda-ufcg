import java.util.Scanner;

public class EncaminhamentoArvoreBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);
        BST arvore = new BST();
        for (int valor : valores) {
            arvore.addRecursive(valor);
        }

        System.out.println(arvore.preOrder());
        System.out.println(arvore.order());
        System.out.println(arvore.posOrder());
    }

    private static int[] arrInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}

class BST {
    private Nod3 raiz;

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void addRecursive(int elemento) {
        if (isEmpty()) {
            this.raiz = new Nod3(elemento);
        } else {
            addRecursive(this.raiz, elemento);
        }
    }

    private void addRecursive(Nod3 node, int elemento) {
        if (elemento < node.value) {
            if (node.left == null) {
                Nod3 newNode = new Nod3(elemento);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            addRecursive(node.left, elemento);
        } else {
            if (node.right == null) {
                Nod3 newNo = new Nod3(elemento);
                node.right = newNo;
                newNo.parent = node;
                return;
            }
            addRecursive(node.right, elemento);
        }
    }


    public String preOrder() {
        return "[" + preOrder(raiz) + "]";

    }

    private String preOrder(Nod3 raiz) {
        String resultado = "";
        if (raiz != null) {
            resultado += raiz.value;
            if (raiz.left != null) {
                resultado +=  ", "  + preOrder(raiz.left) ;
            }
            if (raiz.right != null) {
                resultado += ", "  + preOrder(raiz.right);
            }
        }
        return resultado;
    }

    public String order() {
        return "[" + order(raiz) + "]";

    }

    private String order(Nod3 raiz) {
        String resultado = "";
        if (raiz != null) {
            if (raiz.left != null) {
                resultado += order(raiz.left) + ", "  ;
            }
            resultado += raiz.value;
            if (raiz.right != null) {
                resultado += ", "  + order(raiz.right);
            }
        }
        return resultado;
    }

    public String posOrder() {
        return "[" + posOrder(raiz) + "]";

    }

    private String posOrder(Nod3 raiz) {
        String resultado = "";
        if (raiz != null) {
            if (raiz.left != null) {
                resultado += posOrder(raiz.left) + ", "  ;
            }
            if (raiz.right != null) {
                resultado +=  posOrder(raiz.right) + ", ";
            }
            resultado += raiz.value;
        }
        return resultado;
    }

}

class Nod3 {

    int value;
    Nod3 left, right, parent;

    public Nod3(int v) {
        this.value = v;
    }
}
