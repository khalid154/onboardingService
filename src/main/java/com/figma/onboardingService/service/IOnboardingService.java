package com.figma.onboardingService.service;

import com.figma.onboardingService.response.OnboardingResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */
@Service
public interface IOnboardingService {
    CompletionStage<OnboardingResponse> getOnboardingData(int languageId);
}
