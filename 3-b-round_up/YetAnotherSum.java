import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class YetAnotherSum {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n;
		n = in.nextInt();
		double[] a = new double[n];

		for (int i = 0; i < n; ++i)
			a[i] = in.nextDouble();




		// your code
		BigDecimal sum1= BigDecimal.valueOf(0);

		for(int i=0;i<n;i++){
			//sum1+=a[i]+(double)(1/a[i]);
			sum1=sum1.add(BigDecimal.valueOf(a[i])).add(BigDecimal.valueOf((double)1/a[i]));

		}
		//DecimalFormat myFormatter = new DecimalFormat("###.#");
		//String output = myFormatter.format(value);

		out.println(sum1);

		in.close();
		out.close();
	}
}
