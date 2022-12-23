package algorithms_four_edition.chapter_1_3.stack_queue_bag;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node top;
    private int n = 0;


    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        n++;
    }

    public Item pop(){
        Item item = top.item;
        top = top.next;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        ListIterator iterator = new ListIterator();
        return iterator;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
