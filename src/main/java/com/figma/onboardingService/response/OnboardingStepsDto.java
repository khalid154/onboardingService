package com.figma.onboardingService.response;

import lombok.Data;

/**
 * @author : Khalid Hasan
 */

@Data
public class OnboardingStepsDto {
    private String imageUrl;
    private String description;
    private String heading;
    private String name;
    private int sortOrder;
}
