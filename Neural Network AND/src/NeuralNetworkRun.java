
import java.util.Scanner;

public class NeuralNetworkRun {
    public NeuralNetworkRun() {
    }

    public static void main(String[] args) {

        double y_in = 0.0D;
        double CB = 0.0D;
        boolean con = true;
        Scanner counter = new Scanner(System.in);
        System.out.println("Enter weight count: ");
        int count = counter.nextInt();
        int[] xi = new int[count];
        double[] wi = new double[count];
        double[] Cwi = new double[count];
        double[] b = new double[count];

        for(int ix = 0; count > ix; ++ix) {
            wi[ix] = 0.0D;
        }



        for(int x = 0; x < count; ++x) {
            b[x] = b[0];
        }

        Scanner LearningRate = new Scanner(System.in);
        System.out.println("Enter LearningRate(0<Rate<=1):  ");
        double a = LearningRate.nextDouble();

        while(con) {
            Scanner target;
            int i;
            for(i = 0; i < count; ++i) {
                target = new Scanner(System.in);
                System.out.println("Enter input: x" + (i + 1));
                xi[i] = target.nextInt();
            }

            target = new Scanner(System.in);
            System.out.println("Enter Target(t):  ");
            int t = target.nextInt();
            i = 0;
            double sum = 0.0D;

            int c;
            for(c = 0; c < count; ++c) {
                sum += wi[c] * (double)xi[c];
            }

            y_in = b[0] + sum;
            byte y;
            if (y_in > 0.0D) {
                y = 1;
            } else if (y_in == 0.0D) {
                y = 0;
            } else {
                y = -1;
            }

            for(c = 0; c < count; ++c) {
                System.out.println("weights w" + (c + 1) + " " + wi[c]);
            }

            System.out.println("Bias B" + b[0]);

            for(; i < count; ++i) {
                double Bold;
                double Wold;
                if (y != t) {
                    Wold = wi[i];
                    wi[i] += a * (double)t * (double)xi[i];
                    Cwi[i] = wi[i] - Wold;
                    Bold = b[i];
                    b[i] += a * (double)t;
                    CB = b[i] - Bold;
                } else {
                    Wold = wi[i];
                    Cwi[i] = wi[i] - Wold;
                    Bold = b[i];
                    CB = b[i] - Bold;
                    con = false;
                }
            }

            for(c = 0; c < count; ++c) {
                System.out.println("Inputs x" + (c + 1) + " " + xi[c]);
            }

            System.out.println("Y_in " + y_in);
            System.out.println("y " + y);
            System.out.println("T" + t);

            for(c = 0; c < count; ++c) {
                System.out.println("Changes wi" + (c + 1) + " " + Cwi[c]);
            }

            System.out.println("Changes B " + CB);
        }

        for(int c = 0; c < count; ++c) {
            System.out.println("weights w" + (c + 1) + " " + wi[c]);
        }

        System.out.println("Bias B" + b[0]);
        System.out.println("Code is finished because Y is equal to T");
    }
}
