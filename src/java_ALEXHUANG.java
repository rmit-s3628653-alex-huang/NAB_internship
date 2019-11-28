import java.util.ArrayList;

public class java_ALEXHUANG {

	public static void main(String[] args) {
		NABTest();
	}

	// N is string with the following possible conditions:
	// (a) empty, (b) numeric, (c) non-numeric, (d) mixed , (e) case sensitive
	static String N = "abcabc";

	// Determine which substrings repeat as well as how many there are
	// eg. input: "123123" output: 6 substrings: 1,12,123,2,23,3
	private static void NABTest() {
		int counter = 0;
		ArrayList<String> repArray = new ArrayList<String>();
		String tempSub;
		String tempString;
		for (int i = 0; i < N.length(); i++) {
			for (int j = 1; j < N.length(); j++) {
				if (i + j <= N.length()) {
					tempSub = N.substring(i, i + j);
					tempString = N;

					// check if we've already checked this substring
					if (repArray.contains(tempSub) == false) {
						// remove substring from the string
						// replace with space to prevent creation of incorrect string for comparison
						tempString = tempString.replaceFirst(tempSub, " ");
						if (tempString.contains(tempSub)) {
							repArray.add(tempSub);
							counter++;
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
