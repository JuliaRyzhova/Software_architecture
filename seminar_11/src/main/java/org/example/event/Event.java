package org.example.event;

// Класс, представляющий событие
public class Event {
    private final String eventType;     // Тип события (например, "DEPOSIT" или "WITHDRAW")
    private final String eventData;     // Данные события (например, сумма операции)

    public Event(String eventType, String eventData) {
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventData() {
        return eventData;
    }
}

// Класс, представляющий хранилище событий
public class EventStore {
    private List<Event> events = new ArrayList<>();     // Список событий

    // Метод для добавления события в хранилище
    public void addEvent(Event event) {
        events.add(event);
    }

    // Метод для получения списка всех событий
    public List<Event> getEvents() {
        return events;
    }
}

// Класс, представляющий банковский счет
public class BankAccount {
    private int balance = 0;                  // Баланс счета
    private EventStore eventStore;            // Хранилище событий

    public BankAccount(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    // Метод для внесения денег на счет
    public void deposit(int amount) {
        if (amount > 0) {
            Event depositEvent = new Event("DEPOSIT", String.valueOf(amount));
            eventStore.addEvent(depositEvent);
            balance += amount;
        }
    }

    // Метод для снятия денег со счета
    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            Event withdrawEvent = new Event("WITHDRAW", String.valueOf(amount));
            eventStore.addEvent(withdrawEvent);
            balance -= amount;
        }
    }

    // Метод для получения текущего баланса
    public int getBalance() {
        return balance;
    }
}

// Класс для запуска примера
public class Main {
    public static void main(String[] args) {
        EventStore eventStore = new EventStore();
        BankAccount bankAccount = new BankAccount(eventStore);

        // Выполняем операции счета
        bankAccount.deposit(100);
        bankAccount.withdraw(50);

        // Получаем список событий и восстанавливаем состояние
        List<Event> events = eventStore.getEvents();
        BankAccount restoredAccount = new BankAccount(eventStore);
        for (Event event : events) {
            if ("DEPOSIT".equals(event.getEventType())) {
                int amount = Integer.parseInt(event.getEventData());
                restoredAccount.deposit(amount);
            } else if ("WITHDRAW".equals(event.getEventType())) {
                int amount = Integer.parseInt(event.getEventData());
                restoredAccount.withdraw(amount);
            }
        }

        System.out.println("Original Balance: " + bankAccount.getBalance());
        System.out.println("Restored Balance: " + restoredAccount.getBalance());
    }
}