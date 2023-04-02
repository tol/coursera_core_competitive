import static java.lang.Math.*;

import java.io.PrintWriter;
import java.util.Scanner;

import sun.applet.AppletResourceLoader;

public class CompareSums {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextDouble();
        for (int i = 0; i < n; ++i)
            b[i] = in.nextDouble();

        boolean equal_sum = false;
        boolean sum_a_larger = false;

        // your code
		double sum1=0;
		double sum2=0;
		for(int i=0;i<n;i++){
			sum1+=a[i];
			sum2+=b[i];
		}
		double precision=1e-4;
		if(abs(sum1-sum2)<precision) {
			equal_sum=true;
		} else{
			if (sum1>sum2){
				sum_a_larger=true;
			}
		}

        if (equal_sum)
            out.println("SUM(A)=SUM(B)");
        else {
            if (sum_a_larger)
                out.println("SUM(A)>SUM(B)");
            else
                out.println("SUM(A)<SUM(B)");
        }

        in.close();
        out.close();
    }
}
