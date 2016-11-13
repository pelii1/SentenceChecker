package hu.innobyte.checker.checkers;

public interface Checker {
    public String check(String word);

    public void setDistance(float distance);

    public void init(CheckerInitData checkerInit);

    public CheckerType getCheckerType();
    
    public float checkTwoSentence(String sentenceOne,String sentenceTwo);
}
