import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    SimilarityChecker sc;

    @BeforeEach
    void setUp() {
        sc = new SimilarityChecker();
    }

    @Test
    void createSimilarityChecker() {
        assertNotNull(sc);
    }

    @Test
    void score60IfSameLength() {
        assertEquals(60, sc.getLengthScore("A", "D"));
        assertEquals(60, sc.getLengthScore("AB", "DE"));
        assertEquals(60, sc.getLengthScore("ABCD", "DEDF"));
        assertEquals(60, sc.getLengthScore("ABCAG", "DGEAF"));
    }

    @Test
    void score0IfLengthDiffMoreThan2Times() {
        assertEquals(0, sc.getLengthScore("A", "AB"));
        assertEquals(0, sc.getLengthScore("A", "ABC"));
        assertEquals(0, sc.getLengthScore("BA", "ABCD"));
        assertEquals(0, sc.getLengthScore("BA", "ABCDEF"));
        assertEquals(0, sc.getLengthScore("BAC", "ABCDEF"));
    }

    @Test
    void score0IfLengthDiffMoreThan2Times2() {
        assertEquals(0, sc.getLengthScore("AB", "A"));
        assertEquals(0, sc.getLengthScore("ABC", "A"));
        assertEquals(0, sc.getLengthScore("ABCD", "BA"));
        assertEquals(0, sc.getLengthScore("ABCDEF", "BA"));
        assertEquals(0, sc.getLengthScore("ABCDEF", "BAC"));
    }

    @Test
    void getShorterStringLength() {
        assertEquals(3, sc.getShorterStringLength("ABCDE", "ABC"));
        assertEquals(1, sc.getShorterStringLength("A", "ABC"));
        assertEquals(2, sc.getShorterStringLength("ABCDE", "BC"));
        assertEquals(3, sc.getShorterStringLength("ABCDEW", "ABC"));
        assertEquals(2, sc.getShorterStringLength("AC", "AB"));
    }

    @Test
    void getLongerStringLength() {
        assertEquals(5, sc.getLongerStringLength("ABCDE", "ABC"));
        assertEquals(3, sc.getLongerStringLength("A", "ABC"));
        assertEquals(5, sc.getLongerStringLength("ABCDE", "BC"));
        assertEquals(6, sc.getLongerStringLength("ABCDEW", "ABC"));
        assertEquals(2, sc.getLongerStringLength("AC", "AB"));
    }

    @Test
    void partialScoreTest() {
        assertEquals(30, sc.getLengthScore("ABC", "AB"));
        assertEquals(40, sc.getLengthScore("ABCD", "CAB"));
        assertEquals(20, sc.getLengthScore("ABCDE", "CAB"));
        assertEquals(45, sc.getLengthScore("ABCDE", "CABD"));
        assertEquals(48, sc.getLengthScore("ABCDEB", "CABDE"));
    }
}