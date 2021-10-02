import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCSVParserTest {
    /*
     * Проверка прасинга корректного CSV с точки зрения класса Employee
     */
    @ParameterizedTest
    @ValueSource(strings = {"src/test/dataTest2.csv"})
    public void testCorrectSCVParse(String argument) {
        //given
        ArrayList<Employee> requiredList = new ArrayList<>();
        requiredList.add(new Employee(1,"John","Smith","USA",25));
        requiredList.add(new Employee(2,"Ivan","Petrov","RU",23));

        //when
        List<Employee> staff = EmployeeCSVParser.parseCSV(argument);

        //then
        Assertions.assertNotNull(staff);
        Assertions.assertIterableEquals(requiredList,staff);
    }

    /*
     * Проверка прасинга для несуществующего файла и невалидного файла CSV с точки зрения класса Employee
     */
    @ParameterizedTest
    @ValueSource(strings = {"src/test/missing.csv", "src/test/dataTest1.csv"})
    void testInvalidSCVParse(String argument) {
        //given
        //when
        List<Employee> staff = EmployeeCSVParser.parseCSV(argument);

        //then
        Assertions.assertNull(staff);
    }
}
