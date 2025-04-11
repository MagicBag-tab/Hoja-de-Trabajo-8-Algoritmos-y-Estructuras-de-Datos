import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*
 * Implementación personalizada de una PriorityQueue usando
 * java.util.PriorityQueue
 * con un comparador basado en la prioridad de los pacientes (letras A-E).
 * Utiliza como ejemplo esta página:
 * https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html#PriorityQueue(java.util.Collection)
 */
public class PriorityQueueImplementation<E extends Paciente> implements PriorityQueue<E> {

    private java.util.PriorityQueue<E> queue;

    /*
     * Constructor que crea una cola de prioridad vacía usando un comparador
     * personalizado que ordena a los pacientes por su nivel de prioridad
     */
    public PriorityQueueImplementation() {
        this.queue = new java.util.PriorityQueue<>(new Comparator<E>() {
            @Override
            public int compare(E p1, E p2) {
                return p1.getPriority().compareTo(p2.getPriority());
            }
        });
    }

    /*
     * Constructor que inicializa la cola con una lista de pacientes.
     */
    public PriorityQueueImplementation(List<? extends E> pacientes) {
        this();
        queue.addAll(pacientes);
    }

    /*
     * Inserta un paciente en la cola.
     */
    @Override
    public boolean offer(E e) {
        return queue.offer(e);
    }

    /*
     * Elimina y retorna el siguiente paciente con mayor prioridad.
     */
    @Override
    public E poll() {
        E paciente = queue.poll();
        if (paciente != null) {
            System.out.println("Siguiente paciente a atender: " + paciente.getName() + ", " +
                    paciente.getSymptom() + ", Prioridad: " + paciente.getPriority());
        }
        return paciente;
    }

    /*
     * Retorna el siguiente paciente sin eliminarlo.
     */
    @Override
    public E peek() {
        return queue.peek();
    }

    /*
     * Retorna el número de pacientes en la cola.
     */
    @Override
    public int size() {
        return queue.size();
    }

    /*
     * Devuelve un iterador para recorrer los pacientes de la cola.
     */
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    /*
     * Método para atender y mostrar al siguiente paciente.
     */
    public void atenderSiguientePaciente() {
        poll();
    }
}
