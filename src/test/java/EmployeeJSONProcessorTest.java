import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class EmployeeJSONProcessorTest {
    /*
     * Проверка конвертации списка Employee в json
     */
    @Test
    public void testCorrectSCVParse() {
        //given
        ArrayList<Employee> requiredList = new ArrayList<>();
        requiredList.add(new Employee(1,"John","Smith","USA",25));
        requiredList.add(new Employee(2,"Ivan","Petrov","RU",23));

        //when
        String expectedJson = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\"" +
                ",\"age\":25},{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\"," +
                "\"age\":23}]";
        String actualJson = EmployeeJSONProcessor.listToJson(requiredList);

        //then
        Assertions.assertEquals(expectedJson,actualJson);
    }
}
