package hu.innobyte.checker.checkers;

public class Repeater implements Checker {

    public String check(String word) {
    	return word;
    }

    public void setDistance(float distance) {
    }

    public void init(CheckerInitData checkerInit) {
    }

    @Override
    public CheckerType getCheckerType() {
    	return CheckerType.Repeater;
    }

	@Override
	public float checkTwoSentence(String sentenceOne, String sentenceTwo) {
		return sentenceOne.equalsIgnoreCase(sentenceTwo) ? 1 : 0;
	}
}
