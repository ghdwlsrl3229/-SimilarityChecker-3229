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

    public int getTotalCount(String str1, String str2) {
        boolean[] AlphaExistList1 = getAlphaExistList(str1);
        boolean[] AlphaExistList2 = getAlphaExistList(str2);

        int result = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (AlphaExistList1[ch - 'A'] || AlphaExistList2[ch - 'A']) result++;
        }
        return result;
    }
}
