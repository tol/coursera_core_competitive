import java.io.PrintWriter;
import java.util.Scanner;

public class RoundUp {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y;
        x = in.nextInt();
        y = in.nextInt();

        int result = 0;

        result= (int) Math.ceil((double)x/y);

        out.println(result);

        in.close();
        out.close();
    }
}
