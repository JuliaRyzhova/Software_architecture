package org.example.soa2;

import java.util.ArrayList;
import java.util.List;

// Класс представляет компонент системы (работника)
public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    // Метод для выполнения работы компонента
    public void doWork() {
        System.out.println(name + " is performing work.");
    }
}

// Класс представляет пул потоков с изолированными работниками
class ThreadPool {
    private List<Worker> workers = new ArrayList<>();     // Список изолированных работников

    // Конструктор, создающий пул из определенного числа работников
    public ThreadPool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            workers.add(new Worker("Worker " + (i + 1)));
        }
    }

    // Метод для выполнения работы с использованием изолированных работников
    public void execute(int workerIndex) {
        if (workerIndex >= 0 && workerIndex < workers.size()) {
            Worker worker = workers.get(workerIndex);
            worker.doWork();
        } else {
            System.out.println("Invalid worker index.");
        }
    }
}

// Класс для запуска примера
class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);

        // Запускаем работников в пуле
        threadPool.execute(0); // Worker 1 is performing work.
        threadPool.execute(1); // Worker 2 is performing work.
        threadPool.execute(2); // Worker 3 is performing work.

        // Попытка запустить несуществующего работника
        threadPool.execute(3); // Invalid worker index.
    }
}