import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Predecessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = arrInteiros(sc);
        int pred = sc.nextInt();
        BST arvore = new BST();

        for (int valor : valores) {
            arvore.addRecursive(valor);
        }
        System.out.println(arvore.predecessor(pred));
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
    private Node raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void addRecursive(int elemento) {
        if (isEmpty()) {
            this.raiz = new Node(elemento);
        } else {
            addRecursive(this.raiz, elemento);
        }
    }

    private void addRecursive(Node node, int elemento) {
        if (elemento < node.value) {
            if (node.left == null) {
                Node newNode = new Node(elemento);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            addRecursive(node.left, elemento);
        } else {
            if (node.right == null) {
                Node newNo = new Node(elemento);
                node.right = newNo;
                newNo.parent = node;
                return;
            }
            addRecursive(node.right, elemento);
        }
    }

    public List<Integer> predecessor(int element) {
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(element);

        Node node = search(element);
        if (node.left != null) {
            max(node.left, lista);
        } else {
            Node aux = node.parent;
            while (aux != null && node.equals(aux.left)) {
                node = aux;
                lista.add(node.value);
                aux = aux.parent;
            }
            if (aux != null) {
                lista.add(aux.value);
            }
        }
        return lista;
    }


    public Node max() {
        Node result = null;
        if (!isEmpty()) {
            result = maxrec(raiz);
        }
        return result;
    }

    private Node maxrec(Node node) {
        Node result = node;
        if (node.right != null) {
            result = maxrec(node.right);
        }
        return result;
    }

    private Node max(Node node, List<Integer> lista) {
        Node result = node;
        lista.add(result.value);
        if (node.right != null) {
            result = maxrec(node.right);
            lista.add(result.value);
        }
        return result;
    }

    private Node search(int element) {
        return searchrec(this.raiz, element);
    }

    private Node searchrec(Node node, int element) {
        if (node == null) return null;
        if (node.value == element) return node;
        if (element < node.value) return searchrec(node.left, element);
        else return searchrec(node.right, element);
    }


}

class Node {

    int value;
    Node left, right, parent;

    public Node(int v) {
        this.value = v;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

}
