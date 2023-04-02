import java.io.PrintWriter;
import java.util.Scanner;

public class BinaryKnapsack {
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n;
		n = in.nextInt();

		int maxw;
		maxw = in.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];

		for (int i = 0; i < n; ++i) {
			w[i] = in.nextInt();
			v[i] = in.nextInt();
		}
        int result=0;



		// your code


		out.println(result);

		in.close();
		out.close();
	}
}
