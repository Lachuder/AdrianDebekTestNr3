package Zadanie03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner03 {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Adam", "Nowak", "12345678999", 10_000.0D, "Programmer", "Warsaw"));
        employees.add(new Employee("Robert", "Puczyk","09876543212", 12_000.0D, "Programmer", "Warsaw"));
        employees.add(new Employee("Anna", "Kwiatkowska","65748345327", 13_000.0D, "Manager", "Poznan"));
        employees.add(new Employee("Franciszek", "Lasek","23456569995", 9_000.0D, "Tester", "Poznan"));
        employees.add(new Employee("Roman", "Kowalski","23226569995", 12_000.0D, "Programmer", "Rybnik"));
        employees.add(new Employee("Kuba", "Nowacki","23226569995", 12_000.0D, "Programmer", null));
        employees.add(new Employee("Krystian", "Rączka","23226569995", 12_000.0D, null, "Krakow"));

        List <String> stringi = List.of("Jeden", "Dwa", "Trzy", "Cztery", "Piec", "Szesc", "Siedem", "Osiem", "Dziewiec", "Dziesiec");

        List <Integer> intidzery = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        MinMaxService.getMinAndMax(employees);
        MinMaxService.getMinAndMax(stringi);
        MinMaxService.getMinAndMax(intidzery);


    }

}
