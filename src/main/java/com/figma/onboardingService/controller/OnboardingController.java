package com.figma.onboardingService.controller;

import com.figma.onboardingService.constants.StatusCode;
import com.figma.onboardingService.response.OnboardingResponse;
import com.figma.onboardingService.service.IOnboardingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("onboarding")
public class OnboardingController {

    private IOnboardingService onboardingService;

    @Autowired
    public OnboardingController(IOnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @GetMapping(value = "/data")
    public CompletionStage<ResponseEntity<OnboardingResponse>> getOnboardingData(@RequestParam(name = "ln", defaultValue = "1")
                                                                                 int languageId) {
        log.info("request received at onboarding controller with language Id = " + languageId);
        return onboardingService.getOnboardingData(languageId).thenApply(res -> {
            return ResponseEntity.ok().body(res);
        }).exceptionally(ex -> {
            log.warn("exception while fetching onboarding data", ex);
            OnboardingResponse onboardingResponse = new OnboardingResponse();
            onboardingResponse.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR.code);
            return ResponseEntity.internalServerError().body(onboardingResponse);
        });
    }
}
