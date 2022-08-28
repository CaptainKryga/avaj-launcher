package Fly;

import Aircraft.Aircraft;
import Inteface.Flyable;
import Simulator.CustomLogger;
import Tower.Coordinates;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Helicopter";
        rain = new String[] {
                //Vanes are faster than drops, he-he-he.
                "Vanes are faster than drops, he-he-he."
        };
        fog = new String[] {
                //ААААААААААА я ничего не вижу.
                "AAAAAAAAAA I don't see anything."
        };
        sun = new String[] {
                //Кайф, солнце день чудесный
                "Kaif, the sun is a wonderful day"
        };
        snow = new String[] {
                //Сейчас бы на новый год в турцию сгонять.
                "Now to drive to Turkey for the new year."
        };
    }

    public void updateCondition() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("RAIN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight());
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + rain[0]);
        }
        else if (weather.equals("FOG")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight());
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + fog[0]);
        }
        else if (weather.equals("SUN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + sun[0]);
        }
        else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 12);
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
