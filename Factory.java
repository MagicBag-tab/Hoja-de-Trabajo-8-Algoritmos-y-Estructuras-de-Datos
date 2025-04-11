import java.util.List;

/*
 * Fábrica para crear diferentes implementaciones de PriorityQueue.
 */
public class Factory {

    /**
     * Crea una cola de prioridad según la opción seleccionada.
     */
    public static PriorityQueue<Paciente> crearPriorityQueue(int opcion, List<Paciente> pacientes) {
        PriorityQueue<Paciente> cola;

        switch (opcion) {
            case 1:
                cola = new VectorHeap<>();
                for (Paciente p : pacientes) {
                    if (!cola.offer(p)) {
                        System.out.println("VectorHeap está lleno, no se pudo agregar: " + p.getName());
                    }
                }
                break;
            case 2:
                cola = new PriorityQueueImplementation<>(pacientes);
                break;
            default:
                throw new IllegalArgumentException("Opción no válida");
        }

        return cola;
    }
}
