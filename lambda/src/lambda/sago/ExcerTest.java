package lambda.sago;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sago.Employee;

public class ExcerTest {

	@Test
	public void lambdaExample() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	}
}
