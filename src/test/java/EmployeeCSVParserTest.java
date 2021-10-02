import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCSVParserTest {

    /*
     * Проверка прасинга невалидного CSV с точки зрения класса Employee
     */
    @Test
    public void testInvalidSCVParse() {
        //given
        final String CSVFile = "src/test/dataTest1.csv";

        //when
        List<Employee> staff = EmployeeCSVParser.parseCSV(CSVFile);

        //then
        Assertions.assertNull(staff);
    }

    /*
     * Проверка прасинга несущетсвующего файла CSV
     */
    @Test
    public void testNonexistingSCVParse() {
        //given
        final String CSVFile = "src/test/notexisting.csv";

        //when
        List<Employee> staff = EmployeeCSVParser.parseCSV(CSVFile);

        //then
        Assertions.assertNull(staff);
    }

    /*
     * Проверка прасинга корректного CSV с точки зрения класса Employee
     */
    @Test
    public void testCorrectSCVParse() {
        //given
        final String CSVFile = "src/test/dataTest2.csv";
        ArrayList<Employee> requiredList = new ArrayList<>();


        //when
        List<Employee> staff = EmployeeCSVParser.parseCSV(CSVFile);
        requiredList.add(new Employee(1,"John","Smith","USA",25));
        requiredList.add(new Employee(2,"Ivan","Petrov","RU",23));

        //then
        Assertions.assertNotNull(staff);
        Assertions.assertIterableEquals(requiredList,staff);
    }
}
