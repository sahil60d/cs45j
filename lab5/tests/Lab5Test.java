package labs.lab5.tests;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import labs.lab5.*;
public class Lab5Test {
private final double EPSILON = 1e-3;
@Test
public void problems1Through5() {
Monster monster = new Monster();
Dragon dragon = new Dragon(true);
Zombie zombie = new Zombie(10.0);
EvilRobot robot = new EvilRobot(1000);
MadClown clown = new MadClown(false);
PotOfGold gold = new PotOfGold(10);
TreasureChest chest = new TreasureChest(1000);
GameElement[] gameElements = {
monster,
dragon,
zombie,
robot,
clown,
gold,
chest
};
Stompable[] stompables = {
monster,
dragon,
zombie,
robot
};
for (GameElement element : gameElements) {
element.tick();
element.tick();
}
assertEquals(80, ((Monster)gameElements[0]).getHealth());
assertEquals("blue", ((Monster)gameElements[0]).getColor());
assertEquals(60, ((Dragon)gameElements[1]).getHealth());
assertEquals(true, ((Dragon)gameElements[1]).isFireBreathing());
assertEquals(12, ((PotOfGold)gameElements[5]).getNumPieces());
assertEquals(902.5, ((TreasureChest)gameElements[6]).getWeight(), EPSILON);
int [] expected = new int [] {100, -50, 0, 0, -10};
for (int i = 0; i < stompables.length; i++) {
assertEquals(expected[i], stompables[i].stompOn());
}
assertEquals(0, ((Monster)gameElements[0]).getHealth());
assertEquals("red", ((Monster)gameElements[0]).getColor());
assertEquals(100, ((Dragon)gameElements[1]).getHealth());
assertEquals(false, ((Dragon)gameElements[1]).isFireBreathing());
}
@Test
public void problems6Through7() {
Encourager dog = new Dog();
assertEquals("Give wet sloppy kisses | Lay on your feet",
dog.encourage());
Encourager friend1 = new Friend("Jing", 20);
assertEquals("Come over to hang out | Bring snacks",
friend1.encourage());
Encourager friend2 = new Friend("Aly", 21);
assertEquals("Come over to hang out | Bring snacks",
friend2.encourage());
Encourager nature = new Nature();
assertEquals("Shine sun | Blow gentle breeze", nature.encourage());
Encourager mom = new Parent("Mom", 50);
assertEquals("Call on the phone | Say you're their favorite child",
mom.encourage());
Encourager dad = new Parent("Dad", 51);
assertEquals("Call on the phone | Say you're their favorite child",
dad.encourage());
Person[] people = {
new Friend("Jing", 20),
new Friend("Aly", 21),
new Friend("Aly", 18),
new Friend("Aly", 35),
new Parent("Mom", 50),
new Parent("Dad", 51)
};
Arrays.sort(people);
assertEquals("Name: Aly, Age: 18", people[0].toString());
assertEquals("Name: Aly, Age: 21", people[1].toString());
assertEquals("Name: Aly, Age: 35", people[2].toString());
assertEquals("Name: Dad, Age: 51", people[3].toString());
assertEquals("Name: Jing, Age: 20", people[4].toString());
assertEquals("Name: Mom, Age: 50", people[5].toString());
}
@Test
public void problem8() {
Coin coin1 = new Coin(.25, "Quarter");
Coin coin2 = new Coin(.10, "Dime");
Coin coin3 = new Coin(.10, "Dime");
Coin coin4 = new Coin(.10, "My Dime");
Coin coin5 = new Coin(.01, "Penny");
Coin coin6 = new Coin(.01, "Different Penny");
Coin coin7 = new Coin(.05, "NICKEL");
Coin coin8 = new Coin(.05, "nickel");
Coin coin9 = new Coin(.05, "Nickel");
assertTrue(coin1.compareTo(coin2) > 0);
assertEquals(0, coin2.compareTo(coin3));
assertTrue(coin3.compareTo(coin1) < 0);
assertTrue(coin3.compareTo(coin4) < 0);
assertTrue(coin4.compareTo(coin3) > 0);
assertTrue(coin2.equals(coin3));
assertFalse(coin2.equals(coin4));
assertEquals("Value: 0.25, Name: Quarter", coin1.toString());
assertEquals("Value: 0.1, Name: Dime", coin2.toString());
assertEquals("Value: 0.1, Name: Dime", coin3.toString());
assertEquals("Value: 0.1, Name: My Dime", coin4.toString());
assertEquals("Value: 0.01, Name: Penny", coin5.toString());
assertEquals("Value: 0.01, Name: Different Penny", coin6.toString());
assertEquals("Value: 0.05, Name: NICKEL", coin7.toString());
assertEquals("Value: 0.05, Name: nickel", coin8.toString());
assertEquals("Value: 0.05, Name: Nickel", coin9.toString());
List<Coin> coins = new ArrayList<>();
coins.add(coin1);
coins.add(coin2);
coins.add(coin3);
coins.add(coin4);
coins.add(coin5);
coins.add(coin6);
coins.add(coin7);
coins.add(coin8);
coins.add(coin9);
Collections.sort(coins);
assertEquals(coin6, coins.get(0));
assertEquals(coin5, coins.get(1));
assertEquals(coin7, coins.get(2));
assertEquals(coin9, coins.get(3));
assertEquals(coin8, coins.get(4));
assertEquals(coin2, coins.get(5));
assertEquals(coin3, coins.get(6));
assertEquals(coin4, coins.get(7));
assertEquals(coin1, coins.get(8));
}
@Test
public void problems9Through10() {
final int small = 5;
final int neg = -10000;
final int large = 1000000;
final int maxBase = 36;
NumberFormatter numFormat;
numFormat = new DefaultFormatter();
assertEquals("5", numFormat.format(small));
assertEquals("-10000", numFormat.format(neg));
assertEquals("1000000", numFormat.format(large));
assertEquals("36", numFormat.format(maxBase));
numFormat = new DecimalSeparatorFormatter();
assertEquals("5", numFormat.format(small));
assertEquals("-10,000", numFormat.format(neg));
assertEquals("1,000,000", numFormat.format(large));
assertEquals("36", numFormat.format(maxBase));
numFormat = new AccountingFormatter();
assertEquals("$5", numFormat.format(small));
assertEquals("$(10000)", numFormat.format(neg));
assertEquals("$1000000", numFormat.format(large));
assertEquals("$36", numFormat.format(maxBase));
numFormat = new BaseFormatter(2); // Binary System
assertEquals("101", numFormat.format(small));
assertEquals("-10011100010000", numFormat.format(neg));
assertEquals("11110100001001000000", numFormat.format(large));
assertEquals("100100", numFormat.format(maxBase));
numFormat = new BaseFormatter(8); // Octal System
assertEquals("5", numFormat.format(small));
assertEquals("-23420", numFormat.format(neg));
assertEquals("3641100", numFormat.format(large));
assertEquals("44", numFormat.format(maxBase));
numFormat = new BaseFormatter(20); // Base 20
assertEquals("5", numFormat.format(small));
assertEquals("-1500", numFormat.format(neg));
assertEquals("65000", numFormat.format(large));
assertEquals("1g", numFormat.format(maxBase));
numFormat = new BaseFormatter(36); // Base 36
assertEquals("5", numFormat.format(small));
assertEquals("-7ps", numFormat.format(neg));
assertEquals("lfls", numFormat.format(large));
assertEquals("10", numFormat.format(maxBase));
}
}