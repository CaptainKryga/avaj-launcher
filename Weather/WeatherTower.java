package Weather;

import Tower.Tower;
import Tower.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}