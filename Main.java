import java.util.List;
import java.util.Scanner;

/*
 * Clase principal del sistema de atención de emergencias.
 * Permite al usuario seleccionar entre dos implementaciones de PriorityQueue
 * y atiende pacientes según su prioridad.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Paciente> pacientes = PacienteReader.leerPacientes("pacientes.txt");
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo 'pacientes.txt'. Saliendo...");
            scanner.close();
            return;
        }

        int op;
        do {
            System.out.println("\nSeleccione la implementación de PriorityQueue:");
            System.out.println("1. VectorHeap");
            System.out.println("2. PriorityQueueImplementation");
            System.out.println("3. Salir");

            op = scanner.nextInt();

            switch (op) {
                case 1:
                    // Usar VectorHeap
                    PriorityQueue<Paciente> colaVector = Factory.crearPriorityQueue(1, pacientes);
                    System.out.println("Orden de atención de los pacientes");
                    while (colaVector.size() > 0) {
                        colaVector.poll();
                    }
                    break;

                case 2:
                    PriorityQueue<Paciente> colaImpl = Factory.crearPriorityQueue(2, pacientes);
                    System.out.println("Orden de atención de los pacientes");
                    while (colaImpl.size() > 0) {
                        colaImpl.poll();
                    }
                    break;

                case 3:
                    System.out.println("Gracias por utilizar nuestro sistema :D");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (op != 3);

        scanner.close();
    }
}