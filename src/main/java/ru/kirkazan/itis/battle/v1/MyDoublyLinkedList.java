package ru.kirkazan.itis.battle.v1;

/**
 * Created by Dasha on 14.05.2014.
 */
public class MyDoublyLinkedList<V> {

    private Element<V> head;
    private int length;

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Element<V> p = head;
        if (!this.isEmpty()) {
            while (p != null) {
                System.out.print(p.getValue());
                p = p.getNext();
            }
        } else {
            System.out.print("isEmpty!");
        }
        System.out.println();
    }

    public void add(V value) {
        if (this.isEmpty()) {
            head = new Element<V>();
            head.setValue(value);
            length=1;
            return;
        }
        Element p = head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        Element<V> temp = new Element<V>();
        temp.setValue(value);
        p.setNext(temp);
        length++;
    }


    public void removePos(int ind) throws ArrayIndexOutOfBoundsException {
        if (ind > length) {
            throw new ArrayIndexOutOfBoundsException("Ошибка в методе");
        }
        Element<V> p = head;
        int i = 1;
        if (ind == 1) {
            head = head.getNext();
        } else {
            while (i < ind - 1) {
                p = p.getNext();
                i++;
            }
        }
        p.setNext(p.getNext().getNext());
        length--;

    }

    public void removeLastElement() {
        Element<V> p = head;
        int i = 1;
        while (i < length - 1) {
            p = p.getNext();
            i++;
        }
        p.setNext(null);
        length--;

    }

    public void removeByValue(V value) {
        Element<V> p = head;
        int i = 1;
        if(p.getValue().equals(value)){
            head=head.getNext();
        }
        else {
            while (i < length) {
                if (p.getNext().getValue().equals(value)) {
                    p.setNext(p.getNext().getNext());
                    length--;
                    return;
                }
                p = p.getNext();
                i++;
            }
            if (i == length) {
                p.setNext(null);
            }
        }
        length--;
    }

    public void addToPos(int ind, V value) throws ArrayIndexOutOfBoundsException {
        if (ind > length||ind<1) {
            throw new ArrayIndexOutOfBoundsException("Ошибка в методе");
        }
        Element<V> p = head;
        int i;
        if (ind == 1) {
            Element<V> temp = head;
            Element<V> newEl = new Element<V>();
            newEl.setValue(value);
            head = newEl;
            head.setNext(temp);
        } else {
            i = 1;
            while (i < ind - 1) {
                p = p.getNext();
                i++;
            }
            Element<V> temp = p.getNext();
            Element<V> newElement = new Element<V>();
            newElement.setValue(value);
            p.setNext(newElement);
            newElement.setNext(temp);
        }
        length++;
    }

    public Element<V> getFromPos(int ind) throws ArrayIndexOutOfBoundsException {
        if (ind > length||ind<1) {
            throw new ArrayIndexOutOfBoundsException("Ошибка в методе");
        }
        Element<V> p = head;
        int i;
        if (ind == 1) {
           return head;
        } else {
            i = 2;
            while (i != ind) {
                p = p.getNext();
                i++;
            }
        }
        return p.getNext();
    }



    protected class Element<T> {

        private T value;
        private Element next;
        private Element previous;

        public T getValue() {
            return value;
        }

        public Element<T> getNext() {
            return next;
        }

        public Element<T> getPrevious() {
            return previous;
        }

        public void setValue(T x) {
            value = x;
        }

        public void setNext(Element<T> p) {
            next = p;
        }
    }

    public static void main(String[] args) {

        MyDoublyLinkedList<Integer> b = new MyDoublyLinkedList<Integer>();
        for (int i = 1; i <= 5; i++) {
            b.add(i);
        }
        b.printList();
        System.out.println(b.length);
        b.add(6);
        b.printList();
        System.out.println(b.length);
        b.addToPos(1, 0);
        b.printList();
        System.out.println(b.length);


        System.out.println(b.getFromPos(3).value);


        b.removeByValue(3);
        b.printList();
        System.out.println(b.length);
        b.removeLastElement();
        b.printList();
        b.removePos(1);
        b.printList();

        System.out.println(b.length);

    }

}
