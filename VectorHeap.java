/*
 * Clade de Vector Heap
 * Se utilizo el libro de la clase para poder realizar los métodos y atributos
 * El capítulo es el de PriorityQueue en la seección de Vector Heap
 */

import java.util.*;

/**
 * Implementación de una PriorityQueue utilizando un Heap basado en un Vector.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;
    private static final int capacity = 10;

    /*
     * Crea una cola con prioridad con capacidad fija.
     */
    public VectorHeap() {
        this.data = new Vector<E>(capacity);
    }

    /*
     * Agrega un elemento a la cola manteniendo el orden del heap
     */
    @Override
    public boolean offer(E e) {
        if (data.size() >= capacity)
            return false;
        data.add(e);
        percolateUp(data.size() - 1);
        return true;
    }

    /*
     * Elimina y retorna el elemento con mayor prioridad
     */
    @Override
    public E poll() {
        if (data.isEmpty())
            return null;

        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (!data.isEmpty())
            pushDownRoot(0);
        return minVal;
    }

    /*
     * Obtiene el elemento con mayor prioridad sin eliminarlo.
     */
    @Override
    public E peek() {
        return data.isEmpty() ? null : data.get(0);
    }

    /*
     * Retorna el tamaño actual de la cola.
     */
    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    protected static int left(int i) {
        return 2 * i + 1;
    }

    protected static int right(int i) {
        return 2 * i + 2;
    }

    /*
     * Reorganiza el heap hacia arriba desde una hoja.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && data.get(parent).compareTo(value) > 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /*
     * Reorganiza el heap hacia abajo desde la raíz.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (right(root) < heapSize && data.get(childpos + 1).compareTo(data.get(childpos)) < 0) {
                    childpos++;
                }
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else
                    break;
            } else
                break;
        }
        data.set(root, value);
    }
}
