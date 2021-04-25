package ingjulianvega.ximic.msscasudisabilitytype.exception;

import lombok.Getter;

@Getter
public class DisabilityTypeException extends RuntimeException {

    private final String code;

    public DisabilityTypeException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

