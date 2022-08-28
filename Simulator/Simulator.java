package Simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static List<String> data = new ArrayList<>();
    private static String error;

    public Simulator() { /* constructor */ }

    private static boolean parser(String file) {
        BufferedReader reader;
        String line = " ";

        //парсим файл
        try {
            reader = new BufferedReader(new FileReader(file));
            while(true)
            {
                line = reader.readLine();
                if (line == null)
                    break;

                data.add(line);
            }
        } catch (IOException e) {
            error = e.toString();
            return false;
        }
        return true;

//        while (line != null) {
//
//            line = reader.readLine();
//            cnt++;
//            if (line == null || line.length() == 0)
//                continue;
//
//            String split[] = line.split(" ");
//            if (split.length == 0)
//                continue;
//            if (split.length != 5)
//                throw new AvajException("ERROR: Invalid line #" + cnt + " in a scenario file.");
//
//            try {
//                int coords[] = { Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]) };
//                for (int c : coords) {
//                    if (c < 1)
//                        throw new AvajException("ERROR: Invalid line #" + cnt + " in a scenario file." +
//                                "\nCoordinates must be POSITIVE INTEGERS!");
//                }
//
//                aircrafts.add(AircraftFactory.newAircraft(split[0], split[1], coords[0], coords[1], coords[2]));
//
//            } catch (NumberFormatException e) {
//                throw new AvajException("ERROR: Invalid line #" + cnt + " in a scenario file." +
//                        "\nCoordinates must be 3 positive, space-separated integers.");
//            }
//        }
    }

    private static boolean checker(List<String> list) {
        //чек на количество элеентов
        if (list.size() < 2) {
            error = "Error: need more data";
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            String[] arr = list.get(i).split(" ");

            //чек на количество итераций
            if (i == 0) {
                try {
                    Integer.parseInt(arr[0]);
                } catch (NumberFormatException e) {
                    error = "line #" + i + " wrong number, now " + arr[0] + ", need: int number";
                    return false;
                }
                continue;
            }

            //чек на количество параметров
            if (arr.length != 5) {
                error = "line #" + i + " not enough parameters, now " + arr.length + ", need 5";
                return false;
            }

            //чек на тип
            if (!arr[0].equals("Baloon") && !arr[0].equals("JetPlane") && !arr[0].equals("Helicopter")) {
                error = "line #" + i + " wrong type, now " + arr[0] + ", need: Baloon or JetPlane or Helicopter";
                return false;
            }

            //чек на число
            for (int x = 1; x < arr.length; x++) {
                try {
                    Integer.parseInt(arr[x]);
                } catch (NumberFormatException e) {
                    error = "line #" + i + " wrong number, now " + arr[x] + ", need: int number";
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java Simulation scenario.txt");
        }
        else {
            if (!parser(args[0])) {
                System.out.println("Error: " + error);
                return;
            }

            if (!checker(data)) {
                System.out.println("Error: " + error);
                return;
            }

            //simulation

            //out >> simulation.txt
        }
    }

}
