/*
 * Clase paciente que tiene todos los métodos y atributos necesarios que conforman al paciente
 */
public class Paciente {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Paciente [name=" + name + ", symptom=" + symptom + ", priority=" + priority + "]";
    }

}