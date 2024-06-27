package Repository;

import modelo.Comida;
import java.util.List;
import java.util.Optional;

public interface ComidaRepository {
    // Método para obtener todas las comidas almacenadas
    List<Comida> findAll();

    // Método para buscar una comida por su ID
    Optional<Comida> findById(Long id);

    // Método para guardar una nueva comida o actualizar una existente
    void save(Comida comida);

    // Método para actualizar los datos de una comida existente
    void update(Comida comida);

    // Método para eliminar una comida por su ID
    void delete(Long id);
}
