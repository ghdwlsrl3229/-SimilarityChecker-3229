import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimilarityChecker {
    public int getAlphaScore(String str1, String str2) {
        int TotalCnt = getTotalCount(str1, str2);
        int SameCnt = getSameCount(str1, str2);
        return SameCnt * 40 / TotalCnt;
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

    public int getSameCount(String str1, String str2) {
        boolean[] AlphaExistList1 = getAlphaExistList(str1);
        boolean[] AlphaExistList2 = getAlphaExistList(str2);

        int result = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (AlphaExistList1[ch - 'A'] && AlphaExistList2[ch - 'A']) result++;
        }
        return result;
    }
}
