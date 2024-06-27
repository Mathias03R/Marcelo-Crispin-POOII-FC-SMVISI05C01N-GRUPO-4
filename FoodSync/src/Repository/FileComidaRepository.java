package Repository;

import modelo.Comida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileComidaRepository implements ComidaRepository {
    private static final String FILE_PATH = "src/comida/comida.txt";

    public FileComidaRepository() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comida> findAll() {
        List<Comida> comidas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                comidas.add(Comida.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comidas;
    }

    @Override
    public Optional<Comida> findById(Long id) {
        return findAll().stream()
                .filter(comida -> comida.getId().equals(id))
                .filter(comida -> comida.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Comida comida) {
        List<Comida> comidas = findAll();
        comidas.add(comida);
        writeToFile(comidas);
    }

    @Override
    public void update(Comida comida) {
        List<Comida> comidas = findAll();
        for (int i = 0; i < comidas.size(); i++) {
            if (comidas.get(i).getId().equals(comida.getId())) {
                comidas.set(i, comida);
                break;
            }
        }
        writeToFile(comidas);
    }

    @Override
    public void delete(Long id) {
        List<Comida> comidas = findAll();
        comidas.removeIf(comida -> comida.getId().equals(id));
        writeToFile(comidas);
    }

    private void writeToFile(List<Comida> comidas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Comida comida : comidas) {
                writer.write(comida.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
