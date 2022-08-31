package com.figma.onboardingService.response;

import lombok.Data;

import java.util.List;

/**
 * @author : Khalid Hasan
 */

@Data
public class OnboardingData {
    private List<OnboardingStepsDto> onBoardingSteps;
}
