package com.figma.onboardingService.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * @author : Khalid Hasan
 */
public class CompletableFutures {
    public CompletableFutures() {
    }

    public static Throwable unwrapCompletionStageException(Throwable throwable) {
        return unwrapCompletionStageException(throwable, 30);
    }

    public static Throwable unwrapCompletionStageException(Throwable throwable, int maxDepth) {
        if (maxDepth <= 0) {
            maxDepth = 2;
        }
        while (isCompletionException(throwable) && maxDepth-- > 0) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

    private static boolean isCompletionException(Throwable throwable) {
        return throwable != null && CompletionException.class.isAssignableFrom(throwable.getClass());
    }
}
