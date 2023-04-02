import java.io.PrintWriter;
import java.util.Scanner;

public class ExpressionEvaluation {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

	    String expr;
		expr = in.nextLine();


		int result = 0;
		int indexop=0;
		do {
			indexop=-1;
			int indexop1 = expr.indexOf("+",1);
			int indexop2 = expr.indexOf("-",1);
			if (indexop1 != -1) {
				indexop = indexop1;
			}
			if (indexop2 != -1 &&  ((indexop2 < indexop1) || indexop1==-1)) {
				indexop = indexop2;
			}

			if(indexop!=-1) {
				 long first =Long.parseLong(expr.substring(0, indexop));
				int lastN = expr.length();
				int indexopN1 = expr.indexOf("+",indexop+1);
				int indexopN2 = expr.indexOf("-",indexop+1);
				if (indexopN1 != -1) {
					lastN = indexopN1;
				}
				if (indexopN2 != -1 && (indexopN2 < indexopN1 ||indexopN1==-1 )) {
					lastN = indexopN2;
				}
				long last = Long.parseLong(expr.substring(indexop + 1, lastN));
				String op = expr.substring(indexop, indexop + 1);
				long r = 0;
				if (op.equals( "+")) {
					r = first + last;
				}
				else {
					r = first - last;
				}
				expr = r + expr.substring(lastN);
				//System.out.println(expr);
			}
		}
		while (indexop!=-1);

		// your code



		out.println(expr);

		in.close();
		out.close();
	}
}
