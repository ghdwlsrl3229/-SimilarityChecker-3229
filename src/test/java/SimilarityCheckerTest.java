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
}