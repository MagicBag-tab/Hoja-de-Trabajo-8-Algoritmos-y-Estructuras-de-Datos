import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PriorityQueueImplementation<E extends Paciente> implements PriorityQueue<E> {

    private java.util.PriorityQueue<E> queue;

    public PriorityQueueImplementation() {
        this.queue = new java.util.PriorityQueue<>(new Comparator<E>() {
            @Override
            public int compare(E p1, E p2) {
                return p1.getPriority().compareTo(p2.getPriority());
            }
        });
    }

    public PriorityQueueImplementation(List<? extends E> pacientes) {
        this();
        queue.addAll(pacientes);
    }

    @Override
    public boolean offer(E e) {
        return queue.offer(e);
    }

    @Override
    public E poll() {
        E paciente = queue.poll();
        if (paciente != null) {
            System.out.println("Siguiente paciente a atender: " + paciente.getName() + ", " +
                    paciente.getSymptom() + ", Prioridad: " + paciente.getPriority());
        }
        return paciente;
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    public void atenderSiguientePaciente() {
        poll();
    }
}
