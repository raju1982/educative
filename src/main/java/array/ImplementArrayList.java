package array;

import java.util.Arrays;

public class ImplementArrayList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ImplementArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

}



/*
public class arrayListImpl{

  private int[] data;
  private int index;
  private int size;                 // defaul;t capacity

  public arrayListImpl(){
      size = 10;                    // default capacity
      data = new int[size];
      index=0;
  }

  public add(int num){
    if(index<data.length){
      data[index++]=num;
    }

    if(index==data.length){
        size=2*size;
        data = Arrays.copyOf(data, size);
        data[index++]=num;
    }

  }

  public get(int index){
    if(index >= size){
      return -1;
    }
    return data[index];
  }


}
 */