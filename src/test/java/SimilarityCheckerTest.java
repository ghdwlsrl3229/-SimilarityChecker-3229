import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void SameAlphaTest() {
        SimilarityChecker sc = new SimilarityChecker();
        assertEquals(40, sc.getAlphaScore("ABCD", "ABCD"));
        assertEquals(40, sc.getAlphaScore("ABCD", "DBACAA"));
        assertEquals(40, sc.getAlphaScore("A", "AAA"));
        assertEquals(40, sc.getAlphaScore("CBA", "ABC"));
    }

    @Test
    void AllDifferentAlphaTest() {
        SimilarityChecker sc = new SimilarityChecker();
        boolean[] actual = sc.getAlphaExistList("AGEF");
        boolean[] expected = new boolean[26];
        expected['A' - 'A'] =  true;
        expected['G' - 'A'] =  true;
        expected['E' - 'A'] =  true;
        expected['F' - 'A'] =  true;

        assertArrayEquals(expected, actual);
    }

    @Test
    void getTotalCountTest() {
        SimilarityChecker sc = new SimilarityChecker();
        assertEquals(6, sc.getTotalCount("ABC", "DEF"));
        assertEquals(8, sc.getTotalCount("ABCDE", "DEFGH"));
        assertEquals(4, sc.getTotalCount("ABCD", "ABC"));
    }

    @Test
    void getSameCountTest() {
        SimilarityChecker sc = new SimilarityChecker();
        assertEquals(0, sc.getSameCount("ABC", "DEF"));
        assertEquals(2, sc.getSameCount("ABCDE", "DEF"));
        assertEquals(3, sc.getSameCount("ABC", "ABC"));

    }
}