package Simulator;

import Aircraft.AircraftFactory;
import Inteface.Flyable;
import Weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static List<String> data = new ArrayList<>();
    private static String error;
    private static List<Flyable> flyables = new ArrayList<>();
    private static WeatherTower weatherTower;
    private static int iterations;

    private static boolean parser(String file) {
        BufferedReader reader;
        String line;

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
    }

    private static boolean checker(List<String> list) throws CustomExeption {
        //чек на количество элементов
        if (list.size() < 2) {
            error = "Error: need more data";
            throw new CustomExeption(error);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] arr = list.get(i).split(" ");

            //чек на количество итераций
            if (i == 0) {
                try {
                    if (arr.length != 1) {
                        error = "line #" + (i + 1) + " wrong num iteration, now [" + list.get(i) + "], need: positive int number";
                        throw new CustomExeption(error);
                    }
                    if (Integer.parseInt(arr[0]) <= 0) {
                        error = "line #" + (i + 1) + " wrong num iteration, now [" + arr[0] + "], need: positive int number";
                        throw new CustomExeption(error);
                    }
                } catch (NumberFormatException e) {
                    error = "line #" + (i + 1) + " wrong number, now " + arr[0] + ", need: int number";
                    throw new CustomExeption(error);
                }
                continue;
            }

            //чек на количество параметров
            if (arr.length != 5) {
                error = "line #" + (i + 1) + " not enough parameters, now " + arr.length + ", need 5";
                throw new CustomExeption(error);
            }

            //чек на тип
            if (!arr[0].equals("Baloon") && !arr[0].equals("JetPlane") && !arr[0].equals("Helicopter")) {
                error = "line #" + (i + 1) + " wrong type, now " + arr[0] + ", need: Baloon or JetPlane or Helicopter";
                throw new CustomExeption(error);
            }

            //чек на число
            for (int x = 2; x < arr.length; x++) {
                try {
                    if (Integer.parseInt(arr[x]) <= 0) {
                        error = "line #" + (i + 1) + " wrong int num, now [" + arr[x] + "], need: positive int number";
                        throw new CustomExeption(error);
                    }
                } catch (NumberFormatException e) {
                    error = "line #" + (i + 1) + " wrong number, now " + arr[x] + ", need: int number";
                    throw new CustomExeption(error);
                }
            }

        }
        return true;
    }

    private static void startSimulation() {
        //сохраняем значение итерации
        iterations = Integer.parseInt(data.get(0));
        //генерируем башню
        weatherTower = new WeatherTower();
        //генерируем все летающие объекты
        for (String str : data) {
            String[] arr = str.split(" ");
            if (arr.length != 5) continue;
            flyables.add((new AircraftFactory().newAircraft(arr[0], arr[1],
                    Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]))));
        }
        //добавляем их в башню
        for (Flyable fly : flyables) {
            fly.registerTower(weatherTower);
        }

//        int sIter = 0;
        for (;iterations > 0; iterations--) {
//            CustomLogger.singleton.addNewLog("sim # " + sIter++);
            weatherTower.changeWeather();
        }
    }

    public static void main(String[] args) throws CustomExeption {
        if (args.length != 1) {
            System.out.println("usage: java Simulation scenario.txt");
        }
        else {
            if (!parser(args[0])) {
                return;
            }

            if (!checker(data)) {
                return;
            }

            //simulation
            startSimulation();

            //out >> simulation.txt
            CustomLogger.singleton.printLog("release");
        }
    }
}
