package labs.lab7;
import java.util.Scanner;
/**
* Exercising a runway simulation.
*/
public class RunwaySimulationUI {
public static void main(String[] args) {
RunwaySimulator simulator = new RunwaySimulator();
Scanner in = new Scanner(System.in);
boolean done = false;
System.out.println("Runway Simulator Menu");
System.out.println("-----------------------------------------------");
System.out.println(" > takeoff/land followed by the flight symbol");
System.out.println(" > next to perform next action");
System.out.println(" > quit to quit simulation.");
System.out.println();
while (!done) {
System.out.print(" > ");
String action = in.next();
if (action.equals("takeoff")) {
String flightSymbol = in.next();
simulator.addTakeOff(flightSymbol);
} else if (action.equals("land")) {
String flightSymbol = in.next();
simulator.addLanding(flightSymbol);
} else if (action.equals("next")) {
System.out.println(simulator.handleNextAction());
} else if (action.equals("quit")) {
done = true;
}
}
System.out.println();
System.out.println(" -- Thank you --");
}
}
