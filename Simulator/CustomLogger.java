package Simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomLogger {
    public static CustomLogger singleton = new CustomLogger();

    private String log;
    private CustomLogger() {
        log = "";
    }

    public void addNewLog(String str) {
        log += str;
        log += '\n';
    }
    public void printLog(String str) throws CustomExeption {
        if (str.equals("release"))
        {
            try {
                File file = new File("simulation.txt");
                file.delete();
                BufferedWriter fd = new BufferedWriter(new FileWriter(file, true));
                fd.write(log);
                fd.close();
            } catch (IOException ioe) {
                throw new CustomExeption("Couldn't create simulation.txt file :(");
            }
        }
        else {
            System.out.println(log);
        }
    }
}
