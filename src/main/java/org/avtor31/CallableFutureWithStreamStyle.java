package org.avtor31;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CallableFutureCodeService {

    public static CompletableFuture<Boolean> executeCodeTask() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Код подобран");
            return true;
        });
    }
}

class CallableFutureVinService {
    public static CompletableFuture<Boolean> executeVinTask() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("VIN-номер подобран");
            return true;
        });
    }
}

class CallableFutureFinalTask {
    @SneakyThrows
    public static void executeFinalTask() {
        Thread.sleep(3000L);
        System.out.println("Финальная задача выполнена!");
    }
}

public class CallableFutureWithStreamStyle {
    public static void main(String[] args) {
        List<CompletableFuture<Boolean>> tasks = Stream.of(
                CallableFutureCodeService.executeCodeTask(),
                CallableFutureVinService.executeVinTask()
        ).collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));

        try {
            allOf.thenRun(() -> {
                boolean allTasksSuccessful = tasks.stream()
                        .allMatch(CompletableFuture::join);

                if (allTasksSuccessful) {
                    CallableFutureFinalTask.executeFinalTask();
                } else {
                    throw new RuntimeException("Не удалось выполнить одну из первых задач");
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}