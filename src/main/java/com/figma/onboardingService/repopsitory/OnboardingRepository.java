package com.figma.onboardingService.repopsitory;

import com.figma.onboardingService.model.OnboardingSteps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Khalid Hasan
 */
@Repository
public interface OnboardingRepository extends CrudRepository<OnboardingSteps, Long> {
    List<OnboardingSteps> findByLanguageId(int languageId);
}
