package hu.innobyte.checker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.innobyte.checker.checkers.Checker;
import hu.innobyte.checker.checkers.CheckerInitData;
import hu.innobyte.checker.checkers.CheckerType;
import hu.innobyte.interpreter.SentenceInterpreter;

public class StringCompareTest {
    private final String SENTENCE_TWO = "Helló Vanad! Legyél szives mondd meg az egyenlegmet!";
    private final String SENTENCE_OK = "Helló Vanda! Legyél szíves mondd meg az egyenlegemet!";

    @Test
    public void test() {
	Checker checker = CheckerFactory.createInstance(CheckerType.StringComparator, CheckerInitData.builder().build());
	SentenceInterpreter testObj = SentenceInterpreter.builder()
							 .maxDistance(0.9f)
							 .checker(checker)
							 .depth(2)
							 .build();
	// testObj.get

	assertEquals(testObj.normalizeSentence(SENTENCE_TWO), SENTENCE_OK);
    }
}
