// NAB Technology Internship Program - Coding Challenge
// Completed by ALEX HUANG
import java.util.ArrayList;

class java_ALEXHUANG {

	public static void main(String[] args) {
		NABTest();
	}

	// N is string with the following possible conditions:
	// (a) empty, (b) numeric, (c) non-numeric, (d) mixed , (e) case sensitive
	static String N = "abcabc";

	// Determine which substrings repeat as well as how many there are
	// eg. input: "123123" output: 6 substrings: 1,12,123,2,23,3
	// eg. input: "abcabc" output: 6 substrings: a,ab,abc,b,bc,c
	public static void NABTest() {

		int counter = 0;
		ArrayList<String> repArray = new ArrayList<String>();
		String tempSub;
		String tempComp;
		int compLength;

		for (int i = 0; i < N.length(); i++) {
			
			for (int j = 1; j < N.length(); j++) {
				
				if (i + j <= N.length() && j <= N.length() / 2 && j <= N.length() - (i + j)) {
					tempSub = N.substring(i, i + j);
					compLength = tempSub.length();
					// check if we've already checked this substring
					
					for (int k = i + j; k < N.length(); k++) {
						
						if (k + compLength <= N.length()) {
							tempComp = N.substring(k, k + compLength);
							
							if (repArray.contains(tempComp) == false) {
								
								if (tempSub.equals(tempComp)) {
									repArray.add(tempComp);
									counter++;
								}
							}
						}
					}
				}

			}
		}

		StringBuilder repValues = new StringBuilder();
		for (String s : repArray) {
			repValues.append(s);
			if (s.equals(repArray.get(repArray.size() - 1)) == false) {
				repValues.append(",");
			}
		}

		if (counter == 0) {
			System.out.println("no repeating substrings detected");
		} else {
			System.out.println(counter + " substrings - " + repValues);
		}
	}
}
