package TestingFunctions;

//class for testing methods
public class TestingService {

    public double ackleyFunction(double[] x) {
        double sum1 = 0;
        double sum2 = 0;

        for (double aX : x) {
            sum1 += Math.pow(aX, 2);
            sum2 += (Math.cos(2 * Math.PI * aX));
        }

        return -20.0*Math.exp(-0.2*Math.sqrt(sum1 / ((double )x.length))) + 20
                - Math.exp(sum2 /((double )x.length)) + Math.exp(1.0);
    }

    public double griewankFunction(double[] x) {
        double sum = 0;
        double prod = 1;
        for (int i = 0; i < x.length; ++i) {
            sum += x[i] * x[i];
            prod *= Math.cos(x[i] / Math.sqrt(i + 1));
        }
        return 1 + sum * (1.0 / 4000.0) - prod;
    }

    public double sumSquaresFunction(double[] x) {
        double sum = 0;

        for (int i = 0; i < x.length; ++i) {
            sum += x[i] * x[i] * (i + 1);
        }

        return sum;
    }


}
