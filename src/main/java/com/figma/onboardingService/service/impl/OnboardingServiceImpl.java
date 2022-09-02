package com.figma.onboardingService.service.impl;

import com.figma.onboardingService.constants.StatusCode;
import com.figma.onboardingService.exception.OnboardingException;
import com.figma.onboardingService.repopsitory.OnboardingRepository;
import com.figma.onboardingService.response.OnboardingResponse;
import com.figma.onboardingService.service.ConversionService;
import com.figma.onboardingService.service.IOnboardingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        log.info("getting on boarding data with languageId = " + languageId);
        return CompletableFuture.supplyAsync(() -> {
            return onboardingRepository.findByLanguageId(languageId);
        }).thenApply(res -> {
            if (res.size() == 0) {
                log.info("no boarding data found for language Id = " + languageId);
                throw new OnboardingException("no boarding data found for given language Id", HttpStatus.NOT_FOUND);
            }
            return ConversionService.getOnboardingResponseFromOnboardingSteps(res);
        });
    }
}
