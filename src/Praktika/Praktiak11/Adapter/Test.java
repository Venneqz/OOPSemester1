package Praktika.Praktiak11.Adapter;

public class Test {
    public static void main(String[] args) {
        StackAdapter<Integer> stack = new StackAdapter<>();
        System.out.println("Empty: " + stack.empty());
        System.out.println("Push: " + stack.push(1));
        System.out.println("Push: " + stack.push(2));
        System.out.println("Push: " + stack.push(3));
        System.out.println("Empty: " + stack.empty());

        System.out.println("Stack currently: " + stack.toString());

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
    }
}
