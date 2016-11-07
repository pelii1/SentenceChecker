package hu.innobyte.util;

public class SentenceOperations {
	public static String deleteSpace(String sentence) {
		String result = "";
		boolean isWhiteSpace = false;
		
		for(int position = 0;position < sentence.length();position++) {
			if (Character.isWhitespace(sentence.charAt(position))) {
				if (!isWhiteSpace) {
					result += sentence.charAt(position);
				}
				isWhiteSpace = true;
			} else {
				result += sentence.charAt(position);
				isWhiteSpace = false;
			}
		}
		
		return result;
	}
}
