import java.io.*;
import java.util.*;

class nodeA {
    int name;
    long val = 1;
    int isVisited = 0;
    ArrayList<nodeA> next = new ArrayList<>();

    public nodeA(int name) {
        this.name = name;
    }
}

public class A2a {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int num = in.nextInt();
        nodeA[] array = new nodeA[num];
        for (int i = 1; i <= num; i++) {
            array[i - 1] = new nodeA(i);
        }
        for (int i = 1; i <= num - 1; i++) {
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            array[a].next.add(array[b]);
            array[b].next.add(array[a]);
        }
        Queue<nodeA> queue = new LinkedList<>();
        queue.add(array[0]);
        array[0].isVisited = 1;
        long answer = 1;
        while (!queue.isEmpty()) {
            int cal = 0;
            for (int i = 0; i < queue.element().next.size(); i++) {
                if (queue.element().next.get(i).isVisited == 0) {
                    queue.element().next.get(i).isVisited = 1;
                    queue.add(queue.element().next.get(i));
                    cal++;
                    queue.element().val = queue.element().val * cal % 998244353;
                }
            }
            queue.remove();
        }
        for (int i = 0; i < array.length; i++) {
            answer = answer * array[i].val % 998244353;
        }
        out.println(answer % 998244353);
        out.close();
    }
}

