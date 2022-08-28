package Weather;

import Tower.Tower;
import Tower.Coordinates;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherTower extends Tower {
    public WeatherTower(int iterations) {
        this.iterations = iterations;
    }

    public String getWeather(Coordinates coordinates) {
        return "Math.random()";
    }

    public void changeWeather() {

    }
}