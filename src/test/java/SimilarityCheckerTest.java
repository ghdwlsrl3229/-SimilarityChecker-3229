import org.junit.jupiter.api.Test;

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
}