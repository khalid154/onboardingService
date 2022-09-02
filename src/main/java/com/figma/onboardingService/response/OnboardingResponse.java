package com.figma.onboardingService.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Khalid Hasan
 */

@Data
@Builder
public class OnboardingResponse {
    private int statusCode;
    private OnboardingData data;
}
