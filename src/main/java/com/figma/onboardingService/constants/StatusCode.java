package com.figma.onboardingService.constants;

import lombok.Data;

/**
 * @author : Khalid Hasan
 */

public enum StatusCode {

    SUCCESS("success", 200),
    NOT_FOUND("not found", 404),

    INTERNAL_SERVER_ERROR("failed", 500);

    public String name;
    public int code;

    StatusCode(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
