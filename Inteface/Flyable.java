package Inteface;

import Weather.WeatherTower;

public interface Flyable {
    public void updateCondition();

    public void registerTower(WeatherTower Tower);
}
