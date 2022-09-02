package com.figma.onboardingService.service;

import com.figma.onboardingService.constants.StatusCode;
import com.figma.onboardingService.model.OnboardingSteps;
import com.figma.onboardingService.response.OnboardingData;
import com.figma.onboardingService.response.OnboardingResponse;
import com.figma.onboardingService.response.OnboardingStepsDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Khalid Hasan
 */
public class ConversionService {

    public static OnboardingResponse getOnboardingResponseFromOnboardingSteps(List<OnboardingSteps> onboardingSteps) {
        List<OnboardingStepsDto> onboardingStepsDtos = onboardingSteps.stream()
                .map(step -> getOnboardingStepsDto(step)).collect(Collectors.toList());
        OnboardingData onboardingData = new OnboardingData();
        onboardingData.setOnBoardingSteps(onboardingStepsDtos);
        OnboardingResponse onboardingResponse = OnboardingResponse.builder()
                .data(onboardingData)
                .statusCode(StatusCode.SUCCESS.code)
                .build();
        return onboardingResponse;
    }

    private static OnboardingStepsDto getOnboardingStepsDto(OnboardingSteps onboardingSteps) {
        OnboardingStepsDto onboardingStepsDto = new OnboardingStepsDto();
        onboardingStepsDto.setImageUrl(onboardingSteps.getImageUrl());
        onboardingStepsDto.setDescription(onboardingSteps.getDescription());
        onboardingStepsDto.setHeading(onboardingSteps.getHeader());
        onboardingStepsDto.setName(onboardingSteps.getName());
        onboardingStepsDto.setSortOrder(onboardingSteps.getSortOrder());
        return onboardingStepsDto;
    }
}
