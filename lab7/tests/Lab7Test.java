package labs.lab7.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import labs.lab7.*;
public class Lab7Test {
@Test
public void problem1() {
assertEquals("h*e*l*l*o", Main.problem1_addStars("hello"));
assertEquals("a*b*c", Main.problem1_addStars("abc"));
assertEquals("a*b", Main.problem1_addStars("ab"));
assertEquals("a", Main.problem1_addStars("a"));
assertEquals("1*2*3*4*5", Main.problem1_addStars("12345"));
}
@Test
public void problem2() {
assertEquals(true, Main.problem2_contains6(new int[] {1, 6, 4}, 0)); //returns true
assertEquals(false, Main.problem2_contains6(new int[] {1, 4}, 0)); //returns false
assertEquals(true, Main.problem2_contains6(new int[] {6}, 0)); //returns true
assertEquals(false, Main.problem2_contains6(new int[] {}, 0)); //returns false
}
@Test
public void problem3() {
assertTrue(Main.problem3_nested("(())"));
assertTrue(Main.problem3_nested("((()))"));
assertFalse(Main.problem3_nested("(((x))"));
assertFalse(Main.problem3_nested("(((x)))"));
assertFalse(Main.problem3_nested("fdasf"));
assertFalse(Main.problem3_nested("((())"));
assertTrue(Main.problem3_nested("()"));
assertFalse(Main.problem3_nested("((()()"));
assertFalse(Main.problem3_nested("(yy)"));
assertTrue(Main.problem3_nested("(())"));
assertFalse(Main.problem3_nested("(((y))"));
assertFalse(Main.problem3_nested("((y)))"));
assertTrue(Main.problem3_nested("((()))"));
assertFalse(Main.problem3_nested("(())))"));
assertFalse(Main.problem3_nested("((yy())))"));
assertFalse(Main.problem3_nested("( )"));
assertFalse(Main.problem3_nested(" "));
assertFalse(Main.problem3_nested(" () "));
assertTrue(Main.problem3_nested("(((())))"));
}
@Test
public void problem4() { //Tests Country Class
Country myCountry = new Country("USA",331002651);
Country myOtherCountry = new Country("Antarctica",1100);
assertEquals("USA", myCountry.getName()); //returns USA
assertEquals(331002651, myCountry.getPopulation()); //returns 331002651
assertTrue(myCountry.compareTo(myOtherCountry) > 0);
}
@Test
public void problem5() { //Tests TravelRecord Class
TravelRecord record = new TravelRecord();
record.addCountry("USA", 331002651);
record.addCountry("South Korea", 51269185);
record.addCountry("Greece", 10423054);
record.addCountry("Kenya", 53771296);
assertEquals("Greece South Korea Kenya USA",
record.getNamesOrderedByPopulation()); // returns "Antarctica Greece Australia South Korea Kenya Brazil USA"
record.addCountry("Brazil", 212559417);
record.addCountry("Australia", 25499884);
record.addCountry("Antarctica", 1100);
assertEquals("Antarctica Greece Australia South Korea Kenya Brazil USA", record.getNamesOrderedByPopulation()); // returns "Antarctica Greece Australia South Korea Kenya Brazil USA"
assertEquals("Kenya",
record.findCountryByPopulation(53771296).getName()); // returns "Kenya"
assertEquals(10423054,
record.findCountryByName("Greece").getPopulation()); // returns 10423054
record.removeCountry(25499884);
record.removeCountry("Antarctica");
assertEquals("Greece South Korea Kenya Brazil USA",
record.getNamesOrderedByPopulation()); // returns "Greece South Korea Kenya Brazil USA"
}
@Test
public void problem6() {
HTMLFile file = new HTMLFile("res/TagSample1.html");
assertTrue(file.isValid());
file = new HTMLFile("res/TagSample2.html");
assertFalse(file.isValid());
file = new HTMLFile("res/TagSample3.html");
assertFalse(file.isValid());
file = new HTMLFile("res/TagSample4.html");
assertTrue(file.isValid());
file = new HTMLFile("res/TagSample5.html");
assertTrue(file.isValid());
// exception for file not found:
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
String nonExistentFileName = "nothing.html";
new HTMLFile(nonExistentFileName);
String result = output.toString();
assertEquals("File: " + nonExistentFileName + " not found", result);
}
@Test
public void problem7() {
ToDoList todo = new ToDoList();
todo.addTask(2, "read book");
todo.addTask(3, "wash dishes");
todo.addTask(5, "eat lunch");
assertEquals("read book", todo.nextTask().getDescription());
todo.addTask(1, "walk dog");
assertEquals("walk dog", todo.nextTask().getDescription());
assertEquals("wash dishes", todo.nextTask().getDescription());
assertEquals("eat lunch", todo.nextTask().getDescription());
}
@Test
public void problem8() {
RunwaySimulator rws = new RunwaySimulator();
rws.addTakeOff("FlightA");
rws.addTakeOff("FlightB");
rws.addLanding("FlightC");
rws.addLanding("FlightD");
assertEquals("FlightC landing", rws.handleNextAction());
assertEquals("FlightD landing", rws.handleNextAction());
assertEquals("FlightA taking off", rws.handleNextAction());
rws.addLanding("FlightE");
assertEquals("FlightE landing", rws.handleNextAction());
assertEquals("FlightB taking off", rws.handleNextAction());
}
@Test
public void problem10() {
// firstLetter1.txt:
FirstLetterMap map = new FirstLetterMap("res/firstLetter1.txt");
assertEquals(
"{a=[a, across, actually, alice, and, at], b=[before], e=[either], f=[feet, flashed, for], h=[had, her, hurried], i=[it, its], l=[looked], m=[mind], n=[never], o=[of, on, or, out], r=[rabbit], s=[seen, she, started], t=[take, that, the, then, to, took], w=[waistcoatpocket, watch, when, with]}",
map.toString());
Set<String> expected = new TreeSet<>();
expected.add("had");
expected.add("her");
expected.add("hurried");
assertEquals(expected, map.getWordsThatStartWith('h'));
// firstLetter2.txt:
map = new FirstLetterMap("res/firstLetter2.txt");
assertEquals(
"{a=[a, as], b=[but], d=[disappointment, down], e=[empty], f=[from], g=[great], h=[her], i=[it], j=[jar], l=[labelled], m=[marmalade], o=[of, one, orange], p=[passed], s=[she, shelves], t=[the, to, took], w=[was]}",
map.toString());
expected = new TreeSet<>();
expected.add("her");
assertEquals(expected, map.getWordsThatStartWith('h'));
// firstLetter3.txt:
map = new FirstLetterMap("res/firstLetter3.txt");
assertEquals(
"{a=[again, alice], b=[began], c=[cat], d=[dinah, dinahll, do, down], e=[else], i=[i], m=[me, miss, much], n=[nothing], s=[should, so, soon], t=[talking, the, there, think, to, tonight], v=[very], w=[was]}",
map.toString());
assertEquals(null, map.getWordsThatStartWith('h'));
expected = new TreeSet<>();
expected.add("talking");
expected.add("the");
expected.add("there");
expected.add("think");
expected.add("to");
expected.add("tonight");
assertEquals(expected, map.getWordsThatStartWith('t'));
//firstLetter4.txt:
map = new FirstLetterMap("res/firstLetter4.txt");
assertEquals(
"{a=[again, alice], b=[began, bowls], c=[cat, cream], d=[dinah, dinahll, do, down], e=[eat, else, end], i=[i, ice], m=[me, miss, much], n=[nothing], o=[of], s=[should, so, soon], t=[talking, the, there, think, to, tonight], v=[very], w=[want, was]}",
map.toString());
expected = new TreeSet<>();
expected.add("dinah");
expected.add("dinahll");
expected.add("do");
expected.add("down");
assertEquals(expected, map.getWordsThatStartWith('d'));
expected = new TreeSet<>();
expected.add("cat");
expected.add("cream");
assertEquals(expected, map.getWordsThatStartWith('c'));
// test exception message is printed out:
String nonExistentFileName = "res/firstLetterDoesNotExist.txt";
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
map = new FirstLetterMap(nonExistentFileName);
String result = output.toString();
assertEquals("File: " + nonExistentFileName + " not found", result);
}
}