package Fly;

import Aircraft.Aircraft;
import Inteface.Flyable;
import Tower.Coordinates;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "JetPlane";
    }

    public void updateCondition() {

    }

    public void registerTower(WeatherTower Tower) {
        Tower.register(this);
    }
}
