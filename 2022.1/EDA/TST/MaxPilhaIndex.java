import java.util.Scanner;

class MaxPilhaIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] array = in.nextLine().split(" ");
        int N = in.nextInt();
        in.close();
        Stack pilha = new Stack(array.length);
        for (String value : array) {
            pilha.push(Integer.parseInt(value));
        }
        int max = pilha.pop();
        for (int i = array.length - 2; i >= array.length - N - 1; i--) {
            if (pilha.peek() > max) {
                max = pilha.peek();
            }
            pilha.pop();
        }
        System.out.println(max);
    }

}

class Stack {

    private int[] array;
    private int peek;

    public Stack(int length) {
        this.array = new int[length];
        this.peek = -1;
    }

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("Stack Empty");
        return this.array[this.peek];
    }

    public boolean isEmpty() {
        return this.peek == -1;
    }

    public boolean isFull() {
        return this.peek == this.array.length;
    }

    public void push(int value) {
        if (this.isFull())
            throw new RuntimeException("Stack Overflow");
        this.array[++this.peek] = value;
    }

    public int pop() {
        if (this.isEmpty())
            throw new RuntimeException("Stack Empty");
        return this.array[this.peek--];
    }

}