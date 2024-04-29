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
}