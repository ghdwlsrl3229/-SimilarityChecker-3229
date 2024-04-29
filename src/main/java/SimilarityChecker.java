public class SimilarityChecker {
    public int getLengthScore(String str1, String str2) {
        if (str1.length() == str2.length()) return 60;
        return 0;
    }

    public int getShorterStringLength(String str1, String str2) {
        if (str1.length() < str2.length()) return str1.length();
        return str2.length();
    }

    public int getLongerStringLength(String str1, String str2) {
        if (str1.length() > str2.length()) return str1.length();
        return str2.length();
    }
}
