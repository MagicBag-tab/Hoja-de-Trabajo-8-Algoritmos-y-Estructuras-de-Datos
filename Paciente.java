/*
 * Clase paciente que tiene todos los métodos y atributos necesarios que conforman la clase pacientes y posee 
 * comparable para realizar el ordenamiento por prioridad. 
 */
public class Paciente implements Comparable<Paciente> {

    private String name;
    private String symptom;
    private String priority;

    public Paciente(String name, String symptom, String priority) {
        this.name = name;
        this.symptom = symptom;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + ", " + symptom + ", " + priority;
    }

    @Override
    public int compareTo(Paciente other) {
        return this.priority.compareTo(other.priority);
    }
}
