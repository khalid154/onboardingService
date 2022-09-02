package com.figma.onboardingService.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : Khalid Hasan
 */
@Getter
public class OnboardingException extends RuntimeException {
    private final HttpStatus status;

    public OnboardingException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public OnboardingException(String message) {
        super(message);
        status = org.springframework.http.HttpStatus.BAD_REQUEST;
    }
}
