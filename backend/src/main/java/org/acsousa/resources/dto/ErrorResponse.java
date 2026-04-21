package org.acsousa.resources.dto;

public class ErrorResponse {

    public String error;

    public String message;

    private final long timestamp;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
