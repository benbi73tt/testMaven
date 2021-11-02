package ru.madbrains.simpleList;

import java.util.Comparator;
import java.util.Optional;

public interface SimpleList<T> {

    void add(T item) throws NoEntityException;
    void insert(int index, T item) throws Exception;
    void remove(int index) throws Exception;
    Optional<T> get(int index) throws ArrayIndexOutOfBoundsException, NoEntityException;
    int size();
    void addAll(SimpleList<T> list) throws ArrayIndexOutOfBoundsException, NoEntityException;
    int first(T item);
    int last(T item);
    boolean contains(T item);
    boolean isEmpty();
    SimpleList<T> shuffle() throws NoEntityException;
    SimpleList<T> sort(Comparator<T> comparator) throws NoEntityException;

}
