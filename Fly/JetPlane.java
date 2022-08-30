package Fly;

import Aircraft.Aircraft;
import Inteface.Flyable;
import Simulator.CustomLogger;
import Tower.Coordinates;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "JetPlane";

        rain = new String[] {
                //Так и знал что нужно было дворники заменить.
            "I knew that the wipers needed to be replaced."
        };
        fog = new String[] {
                //Лечу по радарам.
            "I'm on the radar."
        };
        sun = new String[] {
                //Кажется я забыл солнцезащитные очки дома =(
            "I think I forgot my sunglasses at home =("
        };
        snow = new String[] {
                //СНЕГ СНЕГ СНЕГ КАК МНОГО СНЕГА.
            "SNOW SNOW SNOW HOW MUCH SNOW."
        };
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("RAIN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + rain[0]);
        }
        else if (weather.equals("FOG")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + fog[0]);
        }
        else if (weather.equals("SUN")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 2);
            CustomLogger.singleton.addNewLog(this.getFullName() + ":" + sun[0]);
        }
        else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 7);
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
