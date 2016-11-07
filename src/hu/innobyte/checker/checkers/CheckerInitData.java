package hu.innobyte.checker.checkers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CheckerInitData {
    private String filePath;
}
