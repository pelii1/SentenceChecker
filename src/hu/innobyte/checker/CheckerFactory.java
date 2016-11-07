package hu.innobyte.checker;

import hu.innobyte.checker.checkers.Checker;
import hu.innobyte.checker.checkers.CheckerInitData;
import hu.innobyte.checker.checkers.CheckerType;

public class CheckerFactory {
    public static Checker createInstance(CheckerType checkerType, CheckerInitData checkerInitData) {
	Checker checker = checkerType.getChecker();
	checker.init(checkerInitData);

	return checker;
    }
}
