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

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int rnd = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() +
                ThreadLocalRandom.current().nextInt(0, 100);
        if (rnd < 0)
            rnd *= -1;
        return weather[rnd % 4];
    }
}
