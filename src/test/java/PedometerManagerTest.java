import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class PedometerManagerTest {
    @Test
    public void compareToTest() {
        PedometerManager p1 = new PedometerManager();
        PedometerManager p2 = new PedometerManager();

        p1.add(1, 12);
        p1.add(2, 8);

        p2.add(1, 25);
        p2.add(2, 32);

        int expected = -37;
        int actual = p1.compareTo(p2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTest(){
        PedometerManager p1 = new PedometerManager();
        PedometerManager p2 = new PedometerManager();

        p1.add(1, 12);
        p1.add(2, 8);
        p1.add(3, 12);
        p2.add(1, 25);
        p2.add(2, 32);
        p2.add(3, 8);
        p2.add(4, 12);
        p2.add(4, 12);

        PedometerManagerComparator comparator = new PedometerManagerComparator(10);
        int expected = -1;
        int actual = comparator.compare(p1,p2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void predicTest(){
        PedometerManager p1 = new PedometerManager();
        p1.add(1, 12_000);
        p1.add(2, 8000);
        p1.add(3, 2_000);
        p1.add(4, 16_000);
        p1.add(5, 22_000);
        p1.add(6, 3_000);

        p1.printAllByCriteria(steps -> steps > 10000);

    }

    @Test
    public void negativeDayTest(){
        PedometerManager p1 = new PedometerManager();
        Assertions.assertThrows(IllegalDayException.class,() -> {
            p1.add(-1,100);
        });
    }

    @Test
    public void positiveOverDayTest(){
        PedometerManager p1 = new PedometerManager();
        Assertions.assertThrows(IllegalDayException.class,() -> {
            p1.add(366,100);
        });
    }

    @Test
    public void negativeStepsTest(){
        PedometerManager p1 = new PedometerManager();
        Assertions.assertThrows(IllegalStepsException.class,() -> {
            p1.add(1,-100);
        });
    }
}
