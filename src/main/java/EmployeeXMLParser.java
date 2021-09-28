import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Парсит XML файл с данными сотрудников в список объектов Empoloyee
 */
public class EmployeeXMLParser {
    /**
     * Парсит XML файл с данными сотрудников в список объектов Employee
     * @param fileName - XML с данными сотрудников
     * @return список объектов Employee или null если файл либо данные невалидны
     */
    public static List<Employee> employeeParseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            return read(doc.getDocumentElement());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Парсит xml DOM с данными Employee в список объектов Employee
     *
     * @param node - корневой Node DOM xml
     * @return список объектов Employee или null если файл либо данные невалидны
     */
    private static List<Employee> read(Node node) {
        List<Employee> emplist = new ArrayList<>();
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                Element element = (Element) node_;
                /*
                 * По именам тегов читаем контент тегов.
                 * Если нужного для сохранения объекта Employee тега в файле нет, значит xml файл невалидный с
                 * точки зрения хранения данных Employee. Ловим NullPointer exception и выходим возвращая null.
                 * Если тег есть, но его контент не кастится к типу нужному Employee (int) ловим
                 * NumberFormatException exception и выходим.
                 */
                try {
                    Employee employee = new Employee();

                    employee.id =
                            Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    employee.firstName =
                            element.getElementsByTagName("firstName").item(0).getTextContent();
                    employee.lastName =
                            element.getElementsByTagName("lastName").item(0).getTextContent();
                    employee.lastName =
                            element.getElementsByTagName("country").item(0).getTextContent();
                    employee.id =
                            Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());

                    emplist.add(employee);

                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("Не удалось распарсить xml файл в объект(ы) класса Employee");
                    return null;
                }
            }
        }
        return emplist;
    }
}
