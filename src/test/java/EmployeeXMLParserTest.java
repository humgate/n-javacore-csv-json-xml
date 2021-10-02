import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;
public class EmployeeXMLParserTest {
    /*
     * Проверка прасинга для несуществующего файла и невалидного файла XML с точки зрения класса Employee
     */
    @ParameterizedTest
    @ValueSource(strings = {"src/test/missing.xml", "src/test/dataTest1.xml"})
    void testInvalidSCVParse(String argument) {
        //given
        //when
        List<Employee> staff = EmployeeXMLParser.employeeParseXML(argument);

        //then
        Assertions.assertNull(staff);
    }

    /*
     * Проверка парсинга корректного xml с точки зрения класса Employee
     */
    @ParameterizedTest
    @ValueSource(strings = {"src/test/dataTest2.xml"})
    public void testCorrectXMLParse(String argument) {
        //given
        ArrayList<Employee> requiredList = new ArrayList<>();
        requiredList.add(new Employee(1,"John","Smith","USA",25));
        requiredList.add(new Employee(2,"Ivan","Petrov","RU",23));

        //when
        List<Employee> staff = EmployeeXMLParser.employeeParseXML(argument);

        //then
        Assertions.assertNotNull(staff);
        Assertions.assertIterableEquals(requiredList,staff);
    }

}
