package hu.innobyte.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.innobyte.checker.CheckerFactory;
import hu.innobyte.checker.checkers.Checker;
import hu.innobyte.checker.checkers.CheckerInitData;
import hu.innobyte.checker.checkers.CheckerType;

public class SentenceInterpreterTest {
    private final String SENTENCE_ONE = "Helló Vanda! Légyszíves mondd meg az egyenlegemet!";
    private final String SENTENCE_TWO = "Helló Vanad Légy szives mondd meg az egyenlegmet!";

    @Test
    public void testBuilder() {
	Checker checker = CheckerFactory.createInstance(CheckerType.Repeater, null);

	SentenceInterpreter testObj = SentenceInterpreter.builder()
							 .maxDistance(0.95f)
							 .checker(checker)
							 .depth(2)
							 .build();

	assertEquals(0.95, testObj.getMaxDistance(), 0.01);
	assertEquals(CheckerType.Repeater, testObj.getChecker().getCheckerType());
	assertEquals(2, testObj.getDepth());
    }

    @Test
    public void testNormalize() {
	Checker checker = CheckerFactory.createInstance(CheckerType.Repeater, CheckerInitData.builder().build());
	SentenceInterpreter testObj = SentenceInterpreter.builder()
							 .maxDistance(0.95f)
							 .checker(checker)
							 .depth(2)
							 .build();

	assertEquals(SENTENCE_ONE, testObj.normalizeSentence(SENTENCE_ONE));
	assertEquals(SENTENCE_TWO, testObj.normalizeSentence(SENTENCE_TWO));

    }
}
