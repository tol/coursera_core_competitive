import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StraightFlush {


	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s=in.nextLine();
		//2D 5D 3D 4D 6D
		String result="yes";
		String[] cards=s.split(" ");
		Set<String> cardsColour=new HashSet<>();
		Arrays.stream(cards).forEach(x-> cardsColour.add(x.substring(1)));

        boolean sameColour=cardsColour.size()==1;

		List<Integer> iCards=new ArrayList<>();

		iCards= getCards(cards, true);
        boolean seq=true;
		Collections.sort(iCards);
		for(int i=1;i<5;i++){
			if (iCards.get(i)!=iCards.get(i-1)+1){
				seq=false;
			}
		}
		boolean seq2=true;
		iCards= getCards(cards, false);
		Collections.sort(iCards);
		for(int i=1;i<5;i++){
			if (iCards.get(i)!=iCards.get(i-1)+1){
				seq2=false;
			}
		}
        result=(sameColour && (seq ||seq2))?"Yes" :"No";

		out.print(result);

		out.println();

		in.close();
		out.close();
	}

	private static List<Integer> getCards(String[] cards, boolean aceHigh) {
		return Arrays.stream(cards).map(x-> {
			char c=x.charAt(0);
			switch (c) {
				case 'A': return aceHigh ? 14 : 1;
				case 'K': return 13;
				case 'Q': return 12;
				case 'J': return 11;
				case 'T': return 10;
			}
			return c - '0';
		}).collect(Collectors.toList());
	}
}
