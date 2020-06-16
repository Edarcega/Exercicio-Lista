package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employee = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int qtdEmp = sc.nextInt();

		for (int i = 0; i < qtdEmp; i++) {
			sc.nextLine();
			int n = i + 1;
			System.out.println("Employee #" + n);
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			employee.add(new Employee(id, name, salary));
			System.out.println("");
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int src = sc.nextInt();

		Employee busca = employee.stream().filter(x -> x.getId() == src).findFirst().orElse(null);

		if (busca != null) {
			System.out.print("Enter the percentage: ");
			double percentage =sc.nextDouble();
			busca.increaseSalary(percentage);
			System.out.println("");
		} else {
			System.out.println("This id does not exist!");
			System.out.println("");
		}

		System.out.println("List of employees: ");

		for (Employee teste : employee) {
			System.out.print(teste);
		}

		sc.close();

	}// end main

}// end class
