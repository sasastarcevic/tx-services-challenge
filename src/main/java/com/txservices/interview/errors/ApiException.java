package com.txservices.interview.errors;

public class ApiException extends RuntimeException {

    private final ErrorType errorType;

    private final String messageParam;

    public ApiException(ErrorType errorType, String messageParam) {
        super(getMessageFromParam(errorType, messageParam));
        this.errorType = errorType;
        this.messageParam = messageParam;
    }

    private static String getMessageFromParam(ErrorType errorType, String messageParam) {
        return String.format(errorType.getMessageErrorTemplate(), messageParam);
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getMessageParam() {
        return messageParam;
    }

    @Override
    public String toString() {
        return "RestApiException{" +
                "errorType=" + errorType +
                ", messageParam='" + messageParam + '\'' +
                "} " + super.toString();
    }

}
