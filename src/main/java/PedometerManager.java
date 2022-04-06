import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PedometerManager implements Comparable<PedometerManager> {
    private Map<Integer, Integer> data = new HashMap<>();
    private int max = 0;

    public int add(int day, int steps) {
        if (day <= 0 || day > 365) {
            throw new IllegalDayException(day);
        } else if (steps >= 0) {
            int newValue = data.getOrDefault(day, 0) + steps;
            data.put(day, newValue);
            if (max < newValue) {
                max = newValue;
            }
            return max + 1 - steps;
        } else {
            throw new IllegalStepsException(steps);
        }
    }

    public int sum() {
        int sum = 0;
        for (int steps : data.values()) {
            sum += steps;
        }
        return sum;
    }

    public int dayUpperLimit(int minSteps) {
        int response = 0;
        for (int steps : data.values()) {
            if (steps > minSteps) {
                response++;
            }
        }
        return response;
    }

    public void printAllByCriteria(Predicate<Integer> predicate) {
        for (int day : data.keySet()) {
            if (predicate.test(data.get(day))) {
                System.out.println("День " + day + " шагов " + data.get(day));
            }
        }
    }

    @Override
    public int compareTo(PedometerManager pedometerManager) {
        return sum() - pedometerManager.sum();
    }
}
