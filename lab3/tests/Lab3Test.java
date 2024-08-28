package labs.lab3.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import labs.lab3.*;
public class Lab3Test {
private final double EPSILON = 1e-3;
@Test
public void problem1() {
assertEquals("is not test", Main.problem1_notReplace("is test"));
assertEquals("is not-is not", Main.problem1_notReplace("is-is"));
assertEquals("This is not right", Main.problem1_notReplace("This is right"));
assertEquals("I love Java!", Main.problem1_notReplace("I love Java!"));
assertEquals("My favorite number is not3.", Main.problem1_notReplace("My favorite number is3."));
assertEquals("I miss you", Main.problem1_notReplace("I miss you"));
}
@Test
public void problem2() {
assertEquals("Rob Navarro", Main.problem2_removeSegment("Robert Navarro", "ert"));
assertEquals("obet Navao", Main.problem2_removeSegment("Robert Navarro", "r"));
assertEquals("Robert Navarro", Main.problem2_removeSegment("Robert Navarro", "x"));
assertEquals("Robert Navarro the best dog in the whole wide world! He likes to eat FH!",
Main.problem2_removeSegment("Robert Navarro is the best dog in the whole wide world! He likes to eat FISH!", "IS"));
assertEquals("Robert Navarro the best dog in the whole wide world! He likes to eat FH!",
Main.problem2_removeSegment("Robert Navarro is the best dog in the whole wide world! He likes to eat FISH!", "is"));
assertEquals("Robert Navarro the best dog in the whole wide world! He likes to eat FH!",
Main.problem2_removeSegment("Robert Navarro is the best dog in the whole wide world! He likes to eat FISH!", "iS"));
assertEquals("robert", Main.problem2_removeSegment("roxxxxbert", "xx"));
assertEquals("robxert", Main.problem2_removeSegment("robxxxert", "xx"));
assertEquals("", Main.problem2_removeSegment("rrr", "r"));
assertEquals("r", Main.problem2_removeSegment("rrr", "rr"));
assertEquals("Robert, ou are a ellow lab.",
Main.problem2_removeSegment("Robert, you are a yellow lab.", "Y"));
assertEquals("", Main.problem2_removeSegment("", "r"));
assertEquals("Robertyouareayeowab!",
Main.problem2_removeSegment("Robertyouareayellowlab!", "L"));
assertEquals("ROBERTnavarro",
Main.problem2_removeSegment("ROBERT22navarro", "2"));
assertEquals("", Main.problem2_removeSegment("3333", "3"));
assertEquals("", Main.problem2_removeSegment("3333", "33"));
assertEquals("jtx", Main.problem2_removeSegment("MkjtMkx", "Mk"));
assertEquals(" Navarro is the best dog in the whole wide world!",
Main.problem2_removeSegment("Robert Navarro is the best dog in the whole wide world!", "Robert"));
}
@Test
public void problem3() {
assertEquals(1, Main.problem3_countQuadruplets("abcdXXXXabcd"));
assertEquals(3, Main.problem3_countQuadruplets("xxxxabyyyyycd"));
assertEquals(0, Main.problem3_countQuadruplets("a"));
assertEquals(0, Main.problem3_countQuadruplets(""));
assertEquals(3, Main.problem3_countQuadruplets("xxxxabyyyyycd"));
assertEquals(1, Main.problem3_countQuadruplets("XXXXabcd"));
assertEquals(2, Main.problem3_countQuadruplets("XXXXXabc"));
assertEquals(3, Main.problem3_countQuadruplets("XXXXXXabc"));
assertEquals(3, Main.problem3_countQuadruplets("2222abyyyycdXXXX"));
assertEquals(4, Main.problem3_countQuadruplets("abYYYYabXXXXXXab"));
assertEquals(0, Main.problem3_countQuadruplets("abYYXXabXXYXXab"));
assertEquals(1, Main.problem3_countQuadruplets("122abhhhh2"));
assertEquals(3, Main.problem3_countQuadruplets("1222289006677777"));
}
@Test
public void problem4() {
StringAnalyzer sa = new StringAnalyzer("Robert Sean Navarro");
assertEquals("RSN", sa.getAllUppercase());
assertEquals("Rbr enNvro", sa.getEveryOtherChar());
assertEquals("R*b*rt S**n N*v*rr*", sa.replaceVowelsWithAsterisk());
assertEquals(7, sa.getNumVowels());
assertEquals("1 3 8 9 13 15 18", sa.getVowelPositions());
sa = new StringAnalyzer("ROBERT!!!!!");
assertEquals("ROBERT", sa.getAllUppercase());
assertEquals("RBR!!!", sa.getEveryOtherChar());
assertEquals("R*B*RT!!!!!", sa.replaceVowelsWithAsterisk());
assertEquals(2, sa.getNumVowels());
assertEquals("1 3", sa.getVowelPositions());
sa = new StringAnalyzer("x YzjWkw WWDS N n bb");
assertEquals("YWWWDSN", sa.getAllUppercase());
assertEquals("xYjk WSNnb", sa.getEveryOtherChar());
assertEquals("x YzjWkw WWDS N n bb", sa.replaceVowelsWithAsterisk());
assertEquals(0, sa.getNumVowels());
assertEquals("", sa.getVowelPositions());
sa = new StringAnalyzer("oiEEiUa");
assertEquals("EEU", sa.getAllUppercase());
assertEquals("oEia", sa.getEveryOtherChar());
assertEquals("*******", sa.replaceVowelsWithAsterisk());
assertEquals(7, sa.getNumVowels());
assertEquals("0 1 2 3 4 5 6", sa.getVowelPositions());
sa = new StringAnalyzer("oi EEiU a");
assertEquals("EEU", sa.getAllUppercase());
//assertEquals("o EU ", sa.getEveryOtherChar());
assertEquals("** **** *", sa.replaceVowelsWithAsterisk());
assertEquals(7, sa.getNumVowels());
//assertEquals("0 1 3 4 5 6 11", sa.getVowelPositions());
}
@Test
public void problem5() {
PrimeGenerator generator = new PrimeGenerator();
int[] primes = new int[] {2,3,5,7,11,13,17,19};
for (int prime : primes) {
assertEquals(prime, generator.nextPrime());
}
}
@Test
public void problem6() {
assertEquals(4, Main.problem6_maxInterval(new int[] { 1, 2, 1, 1,
3 }));
assertEquals(6, Main.problem6_maxInterval(new int[] { 1, 4, 2, 1, 4, 1,
4 }));
assertEquals(6, Main.problem6_maxInterval(new int[] { 1, 4, 2, 1, 4, 4,
4 }));
assertEquals(3, Main.problem6_maxInterval(new int[] { 3, 3, 3 }));
assertEquals(3, Main.problem6_maxInterval(new int[] { 3, 9, 3 }));
assertEquals(2, Main.problem6_maxInterval(new int[] { 3, 9, 9 }));
assertEquals(1, Main.problem6_maxInterval(new int[] { 3, 9 }));
assertEquals(2, Main.problem6_maxInterval(new int[] { 3, 3 }));
assertEquals(0, Main.problem6_maxInterval(new int[] {}));
assertEquals(1, Main.problem6_maxInterval(new int[] { 1 }));
assertEquals(3, Main.problem6_maxInterval(new int[] { 1, 2, 1, -1,
3 }));
assertEquals(4, Main.problem6_maxInterval(new int[] { 1, 2, -1, 1,
3 }));
assertEquals(4, Main.problem6_maxInterval(new int[] { -1, -2, -1, -1, -
3 }));
}
@Test
public void problem7() {
assertTrue(Main.problem7_sumSplitBalance(new int[] { 1, 1, 1, 2, 1 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 2, 1, 1, 2,
1 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 10, 10 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 1 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 10, 0, 1, -1,
10 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 1, 1 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 1, 2 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 1, 1, 1, 1, 4 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 2, 1, 1, 1,
4 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 2, 3, 4, 1,
2 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 2,
3 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 1,
3 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 0, 0, 0, 0, 0 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 11, 1, 3, 3,
4 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { 0 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { 0, 0 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { -1, -11, -3, -18,
3 }));
assertFalse(Main.problem7_sumSplitBalance(new int[] { -1, -11, -3, -18,
-3 }));
assertTrue(Main.problem7_sumSplitBalance(new int[] { -1, -11, -3, -8, -
13, -10 }));
}
@Test
public void problem8() {
Item treats = new Item(2.5, true, 10);
Item collar = new Item(15.75, false, 1);
Item dogShampoo = new Item(9, false, 2);
Item bones = new Item(6.25, true, 5);
Invoice myInvoice = new Invoice();
myInvoice.addItem(treats);
myInvoice.addItem(collar);
myInvoice.addItem(dogShampoo);
myInvoice.addItem(bones);
assertEquals(90, myInvoice.getTotal(), EPSILON);
}
@Test
public void problem9() {
Sequence firstSequence = new Sequence();
firstSequence.add(1);
firstSequence.add(4);
firstSequence.add(9);
firstSequence.add(16);
Sequence secondSequence = new Sequence();
secondSequence.add(9);
secondSequence.add(7);
secondSequence.add(4);
secondSequence.add(9);
secondSequence.add(11);
Sequence appendedSequence = firstSequence.append(secondSequence);
assertEquals("[1, 4, 9, 16, 9, 7, 4, 9, 11]", appendedSequence.toString());
assertEquals("[1, 4, 9, 16]", firstSequence.toString());
assertEquals("[9, 7, 4, 9, 11]", secondSequence.toString());
Sequence mergedSequence = firstSequence.merge(secondSequence);
assertEquals("[1, 9, 4, 7, 9, 4, 16, 9, 11]", mergedSequence.toString());
assertEquals("[1, 4, 9, 16]", firstSequence.toString());
assertEquals("[9, 7, 4, 9, 11]", secondSequence.toString());
}
@Test
public void problem10() {
Table table = new Table(4, 5); // 4 x 5 table
// Fill it with a sequence of values:
for (int i = 0; i < 4; i++) {
for (int j = 0; j < 5; j++) {
table.set(i, j, (3 + i) * (2 + j));
}
}
assertEquals(12.0, table.neighborAverage(1, 1), EPSILON);
assertEquals(25.0, table.neighborAverage(2, 3), EPSILON);
// Upper-left corner:
assertEquals(9.66667, table.neighborAverage(0, 0), EPSILON);
// Lower-right corner:
assertEquals(28.333333, table.neighborAverage(3, 4), EPSILON);
// Right-hand side:
assertEquals(21.6, table.neighborAverage(1, 4), EPSILON);
// Left-hand side:
assertEquals(10.4, table.neighborAverage(1, 0), EPSILON);
// Bottom row:
assertEquals(21.6, table.neighborAverage(3, 2), EPSILON);
// Top row:
assertEquals(14.4, table.neighborAverage(0, 2), EPSILON);
assertEquals(60.0, table.sum(0, true), EPSILON);
assertEquals(36.0, table.sum(0, false), EPSILON);
assertEquals(80.0, table.sum(1, true), EPSILON);
assertEquals(54.0, table.sum(1, false), EPSILON);
assertEquals(100.0, table.sum(2, true), EPSILON);
assertEquals(72.0, table.sum(2, false), EPSILON);
assertEquals(120.0, table.sum(3, true), EPSILON);
assertEquals(90.0, table.sum(3, false), EPSILON);
assertEquals(108.0, table.sum(4, false), EPSILON);
table = new Table(1, 1);
table.set(0, 0, -3);
assertEquals(0.0, table.neighborAverage(1, 1), EPSILON);
assertEquals(0.0, table.neighborAverage(8, 8), EPSILON);
assertEquals(-3.0, table.sum(0, true), EPSILON);
assertEquals(-3.0, table.sum(0, false), EPSILON);
}
}
