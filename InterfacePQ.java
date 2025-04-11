/*
*Interfaz para las las heaps 
*/

import java.util.Iterator;

public interface InterfacePQ<E> {
    boolean offer(E e);

    E poll();

    E peek();

    int size();

    Iterator<E> iterator();
}