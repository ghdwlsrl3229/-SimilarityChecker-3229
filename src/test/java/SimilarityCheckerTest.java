import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void createSimilarityChecker() {
        SimilarityChecker sc = new SimilarityChecker();
        assertNotNull(sc);
    }

    @Test
    void score60IfSameLength() {
        SimilarityChecker sc = new SimilarityChecker();

        assertEquals(60, sc.getLengthScore("A", "D"));
        assertEquals(60, sc.getLengthScore("AB", "DE"));
        assertEquals(60, sc.getLengthScore("ABCD", "DEDF"));
        assertEquals(60, sc.getLengthScore("ABCAG", "DGEAF"));
    }

    @Test
    void score0IfLengthDiffMoreThan2Times() {
        SimilarityChecker sc = new SimilarityChecker();

        assertEquals(0, sc.getLengthScore("A", "AB"));
        assertEquals(0, sc.getLengthScore("A", "ABC"));
        assertEquals(0, sc.getLengthScore("BA", "ABCD"));
        assertEquals(0, sc.getLengthScore("BA", "ABCDEF"));
        assertEquals(0, sc.getLengthScore("BAC", "ABCDEF"));
    }

    @Test
    void score0IfLengthDiffMoreThan2Times2() {
        SimilarityChecker sc = new SimilarityChecker();

        assertEquals(0, sc.getLengthScore("AB", "A"));
        assertEquals(0, sc.getLengthScore("ABC", "A"));
        assertEquals(0, sc.getLengthScore("ABCD", "BA"));
        assertEquals(0, sc.getLengthScore("ABCDEF", "BA"));
        assertEquals(0, sc.getLengthScore("ABCDEF", "BAC"));
    }
}