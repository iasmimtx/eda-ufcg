public class Pilha {
    private int topo;
    private int capacidade;
    private int[] pilha;

    
    public Pilha(int capacidade){
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    //capacidade- 1 pois a pilha começa do zero
    public  boolean isFull(){
        return this.topo == this.capacidade-1;  
    }

    //adiciona no final da pilha o valor de n.
    public void push(int n){
        if(this.isFull()){
        throw new RuntimeException("Pilha Cheia!");
        }
        pilha[++this.topo] = n;  // this.topo += 1   pilha[topo] = n; 
    }

    //remove e retrona o último elemento da pilha
    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pilha Vazia!");
        }
        int valor = pilha[this.topo--];  // int valor = pilha[this.topo]      topo -= 1    return valor;
        return valor;
    }

    // retorna o topo da pilha
    public int peek(){
        if(this.isEmpty()) {
            throw new RuntimeException("Pilha Vazia!");
        }
        int valor = pilha[this.topo];
        return valor;
    }

    public int size() {
        return this.topo+1;
    }

}
