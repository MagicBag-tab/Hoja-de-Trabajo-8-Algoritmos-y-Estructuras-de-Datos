import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
        heap.offer(new Paciente("Pedro", "Fractura", "C"));
        heap.offer(new Paciente("Juan", "Dolor de cabeza", "B"));
        heap.offer(new Paciente("Maria", "Fiebre", "B"));
    }

    @Test
    public void testOrderOfPatients() {

        assertEquals("El primer paciente debe ser Juan (prioridad B)", "Juan", heap.poll().getName());
        assertEquals("El segundo paciente debe ser Maria (prioridad B)", "Maria", heap.poll().getName());
        assertEquals("El tercer paciente debe ser Pedro (prioridad C)", "Pedro", heap.poll().getName());
    }

    @Test
    public void testOfferNewPatient() {
        // Probar añadir un nuevo paciente
        Paciente nuevo = new Paciente("Ana", "Gripe", "A");
        assertTrue("Debería poder añadir un nuevo paciente", heap.offer(nuevo));
        assertEquals("El tamaño debería aumentar en 1", 4, heap.size());
        assertEquals("El nuevo paciente con prioridad A debería estar en la raíz", "Ana", heap.peek().getName());
    }

    @Test
    public void testOfferAndPollWithDuplicates() {

        assertTrue("Debería poder añadir otro paciente con prioridad A",
                heap.offer(new Paciente("Luis", "Dolor", "A")));
        assertEquals("El tamaño debería ser 4", 4, heap.size());

        String firstName = heap.poll().getName();
        assertTrue("El primer nombre debería ser Juan o Luis", "Juan".equals(firstName) || "Luis".equals(firstName));
        assertEquals("El tamaño debería ser 3", 3, heap.size());

        String secondName = heap.poll().getName();
        if ("Juan".equals(firstName)) {
            assertEquals("El segundo nombre debería ser Luis", "Luis", secondName);
        } else {
            assertEquals("El segundo nombre debería ser Juan", "Juan", secondName);
        }

        assertEquals("El tercer paciente debe ser Maria (prioridad B)", "Maria", heap.poll().getName());
        assertEquals("El cuarto paciente debe ser Pedro (prioridad C)", "Pedro", heap.poll().getName());
        assertEquals("El tamaño debería ser 0", 0, heap.size());
    }

}
