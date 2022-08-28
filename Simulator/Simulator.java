package Simulator;

public class Simulator {
    public Simulator() { /* constructor */ }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java Simulation scenario.txt");
        }
        else {
            System.out.println(args[0]);
        }
    }

}
