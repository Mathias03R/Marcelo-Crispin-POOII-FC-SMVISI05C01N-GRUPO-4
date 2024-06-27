package modelo;

import java.time.LocalDate;

public class Comida {
    private Long id; // Identificador único de la comida
    private String name; // Nombre de la comida
    private LocalDate dateOfEntry; // Fecha de entrada
    private LocalDate expirationDate; // Fecha de vencimiento

    // Constructor de la clase Comida
    public Comida(Long id, String name, LocalDate dateOfEntry, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.dateOfEntry = dateOfEntry;
        this.expirationDate = expirationDate;
    }

    // Métodos getter y setter para los atributos de la clase

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Método toString para representar la comida como una cadena de texto
    @Override
    public String toString() {
        return id + "," + name + "," + dateOfEntry + "," + expirationDate;
    }

    // Método estático para crear un objeto Comida a partir de una cadena de texto
    public static Comida fromString(String line) {
        String[] parts = line.split(",");
        return new Comida(Long.parseLong(parts[0]), parts[1], LocalDate.parse(parts[2]), LocalDate.parse(parts[3]));
    }
}