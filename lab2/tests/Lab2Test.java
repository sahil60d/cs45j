package labs.lab2.tests;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;
import org.junit.Test;
import labs.lab2.*;
public class Lab2Test {
private final double EPSILON = 1e-3;
@Test
public void problem1() {
assertEquals("dollars: 2, cents: 95",
Main.problem1_getDollarsAndCents(2.95));
assertEquals("dollars: 4, cents: 34",
Main.problem1_getDollarsAndCents(4.34));
assertEquals("dollars: 6998, cents: 0",
Main.problem1_getDollarsAndCents(6998));
assertEquals("dollars: 0, cents: 69",
Main.problem1_getDollarsAndCents(0.69));
}
@Test
public void problem2() {
// Test case 1:
String input = "53,882\n";
InputStream in = new ByteArrayInputStream(input.getBytes());
System.setIn(in);
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
Main.problem2_removeCommas(new Scanner(System.in));
String result = output.toString();
assertEquals("Please enter an integer between 1,000 and 999,999, using a comma after the thousands: 53882", result);
// Test case 2:
input = "1,001\n";
in = new ByteArrayInputStream(input.getBytes());
System.setIn(in);
output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
Main.problem2_removeCommas(new Scanner(System.in));
result = output.toString();
assertEquals("Please enter an integer between 1,000 and 999,999, using a comma after the thousands: 1001", result);
// Test case 3:
input = "523,303\n";
in = new ByteArrayInputStream(input.getBytes());
System.setIn(in);
output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
Main.problem2_removeCommas(new Scanner(System.in));
result = output.toString();
assertEquals("Please enter an integer between 1,000 and 999,999, using a comma after the thousands: 523303", result);
}
@Test
public void problem3() {
assertEquals("Input: 89877, Last 3 digits: 877, Reversed: 778, Difference: 99",
Main.problem3_reverseAndSubtract(89877));
assertEquals("Number too small!",
Main.problem3_reverseAndSubtract(89));
assertEquals("Input: 371, Last 3 digits: 371, Reversed: 173, Difference: 198",
Main.problem3_reverseAndSubtract(371));
assertEquals("Input: 3928, Last 3 digits: 928, Reversed: 829, Difference: 99",
Main.problem3_reverseAndSubtract(3928));
assertEquals("Input: 5999, Last 3 digits: 999, Reversed: 999, Difference: 0",
Main.problem3_reverseAndSubtract(5999));
assertEquals("Input: 2727, Last 3 digits: 727, Reversed: 727, Difference: 0",
Main.problem3_reverseAndSubtract(2727));
}
@Test
public void problem4() {
Triangle triangle1 = new Triangle(0, 5, 1.5, 2, 8, 25.92);
assertEquals(3.3541019662496847, triangle1.getSide1Length(), EPSILON);
assertEquals(22.39746414217467,triangle1.getSide2Length(), EPSILON);
assertEquals(24.787424230847385,triangle1.getSide3Length(), EPSILON);
assertEquals(2.312694531902217,triangle1.getAngle1(), EPSILON);
assertEquals(0.7289796952097912,triangle1.getAngle2(), EPSILON);
assertEquals(0.09991842647778622,triangle1.getAngle3(), EPSILON);
assertEquals(50.53899033927174,triangle1.getPerimeter(), EPSILON);
assertEquals(27.690000000000044,triangle1.getArea(), EPSILON);
Triangle triangle2 = new Triangle(-5.2, -10.5, 0.005, -33.33, 16, 99.3);
assertEquals(23.415826378755032, triangle2.getSide1Length(), EPSILON);
assertEquals(111.82790349461087,triangle2.getSide2Length(), EPSILON);
assertEquals(133.59100615310896,triangle2.getSide3Length(), EPSILON);
assertEquals(2.726703271998203,triangle2.getAngle1(), EPSILON);
assertEquals(0.3441770951688207,triangle2.getAngle2(), EPSILON);
assertEquals(0.0707122864227689,triangle2.getAngle3(), EPSILON);
assertEquals(268.83473602647484,triangle2.getPerimeter(), EPSILON);
assertEquals(527.7524999999993,triangle2.getArea(), EPSILON);
}
@Test
public void problem5() {
Balloon balloon = new Balloon();
assertEquals(0.0, balloon.getVolume(), EPSILON);
assertEquals(0.0, balloon.getSurfaceArea(), EPSILON);
assertEquals(0.0, balloon.getRadius(), EPSILON);
balloon.addAir(100);
assertEquals(100.0, balloon.getVolume(), EPSILON);
assertEquals(104.18794157356086, balloon.getSurfaceArea(), EPSILON);
assertEquals(2.8794119114848606, balloon.getRadius(), EPSILON);
balloon.addAir(100);
assertEquals(200.0, balloon.getVolume(), EPSILON);
assertEquals(165.38804805627186, balloon.getSurfaceArea(), EPSILON);
assertEquals(3.6278316785978095, balloon.getRadius(), EPSILON);
}
@Test
public void problem6() {
assertEquals(0, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 10, 0), 1.0,
60));
assertEquals(100, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 51), 1.0,
60));
assertEquals(35400, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 1), 1.0,
60));
assertEquals(10, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 59), 1.0,
60));
assertEquals(0, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 10, 0), 0.5,
60));
assertEquals(0, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 51), 0.5,
60));
assertEquals(17400, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 1), 0.5,
60));
assertEquals(0, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 59), 0.5,
60));
assertEquals(600, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 10, 0), 2,
60));
assertEquals(810, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 51), 2,
60));
assertEquals(71400, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 1), 2,
60));
assertEquals(620, Main.problem6_checkSpeed(LocalDateTime.of(2023,
Month.OCTOBER, 31, 6, 9, 0),
LocalDateTime.of(2023, Month.OCTOBER, 31, 6, 9, 59), 2,
60));
}
@Test
public void problem7() {
assertEquals(6, Main.problem7_specialSum(1, 2, 3));
assertEquals(2, Main.problem7_specialSum(3, 2, 3));
assertEquals(0, Main.problem7_specialSum(3, 3, 3));
assertEquals(9, Main.problem7_specialSum(9, 2, 2));
assertEquals(9, Main.problem7_specialSum(2, 2, 9));
assertEquals(9, Main.problem7_specialSum(2, 9, 2));
assertEquals(14, Main.problem7_specialSum(2, 9, 3));
assertEquals(9, Main.problem7_specialSum(4, 2, 3));
assertEquals(3, Main.problem7_specialSum(1, 3, 1));
assertEquals(3, Main.problem7_specialSum(-1, 3, 1));
assertEquals(-3, Main.problem7_specialSum(-1, -3,- 1));
}
@Test
public void problem8() {
Distance d = new Distance(23.552);
assertEquals(23.55, Math.round(d.getMeters() * 100.0) / 100.0,
EPSILON);
assertEquals(2355.20, Math.round(d.getCentimeters() * 100.0) / 100.0,
EPSILON);
assertEquals(77.27, Math.round(d.getFeet() * 100.0) / 100.0, EPSILON);
assertEquals(927.24, Math.round(d.getInches() * 100.0) / 100.0,
EPSILON);
assertEquals(0.024, Math.round(d.getKilometers() * 1000.0) / 1000.0,
EPSILON);
assertEquals(0.015, Math.round(d.getMiles() * 1000.0) / 1000.0,
EPSILON);
}
@Test
public void problem9() {
assertEquals("Square", (new Quadrilateral(5, 10, 15, 10, 15, 20, 5,
20)).getShapeType());
assertEquals("None", (new Quadrilateral(5, 0, 25, 0, 30, 198, 0,
30)).getShapeType());
assertEquals("Rectangle", (new Quadrilateral(9, -0.33, -29.25, -0.33, -
29.25, 16.77, 9, 16.77)).getShapeType());
//assertEquals("Trapezoid", (new Quadrilateral(5, 0, 25, 0, 30, 30, 0,
//30)).getShapeType());
assertEquals("Rhombus", (new Quadrilateral(7.4315, 0, 14.863, 8.11,
7.4315, 16.22, 0, 8.11)).getShapeType());
assertEquals("Rectangle", (new Quadrilateral(5, 10, 15, 10, 15, 30, 5,
30)).getShapeType());
assertEquals("Parallelogram", (new Quadrilateral(0, 0, 4, 0, 3, -2, -1,
-2)).getShapeType());
}
@Test
public void test_problem10() {
assertEquals("MCMLXXVIII", Main.problem10_getRomanNumerals(1978));
assertEquals("XXIX", Main.problem10_getRomanNumerals(29));
assertEquals("Error", Main.problem10_getRomanNumerals(4000));
}
}