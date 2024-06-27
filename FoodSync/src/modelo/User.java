package modelo;

public class User {
    private Long id; // Identificador único del usuario
    private String email; // Correo electrónico del usuario
    private String password; // Contraseña del usuario

    // Constructor de la clase User
    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // Métodos getter y setter para los atributos de la clase

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString para representar el usuario como una cadena de texto
    @Override
    public String toString() {
        return id + "," + email + "," + password;
    }

    // Método estático para crear un objeto User a partir de una cadena de texto
    public static User fromString(String line) {
        String[] parts = line.split(",");
        return new User(Long.parseLong(parts[0]), parts[1], parts[2]);
    }
}
