package ribs_2;

// Screen
class ProfileScreen {
    public void display(String userName, int userAge) {
        System.out.println("Имя: " + userName + ", Возраст: " + userAge);
    }

    public void displayFriendsList(String[] friends) {
        System.out.println("Список друзей:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}

// Interactor
class ProfileInteractor {
    private final UserData userData;

    public ProfileInteractor(UserData userData) {
        this.userData = userData;
    }

    public String getUserName() {
        return userData.getName();
    }

    public int getUserAge() {
        return userData.getAge();
    }

    public String[] getFriendsList() {
        return userData.getFriends();
    }
}

class UserData {
    private final String name;
    private final int age;
    private final String[] friends;

    public UserData(String name, int age, String[] friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String[] getFriends() { return friends; }
}

// Router
class ProfileRouter {
    public void goToHomeScreen() {
        System.out.println("Переход на главный экран...");
    }

    public void logout() {
        System.out.println("Выход из профиля...");
    }
}

// Builder
class ProfileBuilder {
    public static ProfileComponent build(UserData userData) {
        ProfileScreen screen = new ProfileScreen();
        ProfileInteractor interactor = new ProfileInteractor(userData);
        ProfileRouter router = new ProfileRouter();
        return new ProfileComponent(screen, interactor, router);
    }
}

class ProfileComponent {
    public final ProfileScreen screen;
    public final ProfileInteractor interactor;
    public final ProfileRouter router;

    public ProfileComponent(ProfileScreen screen, ProfileInteractor interactor, ProfileRouter router) {
        this.screen = screen;
        this.interactor = interactor;
        this.router = router;
    }
}


// ... (ваш код для Screen, Interactor, UserData, Router, Builder)

// Main
public class Main {
    public static void main(String[] args) {
        UserData userData = new UserData("John Doe", 30, new String[]{"Alice", "Bob", "Charlie"});
        ProfileComponent profileComponent = ProfileBuilder.build(userData);

        // Создаем экран профиля
        ProfileScreen screen = profileComponent.screen;

        // Отображаем информацию о пользователе
        String userName = profileComponent.interactor.getUserName();
        int userAge = profileComponent.interactor.getUserAge();
        screen.display(userName, userAge);

        // Отображаем список друзей
        String[] friends = profileComponent.interactor.getFriendsList();
        screen.displayFriendsList(friends);

        // Выполняем навигацию и действия
        profileComponent.router.goToHomeScreen();
        profileComponent.router.logout();
    }
}