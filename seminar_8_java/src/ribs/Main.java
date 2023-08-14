package ribs;

class ProfileScreen {
    // Отображение основной информации пользователя
    public void display(String userName, int userAge) {
        System.out.println("Имя: " + userName + ", Возраст: " + userAge);
    }

    // Отображение списка друзей
    public void displayFriendsList(String[] friends) {
        System.out.println("Список друзей:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}
// 2. Interactor (бизнес-логика):

        // Этот компонент содержит бизнес-логику приложения. Он обрабатывает данные и взаимодействует с другими службами или базой данных.

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

    // Геттеры для получения информации о пользователе
    public String getName() { return name; }
    public int getAge() { return age; }
    public String[] getFriends() { return friends; }
}
// 3. Router (навигация):

        // Router управляет переходами между экранами. Он может взаимодействовать с навигационной системой приложения,
        // чтобы показать новый экран или вернуться назад.


class ProfileRouter {
    // Переход на главный экран
    public void goToHomeScreen() {
        System.out.println("Переход на главный экран...");
    }

    // Выход из профиля
    public void logout() {
        System.out.println("Выход из профиля...");
    }
}
//4. Builder (создание компонентов):

        //Builder ответственен за создание и связывание всех компонентов RIBs. Он инкапсулирует процесс создания
        // экземпляров и инъекции зависимостей.


class ProfileBuilder {
    // Создание компонентов и их связывание
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
