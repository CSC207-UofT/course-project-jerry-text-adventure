package presenter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Presenter {
    protected Queue<String> messageQueue;

    public Presenter() {
        this.messageQueue = new ArrayDeque<>();
    }

    public void addToQueue(String s) {
        messageQueue.add(s);
    }

    public void addToQueue(List<String> strings) {
        messageQueue.addAll(strings);
    }

    public void print() {
        System.out.println(messageQueue.poll());
    }

    public void printAll() {
        while (!messageQueue.isEmpty()) {
            print();
        }
    }

    public void printAllEnum() {
        int i = 1;
        while (!messageQueue.isEmpty()) {
            System.out.print(i + ". ");
            print();
            i += 1;
        }
    }

    public void notValid() {
        System.out.println("This is not a valid input.");
    }
}