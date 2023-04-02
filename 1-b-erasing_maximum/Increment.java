import java.io.PrintWriter;
import java.util.Scanner;

public class Increment {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s=in.next();

		int result=0;
		int r=1;

		for (int i=s.length()-1;i>=0;i--){
			int d=Character.getNumericValue(s.charAt(i));
			if (d!=9){
				r=0;
			}

		}
		result=s.length()+r;
		out.print(result);
		out.println();

		in.close();
		out.close();
	}

}
