package labs.lab1.tests;
import static org.junit.Assert.*;
import java.awt.Rectangle;
import org.junit.Test;
import labs.lab1.*;
public class Lab1Test {
private final double EPSILON = 1e-3;
@Test
public void problem1() {
assertEquals("<<Yay>>", Main.problem1_makeOutWord("<<>>", "Yay"));
assertEquals("----WooHoo----", Main.problem1_makeOutWord("--------",
"WooHoo"));
assertEquals("awordb", Main.problem1_makeOutWord("ab", "word"));
assertEquals("dog", Main.problem1_makeOutWord("", "dog"));
assertEquals("abcd", Main.problem1_makeOutWord("abcd", ""));
}
@Test
public void problem2() {
assertEquals("Helo", Main.problem2_firstLastN("Hello", 2));
assertEquals("Choate", Main.problem2_firstLastN("Chocolate", 3));
assertEquals("Ce", Main.problem2_firstLastN("Chocolate", 1));
assertEquals("CC", Main.problem2_firstLastN("C", 1));
}
@Test
public void problem3() {
// make 5 test runs:
for (int i=0; i<5; i++) {
String result = Main.problem3_rollDie();
boolean correct = true;
//The length of result must be 9 (it includes 4 spaces between the 5 numbers).
if (result.length()!=9) {
correct = false;
}
// All numbers must be integers less or equal to 6
result = result.replaceAll("\\s","");
for(int j=0; i<result.length();i++) {
try {
int number =
Integer.parseInt(String.valueOf(result.charAt(j)));
if(number > 6) {
correct = false;
}
}catch(Exception e) {
correct = false; //if conversion from string to integer fails
}
}
assertEquals(true, correct);
}
}
@Test
public void problem4() {
assertTrue(Main.problem4_rectIntersect(100, 100, 50, 50, 0, 0, 20,
20).isEmpty());
assertEquals(new Rectangle(0, 0, 20, 20),
Main.problem4_rectIntersect(0, 0, 20, 20, 0, 0, 20, 20));
assertEquals(new Rectangle(5, 10, 15, 10),
Main.problem4_rectIntersect(0, 0, 20, 20, 5, 10, 25, 80));
assertEquals(new Rectangle(15, 13, 28, 30),
Main.problem4_rectIntersect(15, 13, 28, 77, -15, 8, 120, 35));
}
@Test
public void problem5() {
assertEquals("treoR", Main.problem5_deleteAndReverse("Robert", 2));
assertEquals("trebo", Main.problem5_deleteAndReverse("Robert", 0));
assertEquals("reboR", Main.problem5_deleteAndReverse("Robert", 5));
assertEquals("I", Main.problem5_deleteAndReverse("HI", 0));
assertEquals("H", Main.problem5_deleteAndReverse("HI", 1));
assertEquals("", Main.problem5_deleteAndReverse("H", 0));
}
@Test
public void problem6() {
Person individual = new Person("Robert");
individual.befriend(new Person("Fido"));
individual.befriend(new Person("Spot"));
individual.befriend(new Person("Fluffy"));
individual.unfriend(new Person("Fluffy"));
String list = individual.getFriendNames().replace(" ","");
assertEquals("FidoSpot", list);
assertEquals(2, individual.getFriendCount());
}
@Test
public void problem7() {
Bug bugsy = new Bug(10);
bugsy.move();
assertEquals(11,bugsy.getPosition()); // returns 11
bugsy.turn();
bugsy.move();
assertEquals(10,bugsy.getPosition()); // returns 10
}
@Test
public void problem8() {
RangeInput range = new RangeInput(0, 10);
assertEquals(5, range.getCurrent());
range.up();
assertEquals(6, range.getCurrent());
range.up();
assertEquals(7, range.getCurrent());
range.up();
assertEquals(8, range.getCurrent());
range.up();
assertEquals(9, range.getCurrent());
range.up();
assertEquals(10, range.getCurrent());
range.up();
assertEquals(10, range.getCurrent());
range.up();
assertEquals(10, range.getCurrent());
range.down();
assertEquals(9, range.getCurrent());
range.down();
assertEquals(8, range.getCurrent());
range.down();
assertEquals(7, range.getCurrent());
range.down();
assertEquals(6, range.getCurrent());
range.down();
assertEquals(5, range.getCurrent());
range.down();
assertEquals(4, range.getCurrent());
range.down();
assertEquals(3, range.getCurrent());
range.down();
assertEquals(2, range.getCurrent());
range.down();
assertEquals(1, range.getCurrent());
range.down();
assertEquals(0, range.getCurrent());
range.down();
assertEquals(0, range.getCurrent());
range.up();
assertEquals(1, range.getCurrent());
range.down();
assertEquals(0, range.getCurrent());
range.down();
assertEquals(0, range.getCurrent());
}
@Test
public void problem9() {
SavingsAccount momsSavings = new SavingsAccount(1000, 10);
momsSavings.addInterest();
assertEquals(1100.0, momsSavings.getBalance(), EPSILON);
momsSavings.addInterest();
assertEquals(1210.0, momsSavings.getBalance(), EPSILON);
momsSavings.deposit(1000.00);
assertEquals(2210.0, momsSavings.getBalance(), EPSILON);
momsSavings.addInterest();
assertEquals(2431.0, momsSavings.getBalance(), EPSILON);
momsSavings.withdraw(2000.0);
assertEquals(431.0, momsSavings.getBalance(), EPSILON);
momsSavings.addInterest();
assertEquals(474.1, momsSavings.getBalance(), EPSILON);
SavingsAccount emilysSavings = new SavingsAccount();
assertEquals(0.0, emilysSavings.getBalance(), EPSILON);
emilysSavings.addInterest();
assertEquals(0.0, emilysSavings.getBalance(), EPSILON);
emilysSavings.deposit(100);
assertEquals(100.0, emilysSavings.getBalance(), EPSILON);
emilysSavings.addInterest();
assertEquals(100.0, emilysSavings.getBalance(), EPSILON);
SavingsAccount robertsSavings = new SavingsAccount(250, 50);
assertEquals(250.0, robertsSavings.getBalance(), EPSILON);
robertsSavings.addInterest();
robertsSavings.addInterest();
robertsSavings.addInterest();
assertEquals(843.75, robertsSavings.getBalance(), EPSILON);
robertsSavings.deposit(10000.0);
robertsSavings.addInterest();
assertEquals(16265.625, robertsSavings.getBalance(), EPSILON);
}
@Test
public void problem10() {
Microwave appliance = new Microwave();
appliance.increaseTime();
appliance.increaseTime();
appliance.increaseTime();
appliance.switchPower();
assertEquals("Cookingfor90secondsatlevel2",appliance.start().replaceAll("\\s",""));
appliance.reset();
appliance.increaseTime();
appliance.switchPower();
appliance.switchPower();
assertEquals("Cookingfor30secondsatlevel1",
appliance.start().replaceAll("\\s","")); // returns "Cooking for 30 seconds at level 1"
}
}
