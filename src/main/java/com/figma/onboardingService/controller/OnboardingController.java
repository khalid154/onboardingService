package com.figma.onboardingService.controller;

import com.figma.onboardingService.response.OnboardingResponse;
import com.figma.onboardingService.service.IOnboardingService;
import com.figma.onboardingService.util.CompletableFutures;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/onboarding")
public class OnboardingController {

    private IOnboardingService onboardingService;

    @Autowired
    public OnboardingController(IOnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @GetMapping(value = "/data")
    @ApiOperation(value = "this is an api to get static on boarding data", response = OnboardingResponse.class)
    public CompletionStage<OnboardingResponse> getOnboardingData(@RequestParam(name = "ln", defaultValue = "1")
                                                                 int languageId) {
        log.info("request received at onboarding controller with language Id = " + languageId);
        return onboardingService.getOnboardingData(languageId)
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.warn("exception while fetching onboarding data", throwable);
                    log.info(unwrappedException.getMessage());
                    return OnboardingResponse.builder()
                            .statusCode(500)
                            .build();
                });
    }
}
