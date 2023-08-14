package mvp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Модель (Model)
class TaskModel {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}

// Представление (View)
interface TaskView {
    void displayTasks(List<String> tasks);
    String getUserInput();
}

// Презентер (Presenter)
class TaskPresenter {
    private TaskModel model;
    private TaskView view;

    public TaskPresenter(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void onAddTaskButtonClicked() {
        String task = view.getUserInput();
        model.addTask(task);
        updateView();
    }

    private void updateView() {
        List<String> tasks = model.getTasks();
        view.displayTasks(tasks);
    }
}

// Главный класс
class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new ConsoleTaskView();
        TaskPresenter presenter = new TaskPresenter(model, view);

        presenter.onAddTaskButtonClicked();
        presenter.onAddTaskButtonClicked();

        // Результат:
        // Список задач:
        // - Задача 1
        // - Задача 2
    }
}

// Реализация Представления (View)
class ConsoleTaskView implements TaskView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayTasks(List<String> tasks) {
        System.out.println("Список задач:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }

    @Override
    public String getUserInput() {
        System.out.print("Введите новую задачу: ");
        return scanner.nextLine();
    }
}