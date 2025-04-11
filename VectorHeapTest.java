import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
        heap.offer(new Paciente("Pedro", "Fractura", "C"));
        heap.offer(new Paciente("Juan", "Dolor de cabeza", "A"));
        heap.offer(new Paciente("Maria", "Fiebre", "B"));
    }

    @Test
    public void testOrderOfPatients() {

        assertEquals("El primer paciente debe ser Juan (prioridad A)", "Juan", heap.poll().getName());
        assertEquals("El segundo paciente debe ser Maria (prioridad B)", "Maria", heap.poll().getName());
        assertEquals("El tercer paciente debe ser Pedro (prioridad C)", "Pedro", heap.poll().getName());
    }

}
