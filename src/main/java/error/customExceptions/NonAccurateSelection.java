package error.customExceptions;

/**
 * 올바른 선택지가 아닐 경우
 */
public class NonAccurateSelection extends IllegalArgumentException {
    public NonAccurateSelection() {
        super("올바른 선택이 아닙니다. 옵션을 확인해 주세요.");
    }
}
