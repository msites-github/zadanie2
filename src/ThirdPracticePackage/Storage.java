package ThirdPracticePackage;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;

    public static synchronized Storage getInstance() {
        synchronized (Storage.class) {
            if (instance == null) {
                instance = new Storage();
            }
            return instance;
        }
    }

    private Storage() {

    }

    private List<Double> myValues = new ArrayList<>();

    public void add(double value) {
        myValues.add(value);
    }

    public double getLast() {
        return myValues.get(myValues.size() - 1);
    }
}
