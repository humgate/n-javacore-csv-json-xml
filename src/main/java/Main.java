import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        * Задача 1: CSV - JSON парсер
        */

        //парсим csv в список employee
        List<Employee> list = EmployeeCSVParser.parseCSV("data.csv");

        if (list != null) { //если не упали при парсинге и список не пустой
            System.out.println("CSV parsed successfully:");
        } else {
            System.out.println("CSV parsing failed.");
            return;
        }

        //конвертируем список employee в json
        String json = EmployeeJSONProcessor.listToJson(list);
        System.out.println(json);

        //пишем в фaйл
        EmployeeJSONProcessor.writeJsonToFile(json, "data.json");
    }
}
