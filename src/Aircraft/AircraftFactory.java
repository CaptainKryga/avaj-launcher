package Aircraft;

import Fly.Baloon;
import Fly.Helicopter;
import Fly.JetPlane;
import Inteface.Flyable;
import Tower.Coordinates;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates newCoord = new Coordinates(longitude,latitude,height);
        if (type.equals("Baloon")) {
            return new Baloon(name, newCoord);
        }
        else if (type.equals("JetPlane")) {
            return new JetPlane(name, newCoord);
        }
        else {
            return new Helicopter(name, newCoord);
        }
    }
}
