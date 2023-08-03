class User:
    def __init__(self, id, name):
        self.id = id
        self.name = name

class UserDao:
    def __init__(self):
        self.users = []

    def get_all_users(self):
        return self.users.copy()

    def get_user(self, id):
        for user in self.users:
            if user.id == id:
                return user
        return None

    def add_user(self, user):
        self.users.append(user)

    def update_user(self, user):
        for index, existing_user in enumerate(self.users):
            if existing_user.id == user.id:
                self.users[index] = user

    def delete_user(self, user):
        self.users = [existing_user for existing_user in self.users if existing_user.id != user.id]

if __name__ == "__main__":
    user_dao = UserDao()

    user1 = User(1, "Alice")
    user2 = User(2, "Bob")

    user_dao.add_user(user1)
    user_dao.add_user(user2)

    for user in user_dao.get_all_users():
        print(user.name)

    user = user_dao.get_user(1)
    if user:
        print(user.name)

    user_dao.update_user(User(1, "Alicia"))

    user = user_dao.get_user(1)
    if user:
        print(user.name)

    user_dao.delete_user(user1)
    for user in user_dao.get_all_users():
        print(user.name)