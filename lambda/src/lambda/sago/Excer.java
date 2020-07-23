package lambda.sago;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.sago.Employee;

public class Excer {

	public void lambdaExample() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 25, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Iqbal Hussain", 39, "Male", "Product Development", 2012, 35700.0));
		// System.out.println("List:"+employeeList.toString());
		int count = 0, countfe = 0;
		// 1) new for method
		for (Employee employee : employeeList) {
			if (employee.getGender().equals("Male")) {
				count++;
			} else {
				countfe++;
			}

		}
		System.out.println("TotalMale:" + count + "TotalFeMale:" + countfe);
		// 2) using filter
		long countMale = employeeList.stream().filter(p -> p.getGender().equals("Male")).count();
		long countFeMale = employeeList.stream().filter(p -> p.getGender().equals("Female")).count();
		System.out.println("TotalMale:" + countMale);
		System.out.println("TotalFemale:" + countFeMale);
		// 3) Collectors method
		Map<Integer, Long> noOfEmployee;
		noOfEmployee = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getYearOfJoining, Collectors.counting()));
		System.out.println(noOfEmployee);
		// 4) name of department
		List<String> nameOfDepartment = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(nameOfDepartment);
		// 5) name of the male employee
		employeeList.stream().filter(p -> p.getGender().equals("Male")).filter(p -> p.getAge() > 32)
				.map(Employee::getName).distinct().forEach(System.out::println);
		// 6) name of the department
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println(employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
		Optional<Employee> maxEmp = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("List: " + maxEmp.toString());
		employeeList.stream().filter(p -> p.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);

		// average salary in each department
		Map<String, Double> depart = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Depart: " + depart);
		
		// no of employee in each department
		Map<String, Long> emp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		Set<Entry<String,Long>> ent =  emp.entrySet();
		for (Entry<String, Long> entr : ent) {
			System.out.println(entr);
		}
		//youngest male employee in the product development department
		System.out.println(employeeList.stream().filter(p -> p.getGender().equals("Male") && p.getDepartment().equals("Product Development")).collect(Collectors.minBy(Comparator.comparing(Employee::getAge))));
		//Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").sorted(Comparator.comparing(Employee::getAge));
		//System.out.println("young:"+youngestMaleEmployeeInProductDevelopmentWrapper);
		
		//Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
		//System.out.println("youngest:"+youngestMaleEmployeeInProductDevelopment);
		//most working experience in the organization
		System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst());
		Map<String, List<Employee>> map1=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String,List<Employee>>> entry = map1.entrySet();
		System.out.println(entry);
		//average salary and total salary of the whole organization
		System.out.println(employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum());
	
	}
}
