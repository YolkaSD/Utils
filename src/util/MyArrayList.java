package util;

import java.util.Arrays;



public class MyArrayList<E> implements MyList<E>{
    //The field responsible for the size of the dynamic array be default
    private static final int DEFAULT_CAPACITY = 10;

    //The field that stores all elements of the collection
    transient Object[] elementData;

    //A counter field that stores the number of elements actually in the array
    private int size;

    //
    public final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
    //
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    //Constructs an empty list with the specified initial capacity.
    //Parameter: initialCapacity - the initial capacity of the list from 0 to java.lang.Integer.MAX_VALUE
    //Throws: IllegalArgumentException – if the specified initial capacity is negative
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

    }

    public void checkOf(){
        System.out.println("elementData: " + Arrays.toString(elementData));
        System.out.println("elementData.length: " + elementData.length);
        System.out.println("size: " + size);
    }

    @Override
    public void add(E element) {
        if (size == elementData.length)
            elementData = grow();
        elementData[size] = element;
        size++;
        checkOf();
    }
    @Override
    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (size == elementData.length)
            elementData = grow();
        elementData[index] = element;
        size++;
        checkOf();
    }

    private Object[] grow() {
        if (elementData.length > 0 || elementData != EMPTY_ELEMENTDATA) {
            int newCapacity = elementData.length * 2;
            return elementData = MyArray.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[DEFAULT_CAPACITY];
        }
    }



    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
