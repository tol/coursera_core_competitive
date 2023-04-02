import static java.lang.Math.*;

import java.io.PrintWriter;
import java.util.Scanner;

public class AdditionAndSubtraction {

	/**
	 * Given two integers x and y, construct an infinite sequence of integers A = {a0, a1, a2, . . . } as
	 * follows: a0 = 0 and for every i ≥ 1, a2i−1 = a2i−2 + x and a2i = a2i−1 − y.
	 * Given three integers x, y and z, find the index of the first occurrence of z in A or report that z
	 * does not appear in A.
	 * For example, if x = 2, y = 1 and z = 3, then A = (0, 2, 1, 3, 2, 4, 3, . . .) and the answer is 3 (a3 = 3
	 * and this is the first occurrence of 3 in A). If x = 2, y = 0 and z = 3, then A = (0, 2, 2, 4, 4, 6, 6, . . .)
	 * and the answer is −1 (there is no occurrence of 3 in A).
	 * @param arg
	 *
	 *
	 * x-2 y-1 z-3
	 * A
	 * i=0 a[0]=0
	 * i=1 a[1]=a[0]+x=2
	 *     a[2]=a[1]-y=1
	 * i=2 a[3]=a[2]+x=3
	 *     a[4]=a[3]-y=2
	 *
	 *    a[n]=(n/2+n%2)*x-(n/2)*y
	 */
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int result = -1;
		int a=0;

		int i=1;

        while (a!=z && (abs((y-x))*i<=z)){
			a=(i/2+i%2)*x-(i/2)*y;
			i++;
		}

		if (a==z){
			result=i-1;
		}
        out.println(result);

        in.close();
        out.close();
    }
}
