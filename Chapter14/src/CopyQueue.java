import java.util.LinkedList;
import java.util.Queue;

public class CopyQueue {
    public static void main(String[] args) {
        Stack<Integer> mainStack = new Stack<Integer>();
        mainStack.push(1);
        mainStack.push(8);
        mainStack.push(7);
        mainStack.push(2);
        mainStack.push(9);
        mainStack.push(18);
        mainStack.push(12);
        mainStack.push(0);
        copyQueueToStack(mainStack);
    }
    public static void copyQueueToStack(Stack<Integer> s1) {
        Queue<Integer> q = new LinkedList<Integer>();

        while (!s1.empty()) {
            q.add(s1.pop());
        }
        while (!q.isEmpty()) {
            s1.push(q.remove());
        }
        while (!s1.empty()) {
            q.add(s1.pop());
        }
        System.out.println(q);
    }
}
