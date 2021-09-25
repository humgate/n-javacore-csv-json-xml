import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class EmployeeJSONProcessor {

    /**
     * Конвертирует список объектов в строку json
     *
     * @param list список объектов
     * @return json
     */
    public static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        return gson.toJson(list, listType);
    }

    /**
     * Записывает строку json в файл
     *
     * @param Json     строка
     * @param fileName файл дял записи
     */
    public static void writeJsonToFile(String Json, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            // запись всей строки
            writer.write(Json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
