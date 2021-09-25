import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.FileReader;
import java.util.List;

/**
 * Содержит методы для чтения csv файла и парсинга строк csv файла в список объектов
 * класса Employee
 */
public class EmployeeCSVParser {
    //массив строк, содержащий информацию о предназначении колонок в CVS файле
    public static final String[] COLUMN_MAPPING = {"id", "firstName", "lastName", "country", "age"};

    /**
     * Выполняет парсинг csv файла в список объектов класса Employee
     *
     * @return список объектов класса Employee или null если не удалось распарсить
     */
    public static List<Employee> parseCSV(String fileName) {

        List<Employee> staff = null;

        /*Создаем экземпляр CSVWriter
         * Разделитель по умолчанию - запятая
         * Символ выражения по умолчанию - двойные кавычки
         */

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            /*
             * ColumnPositionMappingStrategy определяет класс, к которому будут привязываться
             * данные из CSV документа, а также порядок расположения полей в этом документе:
             */
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(COLUMN_MAPPING);

            /*
             * CsvToBean создает инструмент для взаимодействия CSV документа и выбранной
             * ранее стратегии:
             */
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            /*
             * парсим
             */
            staff = csv.parse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return staff;
        }
        return staff;
    }
}
