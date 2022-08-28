package Fly;

import Aircraft.Aircraft;
import Inteface.Flyable;
import Simulator.CustomLogger;
import Tower.Coordinates;
import Weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Baloon";

        rain = new String[] {
                //Надо быстрее вычерпывать воду, а то сейчас приземлимся -_-.
                "We must quickly scoop up water, otherwise we will land now -_-"
        };
        fog = new String[] {
                //Ничего не вижу, надеюсь в мены никто не влетит..
                "I don’t see anything, I hope no one will fly into me..."
        };
        sun = new String[] {
                //СОЛНЦЕ ОООО ДА!
                "SUN OOOOO YES!"
        };
        snow = new String[] {
                //Кто придумал снег в середине мая?
                "Who invented snow in mid-May?"
        };
    }

    public void updateCondition() {
        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("RAIN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + rain[0]);
        }
        else if (weather.equals("FOG")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude() - 3,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + fog[0]);
        }
        else if (weather.equals("SUN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 2,
                    coordinates.getHeight() + 4);
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + sun[0]);
        }
        else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + snow[0]);
        }

        if (coordinates.getHeight() <= 0) {
            CustomLogger.singleton.addNewLog(this.getFullName() + " landing.");
            weatherTower.unregister(this);
        }

    }

    public void registerTower(WeatherTower WeatherTower) {
        weatherTower = WeatherTower;
        WeatherTower.register(this);
    }
}
