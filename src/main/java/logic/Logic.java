package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Logic {
    public List<Point> tabulate(double start, double finish, double step, DoubleUnaryOperator f) {
        int steps = (int) (Math.round((finish - start) / step) + 1);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < steps; i++) {
            double x = start + i * step;
            double y = f.applyAsDouble(x);
            points.add(new Point(x,y));
        }
        return points;
    }
}
