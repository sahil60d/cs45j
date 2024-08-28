package labs.lab4;
import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeTest {
	private final double EPSILON = 1e-3;
	
	@Test
	public void testConstructor() {
		Employee sahil = new Employee("Sahil Desai", 200.0, 40.0, 365);
		
		assertEquals("Sahil Desai", sahil.getName());
		assertEquals(200.0, sahil.getPayRate(), EPSILON);
		assertEquals(40.0, sahil.getHoursWorked(), EPSILON);
		assertEquals(false, sahil.isProvisional());
		
	}
	@Test
	public void testName() {
		Employee sahil = new Employee("Sahil Desai", 200.0, 40.0, 365);
		Employee michael = new Employee("Michael L.", 120.0, 75.0, 78);
		
		assertEquals("Sahil Desai", sahil.getName());
		assertEquals("Michael L.", michael.getName());
	}
	@Test
	public void testPayRate() {
		Employee sahil = new Employee("Sahil Desai", 200.0, 40.0, 365);
		Employee michael = new Employee("Michael L.", 120.0, 75.0, 78);
		
		assertEquals(200.0, sahil.getPayRate(), EPSILON);
		assertEquals(120.0, michael.getPayRate(), EPSILON);
	}
	@Test
	public void testHoursWorked() {
		Employee sahil = new Employee("Sahil Desai", 200.0, 40.0, 365);
		Employee michael = new Employee("Michael L.", 120.0, 75.0, 78);
		
		assertEquals(40.0, sahil.getHoursWorked(), EPSILON);
		assertEquals(75.0, michael.getHoursWorked(), EPSILON);
	}
	@Test
	public void testProvisional() {
		Employee sahil = new Employee("Sahil Desai", 200.0, 40.0, 365);
		Employee michael = new Employee("Michael L.", 120.0, 75.0, 78);
		
		assertEquals(false, sahil.isProvisional());
		assertEquals(true, michael.isProvisional());
	}
}
