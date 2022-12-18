package ValidSentence;

public class ValidSentence {

	public static void main(String[] args) {

		System.out.println(validString("There is no punctuation in this sentence."));
	}
	
	public static boolean validString(String s) {

		int len = s.length();
		int count = 0;
		char value = '"';

		// starts with capital letter
		if (!Character.isUpperCase(s.charAt(0)))
			return false;

		// even number of speech marks
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == value)
				count++;
		}
		if (count % 2 != 0)
			return false;

		// ends with punctuation
		if (s.charAt(len - 1) != '.') {
			if (s.charAt(len - 1) != '!') {
				if (s.charAt(len - 1) != '?') {
					return false;
				}
			}
		}
		// only punctuation at the end
		for (int i = 0; i < len - 2; i++) {
			if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?')
				return false;
		}

		// numbers below 13 are spelled out
		// initialise variable word, loop through until there is a number,
		// build this number and store it in word, if number is < 13 return invalid sentence
		String word = "";

		for (int i = 0; i < len; i++) {

			if (Character.isDigit(s.charAt(i))) {

				while (Character.isDigit(s.charAt(i))) {
					word = word + s.charAt(i);
					i++;
				}
				if (Integer.parseInt(word) < 13) {
					return false;

				}
			}

		}

		System.out.println("Valid sentence");
		return true;
	}
}
