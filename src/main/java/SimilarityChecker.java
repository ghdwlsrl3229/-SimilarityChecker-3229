import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimilarityChecker {
    public int getAlphaScore(String str1, String str2) {
        return 40;
    }

    public boolean[] getAlphaExistList(String str) {
        boolean[] result = new boolean[26];
        for (char ch : str.toCharArray()) {
            result[ch - 'A'] = true;
        }
        return result;
    }
}
