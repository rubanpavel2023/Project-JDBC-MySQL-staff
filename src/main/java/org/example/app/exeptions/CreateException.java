package org.example.app.exeptions;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateException extends RuntimeException {
    Map<String, String> errors;

    public CreateException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public String getErrors(Map<String, String> errors) {
        StringBuilder stringBuilder = new StringBuilder();
        errors.forEach((key, value) ->
                stringBuilder.append("\n>> ")
                        .append(key)
                        .append(": ")
                        .append(value)

        );
        return stringBuilder.toString();
    }
}
