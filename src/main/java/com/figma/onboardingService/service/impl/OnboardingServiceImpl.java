package com.figma.onboardingService.service.impl;

import com.figma.onboardingService.repopsitory.OnboardingRepository;
import com.figma.onboardingService.response.OnboardingResponse;
import com.figma.onboardingService.service.ConversionService;
import com.figma.onboardingService.service.IOnboardingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */

@Service
@Log4j2
public class OnboardingServiceImpl implements IOnboardingService {

    private OnboardingRepository onboardingRepository;

    @Autowired
    public OnboardingServiceImpl(OnboardingRepository onboardingRepository) {
        this.onboardingRepository = onboardingRepository;
    }

    @Override
    public CompletionStage<OnboardingResponse> getOnboardingData(int languageId) {
        log.info("in onboarding Service with languageId = " + languageId);
        return CompletableFuture.supplyAsync(() -> {
            return onboardingRepository.findByLanguageId(languageId);
        }).thenApply(res -> {
            return ConversionService.getOnboardingResponseFromOnboardingSteps(res);
        });
    }
}
