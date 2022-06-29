package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("this is maven project");
        Employee employeeOne = new Employee("Janis", "developer", 1000.55);
        System.out.println(employeeOne.toString());
        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(),faker.company().profession(),
                faker.number().randomDouble(2,100,2000));
        System.out.println(employeeTwo.toString());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        System.out.println("Funny name" + faker.funnyName().name());
        System.out.println("Harry Potter house" + faker.harryPotter().house());
        System.out.println("Weather" + faker.weather().temperatureCelsius());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);


        for (int i = 0; i <= 100; i++) {
            Employee employee = new Employee();
            System.out.println(employee);

        }

    }
}
