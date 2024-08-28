package labs.lab6.tests;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import org.junit.Test;
import labs.lab6.*;
public class Lab6Test {
private final double EPSILON = 1e-3;
@Test
public void problem1() {
boolean success = false;
Main.problem1_averageColumns("res/columns.txt", "res/averages.txt");
try (Scanner inputReader = new Scanner(new File("res/averages.txt"))) {
assertEquals(34.75333333333333, inputReader.nextDouble(),
EPSILON);
assertEquals(59.400000000000006, inputReader.nextDouble(),
EPSILON);
success = true;
} catch (FileNotFoundException exception) {
fail("File: averages.txt not found");
}
if (success) {
cleanUp("averages.txt");
}
}
@Test
public void problem2() {
SpellChecker checker = new SpellChecker("res/words.txt");
List<String> notFoundWords = checker.checkFile("res/doc.txt");
List<String> result = new ArrayList<>(Arrays.asList(
new String[] {
"foolishness", "incredulity", "Charles", "A",
"I", "havent", "Christmas", "Oliver"
}));
Collections.sort(notFoundWords);
Collections.sort(result);
assertTrue(notFoundWords.equals(result));
}
@Test
public void problem3() {
// success operations:
BankAccount harrysChecking = new BankAccount(1);
assertEquals(1, harrysChecking.getBalance(), EPSILON);
harrysChecking.deposit(300);
assertEquals(301, harrysChecking.getBalance(), EPSILON);
harrysChecking.withdraw(100);
assertEquals(201, harrysChecking.getBalance(), EPSILON);
// exception operations:
// depositing negative amount:
Exception exception = assertThrows(IllegalArgumentException.class, () -> {
harrysChecking.deposit(-100);
});
String expectedMessage = "Cannot deposit negative amount";
String actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
assertEquals(201, harrysChecking.getBalance(), EPSILON);
// withdrawing amount greater than balance:
exception = assertThrows(IllegalArgumentException.class, () -> {
harrysChecking.withdraw(300);
});
expectedMessage = "Cannot withdraw this amount";
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
assertEquals(201, harrysChecking.getBalance(), EPSILON);
// withdrawing negative amount:
exception = assertThrows(IllegalArgumentException.class, () -> {
harrysChecking.withdraw(-3);
});
expectedMessage = "Cannot withdraw this amount";
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
assertEquals(201, harrysChecking.getBalance(), EPSILON);
// constructing new account with negative initial balance:
exception = assertThrows(IllegalArgumentException.class, () -> {
BankAccount a = new BankAccount(-100);
});
expectedMessage = "Cannot enter negative initial balance";
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
}
@Test
public void problem4() {
StudentRoster roster = new StudentRoster("res/roster.txt");
assertEquals(78.4, roster.getCourseTotalTuition("Agility Training"),
EPSILON);
assertEquals(3, roster.getNumStudentsInCourse("Agility Training"));
assertEquals(0, roster.getNumStudentsInCourse("Obedience 101"));
Student fluffy = new Student("Fluffy",6514,"Agility Training",29.95,"6/7/2014");
assertEquals("Fluffy",fluffy.getName());
assertEquals(6514,fluffy.getId());
assertEquals("Agility Training",fluffy.getCourse());
assertEquals(29.95,fluffy.getTuition(), EPSILON);
assertEquals("6/7/2014",fluffy.getDate());
}
@Test
public void problem5() {
// customers1.txt:
CustomerData data = new CustomerData("res/customers1.txt");
List<Customer> expected = Arrays.asList(
new Customer("DoggySpa", 99.5,
Customer.CustomerType.CORPORATE)
);
List<Customer> actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 56.67,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers2.txt:
data = new CustomerData("res/customers2.txt");
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL),
new Customer("DoggySpa", 99.5,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(new Customer("DoggySpa", 99.5,
Customer.CustomerType.CORPORATE));
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers3.txt:
data = new CustomerData("res/customers3.txt");
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL),
new Customer("DoggyDayCare", 99.5,
Customer.CustomerType.CORPORATE),
new Customer("DoggySpa", 99.5,
Customer.CustomerType.CORPORATE),
new Customer("Fluffy", 99.5,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("DoggyDayCare", 99.5,
Customer.CustomerType.CORPORATE),
new Customer("DoggySpa", 99.5,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL),
new Customer("Fluffy", 99.5,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers4.txt:
data = new CustomerData("res/customers4.txt");
expected = Arrays.asList(
new Customer("DoggyDayCare", 23.67,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 0.0,
Customer.CustomerType.PERSONAL),
new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers5.txt:
data = new CustomerData("res/customers5.txt");
expected = Arrays.asList(
new Customer("Robert", 0.0,
Customer.CustomerType.PERSONAL),
new Customer("DoggyDayCare", 0.0,
Customer.CustomerType.CORPORATE),
new Customer("DoggySpa", 0.0,
Customer.CustomerType.CORPORATE),
new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("DoggyDayCare", 0.0,
Customer.CustomerType.CORPORATE),
new Customer("DoggySpa", 0.0,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 0.0,
Customer.CustomerType.PERSONAL),
new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers6.txt:
data = new CustomerData("res/customers6.txt");
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Fluffy", 10.95,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Robert", 99.5,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers7.txt:
data = new CustomerData("res/customers7.txt");
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Chewy.com", 10.95,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers8.txt:
data = new CustomerData("res/customers8.txt");
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList();
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.PERSONAL)
);
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// customers9.txt:
data = new CustomerData("res/customers9.txt");
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList(
new Customer("Dogazon", 101.35,
Customer.CustomerType.CORPORATE)
);
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
expected = Arrays.asList();
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// blank.txt:
data = new CustomerData("res/blank.txt");
actual = data.getBestCustomer();
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
assertTrue(expected.size() == actual.size() &&
expected.containsAll(actual) && actual.containsAll(expected));
// test exception message is printed out:
String nonExistentFileName = "doesnotexist.txt";
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
data = new CustomerData(nonExistentFileName);
String result = output.toString();
assertEquals("File: " + nonExistentFileName + " not found", result);
}
@Test
public void problems6Through10() {
// date exceptions:
// wrongly-formatted date:
Exception exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021-09-10 6:00 6:45");
});
String expectedMessage = "Invalid date";
String actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// wrongly-formatted date:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk September 10, 2021 6:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid year:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk -2021/09/10 6:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid month:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/13/10 6:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid day:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/09/31 6:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// Feb 29 in non-leap year:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/29 6:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// time exceptions:
// error in time format:

exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 600 6:45");
});
expectedMessage = "Invalid time";
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));


