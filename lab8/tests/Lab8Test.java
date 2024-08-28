package labs.lab8.tests;
import static org.junit.Assert.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import labs.lab8.*;
public class Lab8Test {
@Test
public void problem1() {
String[] words = {"Mary", "had", "a", "little", "lamb"};
// (using Lambda expression here for brevity in this example; Lambda expressions will be covered in week 10):
assertEquals("little", Measurer.max(words, s -> s.length()));
// this example uses java.awt.Rectangle:
Rectangle[] rects = {
new Rectangle(1, 2, 10, 20),
new Rectangle(5, 15, 17, 23),
new Rectangle(9, 15, 25, 22),
new Rectangle(12, 8, 18, 23)};
// (using Lambda expression here for brevity in this example; Lambda expressions will be covered in week 10):
Rectangle rectangle = Measurer.max(rects, r -> r.getWidth() *
r.getHeight());
assertEquals(rects[2], rectangle);
}
@Test
public void problem2() {
// Integer pair:
Pair<Integer> intPair = new Pair<>(17, 19);
assertEquals(17, intPair.getFirst().intValue());
assertEquals(19, intPair.getSecond().intValue());
intPair.swap();
assertEquals(19, intPair.getFirst().intValue());
assertEquals(17, intPair.getSecond().intValue());
intPair.swap();
assertEquals(17, intPair.getFirst().intValue());
assertEquals(19, intPair.getSecond().intValue());
// String pair:
Pair<String> strPair = new Pair<>("Robert", "Navarro");
assertEquals("Robert", strPair.getFirst());
assertEquals("Navarro", strPair.getSecond());
strPair.swap();
assertEquals("Navarro", strPair.getFirst());
assertEquals("Robert", strPair.getSecond());
strPair.swap();
assertEquals("Robert", strPair.getFirst());
assertEquals("Navarro", strPair.getSecond());
// Color pair:
Pair<Color> colorPair = new Pair<>(Color.PINK, Color.GRAY);
assertEquals(Color.PINK, colorPair.getFirst());
assertEquals(Color.GRAY, colorPair.getSecond());
colorPair.swap();
assertEquals(Color.GRAY, colorPair.getFirst());
assertEquals(Color.PINK, colorPair.getSecond());
colorPair.swap();
assertEquals(Color.PINK, colorPair.getFirst());
assertEquals(Color.GRAY, colorPair.getSecond());
colorPair.swap();
assertEquals(Color.GRAY, colorPair.getFirst());
assertEquals(Color.PINK, colorPair.getSecond());
}
@Test
public void problem3() {
List<String> strList = new ArrayList<>();
strList.add("apple");
strList.add("orange");
strList.add("pear");
strList.add("banana");
List<String> expStrList = Arrays.asList("banana", "pear", "orange",
"apple");
assertEquals(expStrList, Main.problem3_reverse(strList));
assertEquals(expStrList, strList);
List<Integer> intList = new ArrayList<>();
intList.add(0);
intList.add(1);
intList.add(2);
intList.add(3);
intList.add(4);
List<Integer> expIntList = Arrays.asList(4, 3, 2, 1, 0);
assertEquals(expIntList, Main.problem3_reverse(intList));
assertEquals(expIntList, intList);
List<Double> dblList = new ArrayList<>();
dblList.add(1.5);
dblList.add(2.5);
dblList.add(3.5);
dblList.add(4.5);
List<Double> expDblList = Arrays.asList(4.5, 3.5, 2.5, 1.5);
assertEquals(expDblList, Main.problem3_reverse(dblList));
assertEquals(expDblList, dblList);
List<Point> ptList = new ArrayList<>();
ptList.add(new Point(0, 0));
List<Point> expPtList = Arrays.asList(new Point(0, 0));
assertEquals(expPtList, Main.problem3_reverse(ptList));
assertEquals(expPtList, ptList);
List<Point> ptList2 = new ArrayList<>();
List<Point> expPtList2 = new ArrayList<>();
assertEquals(expPtList2, Main.problem3_reverse(ptList2));
assertEquals(expPtList2, ptList2);
}
@Test
public void problem4() {
Integer[] nums = { 10, 100, 50, 15, 8, 99 };
Pair<Integer> mm = Main.problem4_minmax(nums);
assertEquals(8, mm.getFirst().intValue());
assertEquals(100, mm.getSecond().intValue());
}
@Test
public void problem5() {
List<String> a = Arrays.asList("apple", "orange");
List<String> b = Arrays.asList("pear", "banana");
List<String> c = Appender.append(a, b);
assertEquals(Arrays.asList("apple", "orange"), a);
assertEquals(Arrays.asList("pear", "banana"), b);
assertEquals(Arrays.asList("apple", "orange", "pear", "banana"), c);
List<Integer> intList1 = Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0);
List<Integer> intList2 = Arrays.asList(-8, 19, 4, 0, 20);
List<Integer> intList3 = Appender.append(intList1, intList2);
assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0), intList1);
assertEquals(Arrays.asList(-8, 19, 4, 0, 20), intList2);
assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4,
0, 20), intList3);
List<Double> dblList1 = Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385,
-29.0, -0.3, 0.0);
List<Double> dblList2 = Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0);
List<Double> dblList3 = Appender.append(dblList1, dblList2);
assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -
0.3, 0.0), dblList1);
assertEquals(Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0), dblList2);
assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -
0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0),
dblList3);
String[] d = { "apple", "orange" };
String[] e = { "pear", "banana" };
String[] f = Appender.append(d, e);
assertTrue(Arrays.equals(new String[] { "apple", "orange" }, d));
assertTrue(Arrays.equals(new String[] { "pear", "banana" }, e));
assertTrue(Arrays.equals(new String[] { "apple", "orange", "pear",
"banana" }, f));
Integer[] intArr1 = { 3, 13, 44, 18, 987, -29, -3, 0 };
Integer[] intArr2 = { -8, 19, 4, 0, 20 };
Integer[] intArr3 = Appender.append(intArr1, intArr2);
assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0
}, intArr1));
assertTrue(Arrays.equals(new Integer[] { -8, 19, 4, 0, 20 }, intArr2));
assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3,
0, -8, 19, 4, 0, 20 }, intArr3));
Double[] dblArr1 = { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3,
0.0 };
Double[] dblArr2 = { -0.0008, 1.9, 4.2, 0.0, 2.0 };
Double[] dblArr3 = Appender.append(dblArr1, dblArr2);
assertTrue(Arrays.equals(new Double[] { 3.2, 13.3, 44.4, 18.0,
987.9385, -29.0, -0.3, 0.0 }, dblArr1));
assertTrue(Arrays.equals(new Double[] { -0.0008, 1.9, 4.2, 0.0, 2.0 },
dblArr2));
assertTrue(Arrays.equals(
new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -
0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0 },
dblArr3));
}
}