package Simulator;

public class CustomLogger {
    public static CustomLogger singleton = new CustomLogger();

    private String log;
    private CustomLogger() {
        log = "";
    }

    public void addNewLog(String str) {
        log += str;
        log += '\n';

        System.out.println(str);
    }

    public void printLog() {
        System.out.println(log);
    }
}