// error in time format:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 6;00 645");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// error in time format:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 600 six-forty-five");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid hour:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 29:00 6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid hour:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 6:00 -6:45");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid minute:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 6:60 6:75");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// invalid minute:
exception = assertThrows(RuntimeException.class, () -> {
new Appointment("Take Robert for a walk 2021/02/01 6:00 6:8099");
});
actualMessage = exception.getMessage();
assertTrue(actualMessage.contains(expectedMessage));
// Valid input (shouldn't throw exceptions):
// One word appointment names:
Appointment appt1 = new Appointment("Walk 2021/9/14 6:00 7:00");
Appointment appt2 = new Appointment("Lunch 2021/09/14 12:00 13:00");
// Multi-word appointment names:
Appointment appt3 = new Appointment("Take Robert for a walk 2021/09/10 3:00 6:45");
Appointment appt4 = new Appointment("Take Robert for a walk 2021/9/10 3:00 6:45");
Appointment appt5 = new Appointment("Take Robert for a walk 2021/9/11 3:00 6:45");
Appointment appt6 = new Appointment("Take a nap 2021/9/11 3:00 6:45");
// Appointment.equals:
assertTrue(appt3.equals(appt4));
assertFalse(appt1.equals(appt3));
assertFalse(appt4.equals(appt5));
assertFalse(appt5.equals(appt6));
// Appointment.fallsOn:
AppointmentDate date1 = new AppointmentDate("2021/09/14");
AppointmentDate date2 = new AppointmentDate("2021/09/10");
assertTrue(appt1.fallsOn(date1));
assertTrue(appt3.fallsOn(date2));
assertFalse(appt1.fallsOn(date2));
// Appointment.toString:
assertEquals("Walk 2021/09/14 06:00 07:00", appt1.toString());
assertEquals("Take Robert for a walk 2021/09/10 03:00 06:45",
appt4.toString());
// AppointmentDate.equals:
AppointmentDate date3 = new AppointmentDate("2021/9/14");
assertTrue(date3.equals(date1));
assertFalse(date3.equals(date2));
// AppointmentDate.toString:
AppointmentDate date4 = new AppointmentDate("2000/1/1");
assertEquals("2000/01/01", date4.toString());
assertEquals("2021/09/14", date3.toString());
// AppointmentTime.equals:
AppointmentTime time1 = new AppointmentTime("22:03");
AppointmentTime time2 = new AppointmentTime("22:03");
AppointmentTime time3 = new AppointmentTime("22:04");
AppointmentTime time4 = new AppointmentTime("6:00");
AppointmentTime time5 = new AppointmentTime("1:51");
assertTrue(time1.equals(time2));
assertFalse(time1.equals(time3));
assertFalse(time4.equals(time5));
// AppointmentTime.toString:
assertEquals("22:03", time2.toString());
assertEquals("06:00", time4.toString());
assertEquals("01:51", time5.toString());
// AppointmentCalendar methods:
AppointmentCalendar calendar = new AppointmentCalendar();
calendar.add(appt1); // Walk 2021/9/14 6:00 7:00
calendar.add(appt2); // Lunch 2021/09/14 12:00 13:00
calendar.add(appt3); // Take Robert for a walk 2021/09/10 3:00 6:45
calendar.add(appt5); // Take Robert for a walk 2021/9/11 3:00 6:45
calendar.add(appt6); // Take a nap 2021/9/11 3:00 6:45
Appointment appt7 = new Appointment("Dentist 2008/02/29 10:00 11:00"); // (Feb 29 in leap year)
Appointment appt8 = new Appointment("Afternoon tea time 2020/09/14 3:00 5:05");
Appointment appt9 = new Appointment("Meet friend for coffee 2021/08/14 9:00 10:30");
Appointment appt10 = new Appointment("ICS 45J 2021/09/14 12:30 1:50");
calendar.add(appt7);
calendar.add(appt8);
calendar.add(appt9);
calendar.add(appt10);
// AppointmentCalendar.getAppointmentsForDay:
List<Appointment> apptsExpected = Arrays.asList(
appt1,
appt2,
appt10
);
List<Appointment> apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2021/09/14"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
apptsExpected = Arrays.asList(
appt5,
appt6
);
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2021/09/11"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
apptsExpected = Arrays.asList(
appt7
);
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2008/02/29"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
apptsExpected = Arrays.asList();
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2019/09/11"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
// AppointmentCalendar.cancel:
calendar.cancel(appt2);
apptsExpected = Arrays.asList(
appt1,
appt10
);
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2021/09/14"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
calendar.cancel(appt10);
apptsExpected = Arrays.asList(
appt1
);
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2021/09/14"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
calendar.cancel(appt5);
apptsExpected = Arrays.asList(
appt6
);
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2021/09/11"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
calendar.cancel(appt7);
apptsExpected = Arrays.asList();
apptsActual = calendar.getAppointmentsForDay(new
AppointmentDate("2008/02/29"));
assertTrue(apptsExpected.size() == apptsActual.size() &&
apptsExpected.containsAll(apptsActual) &&
apptsActual.containsAll(apptsExpected));
}
private void cleanUp(String fileName) {
try {
if (new File(fileName).delete() == false) {
System.out.printf("File: %s not deleted%n", fileName);
}
} catch (SecurityException exception) {
System.out.printf("File: %s not deleted due to permission issues%n", fileName);
}
}
}