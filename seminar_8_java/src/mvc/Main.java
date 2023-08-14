package mvc;

import java.util.ArrayList;
import java.util.List;

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
class TaskView {
    public void displayTasks(List<String> tasks) {
        System.out.println("Список задач:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
}

// Контроллер (Controller)
class TaskController {
    private TaskModel model;
    private TaskView view;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void addTask(String task) {
        model.addTask(task);
        updateView();
    }

    private void updateView() {
        List<String> tasks = model.getTasks();
        view.displayTasks(tasks);
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        controller.addTask("Подготовить презентацию");
        controller.addTask("Закончить проект");
        controller.addTask("Сделать покупки");

        // Результат:
        // Список задач:
        // - Подготовить презентацию
        // - Закончить проект
        // - Сделать покупки
    }
}