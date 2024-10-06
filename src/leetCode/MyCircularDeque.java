package leetCode;

/*
    https://leetcode.com/problems/design-circular-deque/?envType=daily-question&envId=2024-09-28
 */
public class MyCircularDeque {
    private int[] dq;
    private int size;
    private int index_front;
    private int index_back;

    public MyCircularDeque(int k) {
        size = k;
        index_front = 0;
        index_back = k - 1;

        //init deque
        dq = new int[k];
        for (int i = 0; i < k; ++i) {
            dq[i] = -1;
        }
    }

    public boolean insertFront(int value) {
        //if target index is already taken (== full)
        if (dq[index_front] != -1) {
            return false;
        }

        //if caller is isfull(). check full and return true directly.
        //Must not do any action
        if (value == -1) {
            return true;
        }
        dq[index_front] = value;
        index_front = (index_front + 1) % size;
        return true;
    }

    public boolean insertLast(int value) {
        //if target index is already taken (== full)
        if (dq[index_back] != -1) {
            return false;
        }
        //if caller is isfull(). check full and return true directly.
        //Must not do any action
        if (value == -1) {
            return true;
        }
        dq[index_back] = value;
        index_back = (index_back - 1 + size) % size;
        return true;
    }

    public boolean deleteFront() {
        int targetIndex = (index_front - 1 + size) % size;
        if (dq[targetIndex] == -1) {
            return false;
        }

        dq[targetIndex] = -1;
        index_front = targetIndex;
        return true;
    }

    public boolean deleteLast() {
        int targetIndex = (index_back + 1) % size;
        if (dq[targetIndex] == -1) {
            return false;
        }

        dq[targetIndex] = -1;
        index_back = targetIndex;
        return true;
    }

    public int getFront() {
        return dq[(index_front - 1 + size) % size];
    }

    public int getRear() {
        return dq[(index_back + 1) % size];
    }

    public boolean isEmpty() {
        return getFront() == -1 && getRear() == -1;
    }

    public boolean isFull() {
        return !insertFront(-1) && !insertLast(-1);
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(77);
        deque.insertFront(89);
        deque.getRear();
        deque.deleteLast();
        deque.getRear();
        deque.insertFront(19);
        deque.insertFront(23);
        deque.insertFront(23);
        deque.insertFront(82);
        deque.isFull();
        deque.insertFront(45);
        deque.isFull();
        deque.getRear();
        deque.deleteLast();
        deque.getFront();
        deque.getFront();
        deque.insertLast(74);
        deque.deleteFront();
        deque.getFront();
        deque.insertLast(98);
        deque.getRear();
        deque.insertLast(99);
        deque.getRear();
        deque.getFront();
        deque.getFront();
        deque.getFront();
        deque.getRear();
        deque.getRear();
        deque.insertFront(8);
        deque.getFront();
        deque.getFront();
        deque.getFront();
        deque.getFront();
        deque.deleteFront();
        deque.insertFront(75);
        deque.getFront();
        deque.deleteLast();
        deque.insertLast(35);
        deque.insertLast(59);
        deque.getRear();
        deque.getRear();
        deque.getRear();
        deque.isEmpty();
        deque.insertFront(22);
        deque.deleteLast();
        deque.getFront();
        deque.deleteLast();
        deque.getRear();
        deque.getFront();
        deque.isFull();
        deque.isFull();
        deque.deleteFront();
        deque.getFront();
        deque.deleteLast();
        deque.getRear();
        deque.insertFront(21);
        deque.getFront();
        deque.insertFront(26);
        deque.insertFront(63);
        deque.getRear();
        deque.isFull();
        deque.getFront();
        deque.getFront();
        deque.insertFront(87);
        deque.insertLast(76);
        deque.getRear();
        deque.getRear();
        deque.deleteLast();
        deque.insertFront(26);
        deque.getRear();
        deque.insertLast(67);
        deque.getFront();
        deque.getFront();
        deque.getFront();
        deque.getRear();
        deque.insertFront(36);
        deque.isEmpty();
        deque.getFront();
        deque.getFront();
        deque.insertFront(72);
        deque.deleteFront();
        deque.insertFront(87);
        deque.deleteLast();
        deque.getFront();
        deque.getRear();
        deque.getFront();
        deque.insertFront(85);
        deque.getFront();
        deque.deleteFront();
        deque.insertFront(91);
        deque.isEmpty();
        deque.getRear();
        deque.getRear();
        deque.getRear();
        deque.getRear();
        deque.deleteFront();
        deque.getRear();
        deque.isEmpty();
        deque.deleteFront();
        deque.insertFront(34);
        deque.insertLast(44);
        deque.deleteLast();
    }
}
