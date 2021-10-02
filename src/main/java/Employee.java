import java.util.Objects;

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

    /*
     * Переопределяем для того, чтобы удобно было тестировать объекты на равенство
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(country, employee.country);
    }
    /*
     * Переопределяем потому что переопределили equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country, age);
    }
}
