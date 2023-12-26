package org.avtor31;

import lombok.SneakyThrows;

import java.util.concurrent.*;

class CodeService {
    @SneakyThrows
    public static boolean executeCodeTask() {
        Thread.sleep(3000L);
        System.out.println("Код подобран");
        return true;
    }
}

class VinService {
    @SneakyThrows
    public static boolean executeVinTask() {
        Thread.sleep(3000L);
        System.out.println("VIN-номер подобран");
        return true;
    }
}

class FinalTask {
    public static void executeFinalTask() {
        // Здесь реализация финальной задачи
        System.out.println("Финальная задача выполнена!");
    }
}

public class FutureStyleApp {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Boolean> codeTaskFuture = executor.submit(CodeService::executeCodeTask);
            Future<Boolean> vinTaskFuture = executor.submit(VinService::executeVinTask);

            boolean codeTaskResult = codeTaskFuture.get();
            boolean vinTaskResult = vinTaskFuture.get();

            if (codeTaskResult && vinTaskResult) {
                FinalTask.executeFinalTask();
            } else {
                throw new RuntimeException("Не удалось выполнить одну из первых задач");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
