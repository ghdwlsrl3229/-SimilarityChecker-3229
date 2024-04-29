public class SimilarityChecker {
    public int getLengthScore(String str1, String str2) {
        if (isSameLength(str1, str2)) return 60;
        if (is2TimesOverLengthDiff(str1, str2)) return 0;
        return getPartialScore(str1, str2);
    }

    private int getPartialScore(String str1, String str2) {
        int shortLength = Math.min(str1.length(), str2.length());
        int longLength = Math.max(str1.length(), str2.length());
        int gap = longLength - shortLength;
        return (int)((1 - 1.0 * gap / shortLength) * 60);
    }

    private boolean is2TimesOverLengthDiff(String str1, String str2) {
        int shortLength = Math.min(str1.length(), str2.length());
        int longLength = Math.max(str1.length(), str2.length());
        return shortLength * 2 < longLength;
    }

    private boolean isSameLength(String str1, String str2) {
        return str1.length() == str2.length();
    }

}
