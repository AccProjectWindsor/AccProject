package textprocessing;


import java.util.ArrayList;
import java.util.List;

/***************************************************************
 *
 * Compilation: javac KMP.java Execution: java KMP pattern text
 *
 * Reads in two strings, the pattern and the input text, and searches for the
 * pattern in the input text using the KMP algorithm.
 *
 * % java KMP abracadabra abacadabrabracabracadabrabrabracad text:
 * abacadabrabracabracadabrabrabracad pattern: abracadabra
 *
 * % java KMP rab abacadabrabracabracadabrabrabracad text:
 * abacadabrabracabracadabrabrabracad pattern: rab
 *
 * % java KMP bcara abacadabrabracabracadabrabrabracad text:
 * abacadabrabracabracadabrabrabracad pattern: bcara
 *
 * % java KMP rabrabracad abacadabrabracabracadabrabrabracad text:
 * abacadabrabracabracadabrabrabracad pattern: rabrabracad
 *
 * % java KMP abacad abacadabrabracabracadabrabrabracad text:
 * abacadabrabracabracadabrabrabracad pattern: abacad
 *
 ***************************************************************/

public class MyKMP {
	private final int R; // the radix
	private int[][] dfa; // the KMP automoton

	private char[] pattern; // either the character array for the pattern
	private String pat; // or the pattern string

	// create the DFA from a String
	public MyKMP(String pat) {
		this.R = 256;
		this.pat = pat;

		// build DFA from pattern
		int M = pat.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X]; // Copy mismatch cases.
			dfa[pat.charAt(j)][j] = j + 1; // Set match case.
			X = dfa[pat.charAt(j)][X]; // Update restart state.
		}
	}

	// create the DFA from a character array over R-character alphabet
	public MyKMP(char[] pattern, int R) {
		this.R = R;
		this.pattern = new char[pattern.length];
		for (int j = 0; j < pattern.length; j++)
			this.pattern[j] = pattern[j];

		// build DFA from pattern
		int M = pattern.length;
		dfa = new int[R][M];
		dfa[pattern[0]][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X]; // Copy mismatch cases.
			dfa[pattern[j]][j] = j + 1; // Set match case.
			X = dfa[pattern[j]][X]; // Update restart state.
		}
	}

	// return offset of first match; N if no match
	public int search(String txt) {

		// simulate operation of DFA on text
		int M = pat.length();
		int N = txt.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == M)
			return i - M; // found
		return -1; // not found
	}

	public List<Integer> searchAll(final String txt) {

		List<Integer> resultList = new ArrayList<Integer>();
		StringBuilder targetString = new StringBuilder(txt);
		int sumPos = 0;

		while (true) {
			int pos = search(targetString.toString());
			if (pos < 0) {
				break;
			}
			resultList.add(pos + sumPos);
			targetString.delete(0, pos + pat.length());
			sumPos += pos + pat.length();
		}

		return resultList;
	}

	// return offset of first match; N if no match
	public int search(char[] text) {

		// simulate operation of DFA on text
		int M = pattern.length;
		int N = text.length;
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			j = dfa[text[i]][j];
		}
		if (j == M)
			return i - M; // found
		return N; // not found
	}

}
