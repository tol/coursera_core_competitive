import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CheapestPermutation {

	static int cost(Integer[] p, int[][]m){
		int c=0;
		for(int i=0;i<p.length-1;i++){
			c+=m[p[i]-1][p[i+1]-1];
		}
		return c;
	}
	static <T extends Comparable<? super T>> boolean nextPermutation(T[] sequence) {
		int first = getFirst(sequence);
		if (first == -1) return false;
		int toSwap = sequence.length - 1;
		while (sequence[first].compareTo(sequence[toSwap]) >= 0) --toSwap;
		swap(sequence, first++, toSwap);
		toSwap = sequence.length - 1;
		while (first < toSwap) swap(sequence, first++, toSwap--);
		return true;
	}

	static <T extends Comparable<? super T>> int getFirst(T[] sequence) {
		for (int i = sequence.length - 2; i >= 0; --i)
			if (sequence[i].compareTo(sequence[i + 1]) < 0) return i;
		return -1;
	}

	static <T extends Comparable<? super T>> void swap(T[] sequence, int i, int j) {
		T tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
	}


    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                a[i][j] = in.nextInt();

		//int n=5;
        Integer[] result = new Integer[n];

        // your code

		Integer[] perm=new Integer[n];

		int cost=Integer.MAX_VALUE;
		for(int i=1;i<n+1;i++){
			perm[i-1]=i;
		}

		result=Arrays.copyOf(perm,perm.length);
		do {

			//System.out.println(java.util.Arrays.toString(perm));
			int c=cost(perm,a);
			if (c<cost){
				result=Arrays.copyOf(perm,perm.length);
				cost=c;
			}

			// Loop while alpha is not at its highest permutation ordering
		} while (nextPermutation(perm));

		//generate permutations
        for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }
}
