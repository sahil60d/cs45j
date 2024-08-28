package labs.lab4.tests;
import static org.junit.Assert.*;
import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import labs.lab4.*;
public class Lab4Test {
private final double EPSILON = 1e-3;
@Test
public void problem1() {
// Test case 1
Toy lamby = new Toy("Lamby", "white fluffy stuffed lamb that I got for Christmas", false);
Toy sharky = new Toy("Sharky", "blue shark with its mouth chewed off",
true);
Toy socky = new Toy("Socky", "my brother's old sock that I like to carry around in my mouth like a treasure", true);
Toy tennisBall = new Toy("Tennis Ball", "standard green tennis ball that I play with outside", false);
ToyInventory inventory = new ToyInventory();
inventory.addToy(lamby);
inventory.addToy(sharky);
inventory.addToy(socky);
inventory.addToy(tennisBall);
inventory.removeToy("Sharky");
assertEquals("Lamby\n"
+ "white fluffy stuffed lamb that I got for Christmas\n"
+ "NOT DESTROYED\n"
+ "Socky\n"
+ "my brother's old sock that I like to carry around in my mouth like a treasure\n"
+ "DESTROYED\n"
+ "Tennis Ball\n"
+ "standard green tennis ball that I play with outside\n"
+ "NOT DESTROYED", inventory.getInventoryReport());
}
@Test
public void problem2() {
// Employee class:
Employee robert = new Employee("Robert Navarro", 150.0, 20, 324);
assertEquals(1, robert.getId());
Employee emily = new Employee("Emily Navarro", 75.0, 50, 88);
assertEquals(2, emily.getId());
Employee sheila = new Employee("Sheila Burns", 53.49, 11.5, 90);
assertEquals(3, sheila.getId());
assertEquals("Robert Navarro", robert.getName());
assertEquals(150.0, robert.getPayRate(), EPSILON);
assertEquals(20.0, robert.getHoursWorked(), EPSILON);
assertFalse(robert.isProvisional());
robert.setName("");
assertEquals("Robert Navarro", robert.getName());
robert.setName("Bob N.");
assertEquals("Bob N.", robert.getName());
robert.setPayRate(-1.5);
assertEquals(150.0, robert.getPayRate(), EPSILON);
robert.setPayRate(200);
assertEquals(200.0, robert.getPayRate(), EPSILON);
robert.setHoursWorked(120);
assertEquals(20.0, robert.getHoursWorked(), EPSILON);
robert.setHoursWorked(2);
assertEquals(2.0, robert.getHoursWorked(), EPSILON);
// Payroll class:
Payroll payroll = new Payroll();
payroll.addEmployee(robert);
payroll.addEmployee(emily);
payroll.addEmployee(sheila);
assertEquals("Id: 1, Name: Bob N., Amount: $360.0",
payroll.getPaycheck(1));
assertEquals("Id: 2, Name: Emily Navarro, Amount: $4125.0",
payroll.getPaycheck(2));
assertEquals("Id: 3, Name: Sheila Burns, Amount: $615.14",
payroll.getPaycheck(3));
payroll.removeEmployee(2);
assertEquals("Error: No employee found with id 2",
payroll.getPaycheck(2));
Employee greg = new Employee("Greg", 0, 65.2, 110);
payroll.addEmployee(greg);
assertEquals(4, greg.getId());
assertEquals("Id: 4, Name: Greg, Amount: $0.0",
payroll.getPaycheck(4));
robert.setHoursWorked(0);
assertEquals("Id: 1, Name: Bob N., Amount: $0.0",
payroll.getPaycheck(1));
}
@Test
public void problems4And5() {
// Test Case #1 (losing because they fall into a trap without a jet pack):
List<Point> traps = new ArrayList<>();
traps.add(new Point(-1, 0));
traps.add(new Point(4, 4));
traps.add(new Point(3, -2));
traps.add(new Point(-3, -1));
traps.add(new Point(-4, -1));
List<Point> jetPacks = new ArrayList<>();
jetPacks.add(new Point(0, 1));
jetPacks.add(new Point(-2, 5));
jetPacks.add(new Point(0, -3));
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
AdventureGame game1 = new AdventureGame(traps, jetPacks);
assertEquals(new Point(0, 0), game1.getPlayerLocation());
assertEquals("NORTH", game1.getPlayerDirection());
game1.movePlayer(); // prints out "Picked up jet pack! "
assertEquals(new Point(0, 1), game1.getPlayerLocation());
assertEquals("NORTH", game1.getPlayerDirection());
game1.playerTurnLeft();
assertEquals(new Point(0, 1), game1.getPlayerLocation());
assertEquals("WEST", game1.getPlayerDirection());
game1.movePlayer();
assertEquals(new Point(-1, 1), game1.getPlayerLocation());
assertEquals("WEST", game1.getPlayerDirection());
game1.playerTurnLeft();
assertEquals(new Point(-1, 1), game1.getPlayerLocation());
assertEquals("SOUTH", game1.getPlayerDirection());
game1.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
assertEquals(new Point(-1, 0), game1.getPlayerLocation());
assertEquals("SOUTH", game1.getPlayerDirection());
game1.playerTurnRight();
assertEquals(new Point(-1, 0), game1.getPlayerLocation());
assertEquals("WEST", game1.getPlayerDirection());
game1.movePlayer();
assertEquals(new Point(-2, 0), game1.getPlayerLocation());
assertEquals("WEST", game1.getPlayerDirection());
game1.movePlayer();
assertEquals(new Point(-3, 0), game1.getPlayerLocation());
assertEquals("WEST", game1.getPlayerDirection());
game1.playerTurnLeft();
assertEquals(new Point(-3, 0), game1.getPlayerLocation());
assertEquals("SOUTH", game1.getPlayerDirection());
game1.movePlayer(); // prints out "Fell into a trap! You lose!"
String result = output.toString();
assertEquals("Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!", result);
// Test Case #2 (try to pick up > 3 jet packs, go back to where they used to be
// a jet pack)
traps = new ArrayList<>();
traps.add(new Point(-1, 0));
traps.add(new Point(4, 4));
traps.add(new Point(3, -2));
traps.add(new Point(-3, -1));
traps.add(new Point(-4, -1));
jetPacks = new ArrayList<>();
jetPacks.add(new Point(0, 1));
jetPacks.add(new Point(0, 2));
jetPacks.add(new Point(0, 3));
jetPacks.add(new Point(0, 4));
jetPacks.add(new Point(-2, 5));
jetPacks.add(new Point(0, -3));
output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
AdventureGame game2 = new AdventureGame(traps, jetPacks);
assertEquals(new Point(0, 0), game2.getPlayerLocation());
assertEquals("NORTH", game2.getPlayerDirection());
game2.movePlayer(); // prints out "Picked up jet pack! "
assertEquals(new Point(0, 1), game2.getPlayerLocation());
assertEquals("NORTH", game2.getPlayerDirection());
game2.movePlayer(); // prints out "Picked up jet pack! "
assertEquals(new Point(0, 2), game2.getPlayerLocation());
assertEquals("NORTH", game2.getPlayerDirection());
game2.movePlayer(); // prints out "Picked up jet pack! "
assertEquals(new Point(0, 3), game2.getPlayerLocation());
assertEquals("NORTH", game2.getPlayerDirection());
game2.movePlayer(); // player encounters a jet pack, but can't pick it up because they already have
// 3
assertEquals(new Point(0, 4), game2.getPlayerLocation());
assertEquals("NORTH", game2.getPlayerDirection());
game2.playerTurnRight();
game2.movePlayer();
assertEquals(new Point(1, 4), game2.getPlayerLocation());
assertEquals("EAST", game2.getPlayerDirection());
game2.movePlayer();
game2.movePlayer();
game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
assertEquals(new Point(4, 4), game2.getPlayerLocation());
assertEquals("EAST", game2.getPlayerDirection());
game2.playerTurnLeft();
game2.playerTurnLeft();
assertEquals(new Point(4, 4), game2.getPlayerLocation());
assertEquals("WEST", game2.getPlayerDirection());
game2.movePlayer();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer(); // prints out "Picked up jet pack! "
assertEquals(new Point(0, 4), game2.getPlayerLocation());
assertEquals("WEST", game2.getPlayerDirection());
game2.playerTurnLeft();
assertEquals("SOUTH", game2.getPlayerDirection());
game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
game2.movePlayer();
game2.playerTurnRight();
assertEquals(new Point(0, 0), game2.getPlayerLocation());
assertEquals("WEST", game2.getPlayerDirection());
game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
game2.playerTurnLeft();
game2.movePlayer();
assertEquals(new Point(-1, -1), game2.getPlayerLocation());
assertEquals("SOUTH", game2.getPlayerDirection());
game2.playerTurnRight();
game2.movePlayer();
game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
assertEquals(new Point(-3, -1), game2.getPlayerLocation());
assertEquals("WEST", game2.getPlayerDirection());
game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
assertEquals(new Point(-4, -1), game2.getPlayerLocation());
assertEquals("WEST", game2.getPlayerDirection());
game2.playerTurnLeft();
game2.movePlayer();
game2.playerTurnLeft();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer();
game2.movePlayer(); // prints out "Fell into a trap! You lose! "
result = output.toString();
assertEquals("Picked up jet pack! Picked up jet pack! Picked up jet pack! Fell into a trap! Used jet pack! Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! Used jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!",
result);
// Test Case #3 (try to move off the world, make 30 moves without dying and win:
traps = new ArrayList<>();
traps.add(new Point(-1, 0));
jetPacks = new ArrayList<>();
output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
AdventureGame game3 = new AdventureGame(traps, jetPacks);
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
assertEquals(new Point(0, 5), game3.getPlayerLocation());
assertEquals("NORTH", game3.getPlayerDirection());
game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
// should not count toward 30
game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
// should not count toward 30
game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
// should not count toward 30
assertEquals(5, game3.getNumMovesMade());
assertEquals(new Point(0, 5), game3.getPlayerLocation());
assertEquals("NORTH", game3.getPlayerDirection());
game3.playerTurnLeft();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
assertEquals(new Point(-5, 5), game3.getPlayerLocation());
assertEquals("WEST", game3.getPlayerDirection());
game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
// should not count toward 30
assertEquals(10, game3.getNumMovesMade());
assertEquals(new Point(-5, 5), game3.getPlayerLocation());
assertEquals("WEST", game3.getPlayerDirection());
game3.playerTurnLeft();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
assertEquals(20, game3.getNumMovesMade());
game3.playerTurnLeft();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer();
game3.movePlayer(); // prints out "You win!"
result = output.toString();
assertEquals("You win!", result);
// Test Case #4 (one spot contains a jet pack and a trap):
traps = new ArrayList<>();
traps.add(new Point(0, 1));
jetPacks = new ArrayList<>();
jetPacks.add(new Point(0, 1));
output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
AdventureGame game4 = new AdventureGame(traps, jetPacks);
game4.movePlayer(); // prints out "Picked up jet pack! Fell into a trap! Used jet pack! "
game4.movePlayer();
game4.playerTurnRight();
game4.playerTurnRight();
game4.movePlayer(); // prints out "Fell into a trap! You lose!"
result = output.toString();
assertEquals("Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!", result);
}
@Test
public void problem6() {
BasicAccount checking = new BasicAccount();
checking.deposit(1000);
checking.withdraw(100);
checking.withdraw(100);
assertEquals(800.0, checking.getBalance(), EPSILON);
// Have now used up our 3 free transactions
checking.deposit(200);
assertEquals(999.0, checking.getBalance(), EPSILON);
checking.withdraw(100);
assertEquals(898.0, checking.getBalance(), EPSILON);
checking.monthEnd();
checking.deposit(33.59);
assertEquals(931.59, checking.getBalance(), EPSILON);
checking.withdraw(.09);
assertEquals(931.50, checking.getBalance(), EPSILON);
checking.withdraw(15.33);
assertEquals(916.17, checking.getBalance(), EPSILON);
checking.withdraw(1);
assertEquals(914.17, checking.getBalance(), EPSILON);
checking.withdraw(10);
assertEquals(903.17, checking.getBalance(), EPSILON);
checking.withdraw(10);
assertEquals(892.17, checking.getBalance(), EPSILON);
checking.monthEnd();
checking.withdraw(10);
assertEquals(882.17, checking.getBalance(), EPSILON);
assertTrue(BankAccount.class.isAssignableFrom(BasicAccount.class));
}
@Test
public void problems8Thru10TestAppointment() {
Appointment[] appointments = new Appointment[] {
new DailyAppointment("Brush teeth"),
new MonthlyAppointment(1, "Visit Grandma"),
new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
new OnetimeAppointment(2021, 10, 31, "Schedule yearly checkup"),
new YearlyAppointment(10, 31, "Trick or Treat"),
new DailyAppointment("Write some code"),
new MonthlyAppointment(31, "Change mascara"),
new YearlyAppointment(3, 28, "Robert's birthday"),
new OnetimeAppointment(2020, 11, 1, "Doctor appointment"),
new WeeklyAppointment(DayOfWeek.SUNDAY, "Plan my week"),
new WeeklyAppointment(DayOfWeek.FRIDAY, "Lunch with Mom"),
new WeeklyAppointment(DayOfWeek.WEDNESDAY, "Lunch with Dad"),
new WeeklyAppointment(DayOfWeek.MONDAY, "Fight a case of \"The Mondays\""),
new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
new OnetimeAppointment(2022, 11, 1, "Dentist appointment"),
new YearlyAppointment(7, 15, "Lunch with Mom") };
int year = 2021, month = 10, day = 31;
assertTrue(appointments[0].occursOn(year, month, day));
assertFalse(appointments[1].occursOn(year, month, day));
assertFalse(appointments[2].occursOn(year, month, day));
assertTrue(appointments[3].occursOn(year, month, day));
assertTrue(appointments[4].occursOn(year, month, day));
assertTrue(appointments[5].occursOn(year, month, day));
assertTrue(appointments[6].occursOn(year, month, day));
assertFalse(appointments[7].occursOn(year, month, day));
assertFalse(appointments[8].occursOn(year, month, day));
assertTrue(appointments[9].occursOn(year, month, day));
assertFalse(appointments[10].occursOn(year, month, day));
assertFalse(appointments[11].occursOn(year, month, day));
assertFalse(appointments[12].occursOn(year, month, day));
assertFalse(appointments[13].occursOn(year, month, day));
assertFalse(appointments[14].occursOn(year, month, day));
assertFalse(appointments[15].occursOn(year, month, day));
assertTrue(appointments[2].equals(appointments[13]));
assertFalse(appointments[2].equals(appointments[14]));
assertFalse(appointments[1].equals(appointments[6]));
assertFalse(appointments[10].equals(appointments[15]));
assertFalse(appointments[9].equals(appointments[11]));
assertTrue(appointments[7].equals(new YearlyAppointment(3, 28, "Robert's birthday")));
}
@Test
public void problems8Thru10TestOnetimeAppointment() {
OnetimeAppointment a = new OnetimeAppointment(2023, 11, 2, "Lab 4 Due");
assertEquals(2023, a.getYear());
assertEquals(11, a.getMonth());
assertTrue(a.occursOn(2023, 11, 2));
assertTrue(a.equals(new OnetimeAppointment(2023, 11, 2, "Lab 4 Due")));
assertTrue(OnetimeAppointment.class.getSuperclass() == Appointment.class);
}
@Test
public void problems8Thru10TestDailyAppointment() {
DailyAppointment a = new DailyAppointment("Remember to stay healthy!");
assertTrue(a.occursOn(2023, 11, 2));
assertTrue(a.equals(new DailyAppointment("Remember to stay healthy!")));
assertTrue(DailyAppointment.class.getSuperclass() == Appointment.class);
}
@Test
public void problems8Thru10TestMonthlyAppointment() {
MonthlyAppointment a = new MonthlyAppointment(1, "First day of the month!");
assertEquals(1, a.getDay());
assertTrue(a.occursOn(2023, 12, 1));
assertTrue(a.equals(new MonthlyAppointment(1, "First day of the month!")));
assertTrue(MonthlyAppointment.class.getSuperclass() ==
Appointment.class);
}
@Test
public void problems8Thru10TestYearlyAppointment() {
YearlyAppointment a = new YearlyAppointment(1, 1, "Happy New Year!");
assertEquals(1, a.getMonth());
assertEquals(1, a.getDay());
assertTrue(a.occursOn(2024, 1, 1));
//assertTrue(a.equals(new YearlyAppointment(1, 1, "Happy New Year!")));
assertTrue(YearlyAppointment.class.getSuperclass() == Appointment.class);
}
@Test
public void problems8Thru10TestWeeklyAppointment() {
WeeklyAppointment a = new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!");
assertEquals(DayOfWeek.FRIDAY, a.getDayOfWeek());
assertTrue(a.occursOn(2021, 12, 31));
assertTrue(a.equals(new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!")));
assertTrue(WeeklyAppointment.class.getSuperclass() == Appointment.class);
}
}