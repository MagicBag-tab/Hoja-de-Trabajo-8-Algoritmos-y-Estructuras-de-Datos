/*
 * 
 * Clade de Vector Heap
 * Se utilizo el libro de la clase para poder realizar los métodos y atributos
 * El capítulo es el de PriorityQueue en la seección de Vector Heap
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class VectorHeap<E> implements PriorityQueue<E> {
    protected Vector<E> data;
    private static final int capacity = 10;
    private Comparator<E> comparator;

    public VectorHeap() {
        this.comparator = new Comparator<E>() {
            @Override
            public int compare(E e1, E e2) {
                Paciente p1 = (Paciente) e1;
                Paciente p2 = (Paciente) e2;

                return p1.getPriority().compareTo(p2.getPriority());
            }
        };
        this.data = new Vector<E>(capacity);
    }

    @Override
    public boolean offer(E e) {
        if (data.size() >= capacity) {
            return false;
        }
        data.add(e);
        percolateUp(data.size() - 1);
        return true;
    }

    @Override
    public E poll() {
        if (data.isEmpty())
            return null;

        E minVal = data.get(0);
        int lastIndex = data.size() - 1;
        data.set(0, data.get(lastIndex));
        data.setSize(lastIndex);
        if (!data.isEmpty()) {
            pushDownRoot(0);
        }
        return minVal;
    }

    @Override
    public E peek() {
        if (data.isEmpty())
            return null;
        return data.get(0);
    }

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
        return 2 * (i + 1);
    }

    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && comparator.compare(data.get(parent), value) > 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (right(root) < heapSize && comparator.compare(data.get(childpos + 1), data.get(childpos)) < 0) {
                    childpos++;
                }
                if (comparator.compare(data.get(childpos), value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }
}