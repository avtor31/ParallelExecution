package org.avtor31;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class ReactorCodeService {
    public static Mono<Boolean> executeCodeTask() {
        return Mono.fromCallable(() -> {
            Thread.sleep(3000L);
            System.out.println("Код подобран");
            return true;
        });
    }
}

class ReactorVinService {
    public static Mono<Boolean> executeVinTask(boolean someParameter) {
        return Mono.fromCallable(() -> {
            Thread.sleep(3000L);
            System.out.println("VIN-номер подобран");
            return true;
        });
    }
}

class ReactorFinalTask {
    public static void executeFinalTask() throws InterruptedException {
        Thread.sleep(3000L);
        System.out.println("Финальная задача выполнена!");
    }
}

public class ReactorStyle {
    public static void main(String[] args) {
        boolean someParameter = true;

        Flux<Boolean> tasks = Flux.merge(
                ReactorCodeService.executeCodeTask(),
                ReactorVinService.executeVinTask(someParameter)
        );

        tasks.collectList().subscribe(results -> {
            boolean allTasksSuccessful = results.stream().allMatch(Boolean::booleanValue);

            if (allTasksSuccessful) {
                try {
                    ReactorFinalTask.executeFinalTask();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException("Не удалось выполнить одну из первых задач");
            }
        });
    }
}
