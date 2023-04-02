import java.io.PrintWriter;
import java.util.Scanner;

public class SumofMinimums {

	public static int min(int[] a,int start,int len){
		int min=a[start];
		for(int x=start;x<start+len;x++){
		//	System.out.print(x+" ");
			if(a[x]<min){
				min=a[x];
			}
		}
		//System.out.println();
		return min;
	}

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n;
		n = in.nextInt();
		int[] a=new int[n];

		for (int i = 0; i < n; ++i)
				a[i] = in.nextInt();

		long result=0;
		for(int seqlen=1;seqlen<=n;seqlen++){

			for(int start=0;start<n-seqlen+1;start++){

				result+=min(a,start,seqlen);

			}

		}



		out.println(result);

		in.close();
		out.close();
	}
}
