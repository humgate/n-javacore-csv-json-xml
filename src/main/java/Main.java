import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        * Задача 1: CSV - JSON парсер
        */

        //парсим csv в список employee
        List<Employee> list = EmployeeCSVParser.parseCSV("data.csv");

        if (list != null) { //если не упали при парсинге и список не пустой
            System.out.println("CSV parsed successfully");
        } else {
            System.out.println("CSV parsing failed.");
            return;
        }

        //конвертируем список employee в json
        String json = EmployeeJSONProcessor.listToJson(list);

        //пишем в фaйл
        EmployeeJSONProcessor.writeJsonToFile(json, "data.json");

        /*
         * Задача 2: XML - JSON парсер
         */

        List<Employee> employeeList = EmployeeXMLParser.employeeParseXML("data.xml");
        if (employeeList != null) {

            System.out.println("XML parsed successfully");
            //конвертируем список employee в json
            json = EmployeeJSONProcessor.listToJson(employeeList);

            //пишем в фaйл
            EmployeeJSONProcessor.writeJsonToFile(json, "data2.json");
        }
    }
}
