/*
*Interfaz para las clases que utilizan la cola de prioridad
*/

import java.util.Iterator;

public interface PriorityQueue<E> {
    boolean offer(E e);

    E poll();

    E peek();

    int size();

    Iterator<E> iterator();
}