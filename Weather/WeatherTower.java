package Weather;

import Tower.Tower;
import Tower.Coordinates;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return "Math.random()";
    }

    public void changeWeather() {

    }
}