/**
 * Описывает сущность сотрудник
 */
public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + country + " " + age;
    }

    // Пустой конструктор необходим opencsv для парсинга csv файлов
    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }
}
