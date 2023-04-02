import java.io.PrintWriter;
import java.util.Scanner;

public class ErasingMaximum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int[] result = new int[n - 1];


        // your code
		int max=-1;
		int nomax=0;
		for (int i = 0; i < n; ++i) {
			if (max <a[i]) {
				max = a[i];
				nomax=1;
			}
			if (max ==a[i]) {
				nomax++;
			}
		}

		int cmax=0;
		int j=0;
		for (int i = 0; i < a.length; ++i) {
			if (max ==a[i]) {
				cmax++;
				if (nomax>3){
					if (cmax!=3){
						result[j++]=a[i];
					}

				}else {
//skip one
				}
			}else{
				result[j++]=a[i];
			}
		}

		for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }
}
