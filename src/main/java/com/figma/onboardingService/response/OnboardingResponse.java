package com.figma.onboardingService.response;

import lombok.Data;

/**
 * @author : Khalid Hasan
 */

@Data
public class OnboardingResponse {
    private int statusCode;
    private OnboardingData data;
}
