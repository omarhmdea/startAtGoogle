package Exercises.week1.JavaBasics1.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Stack<T> {

    private Object[] items;
    private int size;
    private final int INITIAL_SIZE = 1;


    public Stack() {
        items = new Object[INITIAL_SIZE];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T)items[size - 1];
    }

    public void push(T item) {
        if (size == items.length) {
            increaseCapacity();
        }
        items[this.size++] = item;
    }

    public T pop() {
        T item = this.top();
        this.size--;

        return item;
    }

    private void increaseCapacity() {
        Object[] newArr = new Object[items.length * 2];

        for (int i = 0; i < items.length; i++) {
            newArr[i] = items[i];
        }

        items = newArr;
    }


}
