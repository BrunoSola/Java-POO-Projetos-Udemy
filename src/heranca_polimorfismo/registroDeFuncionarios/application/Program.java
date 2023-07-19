package heranca_polimorfismo.registroDeFuncionarios.application;

import heranca_polimorfismo.registroDeFuncionarios.entities.Employee;
import heranca_polimorfismo.registroDeFuncionarios.entities.OutsourcerdEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++ ){
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? " );
            char result = in.next().charAt(0);

            System.out.print("Name: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Hours: ");
            int hours = in.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = in.nextDouble();
            if (result == 'y'){
                System.out.print("Additional Charge: ");
                double additionalCharge = in.nextDouble();
                employees.add(new OutsourcerdEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else{
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }
        System.out.println("\nPAYMENT:");
        for (Employee e : employees){
            System.out.println(e);
        }

        in.close();
    }

}
