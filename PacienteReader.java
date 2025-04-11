/*
 * Lee el archivo de pacientes y devuelve una lista de estos
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacienteReader {
    public static List<Paciente> leerPacientes(String archivo) {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String symptom = parts[1].trim();
                    String priority = parts[2].trim();
                    pacientes.add(new Paciente(name, symptom, priority));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        }
        return pacientes;
    }
}