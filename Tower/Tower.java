package Tower;

import java.util.List;
import java.util.ArrayList;

import Inteface.Flyable;
import Simulator.CustomLogger;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    protected int iterations;

    public void register(Flyable flyable) {
        observers.add(flyable);
        CustomLogger.singleton.addNewLog("Tower says: " + flyable.getFullName() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    void conditionsChanged() {
        for (Flyable fly : observers) {
            fly.updateCondition();
        }
    }

}
