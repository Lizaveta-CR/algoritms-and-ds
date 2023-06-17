package test.queue;

public class QueueArr {
    int begin;
    int top;
    int[] data;

    public QueueArr(int size) {
        data = new int[size];
        top = -1;
        begin = -1;
    }

    public boolean isEmpty() {
        return begin == -1 || begin == data.length;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public void enQueue(int val) {
        if (isFull()) {
            return;
        } else if (isEmpty()) {
            begin++;
            top++;
            data[top] = val;
        } else {
            top++;
            data[top] = val;
        }
    }

    public int deQueue() {
        if (!isEmpty()) {
            int val = data[++begin];
            if (begin > top) {
                begin = top = -1;
            }
            return val;
        }
        throw new RuntimeException();
    }

    public int peek() {
        if (!isEmpty()) {
            return data[begin];
        }
        throw new RuntimeException();
    }

    public void delete() {
        data = null;
    }

    public static void main(String[] args) {
        QueueArr qA = new QueueArr(4);
        qA.enQueue(1);
        qA.enQueue(2);
        qA.enQueue(3);
        System.out.println(qA.peek());
        qA.deQueue();
        System.out.println(qA.peek());
    }
}
