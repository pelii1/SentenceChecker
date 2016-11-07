package hu.innobyte.checker.checkers;

import hu.innobyte.interpreter.MissingClassException;

public enum CheckerType {
    Repeater {
	public Checker getChecker() {
	    return new Repeater();
	}
    },
    StringComparator {
	public Checker getChecker() {
	    return new StringCompare();
	}
    },
    DYM;

    public Checker getChecker() {
	throw new MissingClassException();
    }
}
