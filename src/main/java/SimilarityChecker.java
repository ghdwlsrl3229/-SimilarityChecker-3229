public class SimilarityChecker {
    public int getLengthScore(String str1, String str2) {
        if (isSameLength(str1, str2)) return 60;
        if (is2TimesOverLengthDiff(str1, str2)) return 0;
        return getPartialScore(str1, str2);
    }

    private int getPartialScore(String str1, String str2) {
        int shortLength = getShorterStringLength(str1, str2);
        int longLength = getLongerStringLength(str1, str2);
        int gap = longLength - shortLength;
        return (int)((1 - 1.0 * gap / shortLength) * 60);
    }

    private boolean is2TimesOverLengthDiff(String str1, String str2) {
        int shortLength = getShorterStringLength(str1, str2);
        int longLength = getLongerStringLength(str1, str2);
        return shortLength * 2 < longLength;
    }

    private boolean isSameLength(String str1, String str2) {
        return str1.length() == str2.length();
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
