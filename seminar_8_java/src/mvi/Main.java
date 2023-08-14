package mvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MVI Pattern

// --- Model ---

/**
 * Интерфейс Intent представляет намерение или действие, которое должно быть выполнено.
 * В данном контексте это маркерный интерфейс, используемый для группировки различных намерений.
 */
interface Intent {}

/**
 * Интерфейс ViewState представляет состояние представления.
 * Это маркерный интерфейс для определения различных видов состояний.
 */
interface ViewState {}

/**
 * TaskCompletedIntent - намерение отметить задачу как завершенную.
 */
class TaskCompletedIntent implements Intent {
    int taskId;

    public TaskCompletedIntent(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }
}

/**
 * Task - базовая сущность, представляющая задачу.
 */
class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public void complete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return name + (completed ? " (completed)" : "");
    }
}

// --- View ---

/**
 * BaseView - базовый интерфейс для всех видов.
 */
interface BaseView {
    void render(ViewState state);
}

class ConsoleView implements BaseView {

    @Override
    public void render(ViewState state) {
        if (state instanceof TasksViewState) {
            TasksViewState tasksState = (TasksViewState) state;
            System.out.println(tasksState);
        } else {
            System.out.println("Неизвестное состояние.");
        }
    }
}

/**
 * TasksViewState - состояние, которое отображает список задач.
 */
class TasksViewState implements ViewState {
    private final List<Task> tasks;

    public TasksViewState(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Список задач:\n");
        for (int i = 0; i < tasks.size(); i++) {
            builder.append((i + 1)).append(". ").append(tasks.get(i).toString()).append("\n");
        }
        return builder.toString();
    }
}

// --- Presenter ---

/**
 * Presenter связывает Model и View, обрабатывая намерения и обновляя состояние представления.
 */
class TasksPresenter {
    private final List<Task> tasks = new ArrayList<>();
    private final BaseView view;

    public TasksPresenter(BaseView view) {
        this.view = view;
        tasks.add(new Task("Помыть посуду"));
        tasks.add(new Task("Постирать белье"));
    }

    public void dispatch(Intent intent) {
        if (intent instanceof TaskCompletedIntent) {
            int taskId = ((TaskCompletedIntent) intent).getTaskId();
            tasks.get(taskId).complete();
        }
       // view.render(new TasksViewState(tasks));
    }

    public void loadTasks() {
        view.render(new TasksViewState(tasks));
    }
}

// Main class for interaction

class MVIPatternDemo {
    public static void main(String[] args) {
        BaseView view = new ConsoleView();
        TasksPresenter presenter = new TasksPresenter(view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            presenter.loadTasks();
            System.out.println("Введите номер задачи, чтобы отметить ее как завершенную (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int taskId = Integer.parseInt(input) - 1;
                presenter.dispatch(new TaskCompletedIntent(taskId));
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите номер задачи.");
            }
        }
    }
}
