package mvpvm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// --- Model ---
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

    public String getName() {
        return name;
    }
}

// --- View ---

interface TaskView {
    void showTasks(List<TaskViewModel> taskViewModels);
}

class ConsoleView implements TaskView {
    @Override
    public void showTasks(List<TaskViewModel> taskViewModels) {
        for (int i = 0; i < taskViewModels.size(); i++) {
            System.out.println((i + 1) + ". " + taskViewModels.get(i).getDisplayName());
        }
    }
}

// --- ViewModel ---

class TaskViewModel {
    private String displayName;

    public TaskViewModel(Task task) {
        this.displayName = task.getName() + (task.isCompleted() ? " (completed)" : "");
    }

    public String getDisplayName() {
        return displayName;
    }
}

// --- Presenter ---

class TaskPresenter {
    private List<Task> tasks = new ArrayList<>();
    private TaskView view;

    public TaskPresenter(TaskView view) {
        this.view = view;
        tasks.add(new Task("Помыть посуду"));
        tasks.add(new Task("Постирать белье"));
    }

    public void displayTasks() {
        List<TaskViewModel> taskViewModels = tasks.stream()
                .map(TaskViewModel::new)
                .collect(Collectors.toList());
        view.showTasks(taskViewModels);
    }

    public void completeTask(int index) {
        tasks.get(index).complete();
      //  displayTasks();
    }
}

// --- Main Interaction ---

class MVPVMPatternDemo {
    public static void main(String[] args) {
        TaskView view = new ConsoleView();
        TaskPresenter presenter = new TaskPresenter(view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            presenter.displayTasks();
            System.out.println("Введите номер задачи, чтобы отметить ее как завершенную (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int taskId = Integer.parseInt(input) - 1;
                presenter.completeTask(taskId);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите номер задачи.");
            }
        }
    }
}