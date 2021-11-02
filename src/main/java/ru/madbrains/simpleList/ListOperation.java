package ru.madbrains.simpleList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

public class ListOperation<T> implements SimpleList<T> {

    private T[] arr;
    private String name;
    private int size;

    public ListOperation(String name, int maxSize) {
        this.arr = (T[]) new Object[maxSize];
        this.name = name;
    }

    public ListOperation() {

    }

    public void checkNull(T item) throws NoEntityException {
        if (item == null) {
            throw new NoEntityException("Добавляемый элемент равен null");
        }
    }

    public void assignmentClass(T item) {
        if (arr == null) {
            this.arr = (T[]) new Object[0];
        }
    }

    public void exten(int count) {
        this.arr = Arrays.copyOf(arr, size + count);
    }

    public void exten() {
        this.arr = Arrays.copyOf(arr, (size + 1) * 2);
    }

    @Override
    public void add(T item) throws NoEntityException {
        checkNull(item);
        assignmentClass(item);
        if (arr.length <= size) {
            exten();
        }
        arr[size] = item;
        size++;
    }

    @Override
    public void insert(int index, T item) throws ArrayIndexOutOfBoundsException, NoEntityException {
        checkNull(item);
        assignmentClass(item);
        if (arr.length <= size) {
            exten();
        }
        if (index > -1 && index <= size) {
            System.arraycopy(arr, index, arr, index + 1, size() - index);
            arr[index] = item;
            size++;
        } else
            throw new ArrayIndexOutOfBoundsException(item + " не может быть добавлен, index'a " + index
                    + " не существует, измените значение");

    }

    @Override
    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index > -1 && index < size()) {
            System.arraycopy(arr, index + 1, arr, index, size() - index - 1);
//todo      swap(arr,size() - 1 ,index);
            arr[size() - 1] = null;
            size--;
        } else
            throw new ArrayIndexOutOfBoundsException("элемент под index " + index
                    + " не существует, измените значение");
    }

    @Override
    public String toString() {
        return "ListOperation {" +
                "Name = '" + name + '\'' +
                "  Size = '" + size + '\'' +
                '}';
    }


    @Override
    public Optional<T> get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > -1 && index < size())
            return Optional.ofNullable(arr[index]);
        else
            throw new ArrayIndexOutOfBoundsException("Вызываемого элемента под индексом " + index
                    + " не существует, измените значение");
    }

    //todo встречается ли null в листе...
    public Optional<T> getNoNull(int index) throws ArrayIndexOutOfBoundsException {
        Optional.ofNullable(arr[index]).orElseThrow(() -> new ArrayIndexOutOfBoundsException(
                "Вызываемого элемента " + index
                        + " не существует или он null, измените значение "));
        return Optional.ofNullable(arr[index]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int first(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public int last(T item) {
        for (int i = size; i >= 0; i--) {
            if (item.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(arr[i])) return true;
        }
        return false;
    }

    @Override
    public void addAll(SimpleList<T> list) throws ArrayIndexOutOfBoundsException, NoEntityException {
        exten(list.size());
        for (int i = 0; i < list.size(); i++)
            add(list.get(i).get());
    }

    @Override
    public boolean isEmpty() {
        return (size > 0);
    }

    @Override
    public SimpleList<T> shuffle() throws NoEntityException {
        if (size < 2) {
            throw new NoEntityException("Количество элементов недостаточно");
        }
        SimpleList shuf = new ListOperation("Shuffle" + name, size);
        int[] t = new int[size];
        for (int i = 0; i < size; i++) {
            t[i] = i;
        }
        Random rnd = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rnd.nextInt(i);
            int k = t[i];
            t[i] = t[j];
            t[j] = k;
        }
        for (int i = 0; i < size; i++) {
            shuf.add(arr[t[i]]);
        }
        return shuf;
    }

    public void swap(T[] x, int a, int b) {
        T t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public T[] quickSort(T[] buf, int low, int high, Comparator<T> comparator) {
        if (size == 0)
            return buf;

        if (low >= high)
            return buf;

        int middle = low + (high - low) / 2;
        T opora = buf[middle];
        int i = low, j = high;

        while (i <= j) {
            while (comparator.compare(opora, buf[i]) > 0) {
                i++;
            }

            while (comparator.compare(opora, buf[j]) < 0) {
                j--;
            }

            if (i <= j) {
                swap(buf, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(buf, low, j, comparator);

        if (high > i)
            quickSort(buf, i, high, comparator);
        return buf;
    }

    @Override
    public SimpleList<T> sort(Comparator<T> comparator) throws NoEntityException {
        if (size < 2) {
            throw new NoEntityException("Количество элементов недостаточно");
        }
        ListOperation sortin = new ListOperation("Sorting" + name, size);
        T[] temporaryArray = Arrays.copyOf(arr, size);
        temporaryArray = quickSort(temporaryArray, 0, size - 1, comparator);
        for (int i = 0; i < size; i++) {
            sortin.add(temporaryArray[i]);
        }
        return sortin;
    }
}


