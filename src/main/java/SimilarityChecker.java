public class SimilarityChecker {
    public int getLengthScore(String str1, String str2) {
        if (str1.length() == str2.length()) return 60;
        int shortLength = getShorterStringLength(str1, str2);
        int longLength = getLongerStringLength(str1, str2);
        if (shortLength * 2 < longLength) return 0;
        int gap = longLength - shortLength;
        return 60 * (shortLength - gap) / shortLength;
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
