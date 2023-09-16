public class Calculator {

    public int sum(int x, int y) {
        return x+y;
    }

    public double divide(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by 0!");
        }
        return x/y;
    }
}
