package textprocessing;

public class Tester {

	public static void main(String[] args) {

		String text = "kkkasdfjas;kkkldkjfa;llskdjf;laksjf;lkkkasddjf;aksljdjf;laksjdf;lskdjf";
		MyKMP kmp = new MyKMP("a");
		
		System.out.println(kmp.searchAll(text));
		
		

	}

}
