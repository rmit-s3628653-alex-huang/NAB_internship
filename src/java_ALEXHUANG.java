// NAB Technology Internship Program - Coding Test - Repeating Substrings
// Completed by ALEX HUANG - 0424224782 - ahuang4321@gmail.com

import java.util.ArrayList;
import java.util.Scanner;

class java_ALEXHUANG {

	// N is string with the following possible conditions:
	// (a) empty, (b) numeric, (c) non-numeric, (d) mixed, (e) case sensitive
	// String was given 'static' keyword as java cannot make a static reference
	// to a non-static variable
	static String N = "123123";

	public static void main(String[] args) {
		System.out.println("NAB Technology Internship Program - Coding Test - Repeating Substrings"
				+ "\nCompleted by ALEX HUANG - 0424224782 - ahuang4321@gmail.com");
		Scanner keyboard = new Scanner(System.in);
		while (true) { // loop until user termination
			System.out.println("Enter your string (case sensitive)" + "\nor type 'n' to use default N string: " + N
					+ "\nor 'e' to terminate program: ");
			String NABString = keyboard.nextLine();

			if (NABString.equals("n")) { // default string
				NABTest(N);
			} else if (NABString.equals("e")) { // terminate
				System.out.println("Program Terminated");
				break;
			} else {
				NABTest(NABString);
			}
			System.out.println();
		}
		keyboard.close();
	}

	// Determine which substrings repeat as well as how many there are
	// eg. input: "123123" output: 6 substrings: 1,12,123,2,23,3
	// eg. input: "abcabc" output: 6 substrings: a,ab,abc,b,bc,c
	public static void NABTest(String N) {

		int counter = 0; // counter counting the number of repeated substrings
		ArrayList<String> repArray = new ArrayList<String>(); // arraylist of repeated substrings
		String tempSub; // base substring to compare
		String tempComp; // secondary substring to compare to tempSub
		int compLength;

		// Create one substring and then compare to other substrings
		for (int i = 0; i < N.length(); i++) {

			for (int j = 1; j < N.length(); j++) {

				// make i+j doesn't go out of bounds
				// for efficiency purposes N.length/2 to avoid looping through substrings that
				// are impossible
				if (i + j <= N.length() && j <= N.length() / 2) {
					tempSub = N.substring(i, i + j);

					compLength = tempSub.length(); // value to make sure we only compare to same length substrings

					// only get comparison substring from string after the main substring
					for (int k = i + j; k < N.length(); k++) {

						if (k + compLength <= N.length()) {
							tempComp = N.substring(k, k + compLength);

							// only compare if we substring hasn't been tested
							if (repArray.contains(tempComp) == false) {

								// if two temp strings are the same that means it is repeating
								if (tempSub.equals(tempComp)) {
									repArray.add(tempComp); // add to the array of repeated substrings
									counter++; // increase repeat substring counter
								}
							}
						}
					}
				}

			}
		}

		// convert arraylist into a printable stringbuilder
		StringBuilder repValues = new StringBuilder();
		for (String s : repArray) {
			repValues.append(s);
			if (s.equals(repArray.get(repArray.size() - 1)) == false) {
				repValues.append(",");
			}
		}

		if (counter == 0) {
			System.out.println("No repeating substrings detected");
		} else {
			System.out.println(counter + " substrings  -  " + repValues);
		}
	}
}