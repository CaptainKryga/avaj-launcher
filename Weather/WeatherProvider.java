package Weather;

import Tower.Coordinates;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather;

    private WeatherProvider() {
        weather = new String[]{
                "RAIN",
                "FOG",
                "SUN",
                "SNOW"
        };
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[ThreadLocalRandom.current().nextInt(0, 4)];
    }
}
