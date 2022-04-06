import java.util.Comparator;

public class PedometerManagerComparator implements Comparator<PedometerManager> {
    private int minSteps;

    @Override
    public int compare(PedometerManager p1, PedometerManager p2) {
        return p1.dayUpperLimit(minSteps) - p2.dayUpperLimit(minSteps);
    }

    public PedometerManagerComparator(int minSteps) {
        this.minSteps = minSteps;
    }

}
