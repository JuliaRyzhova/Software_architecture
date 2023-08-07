from user_exception import UserNotFoundException
from user_repository import UserRepository
from user import User

if __name__ == '__main__':
    """Точка входа в приложение. Рабоатем через класс UserRepository"""
    userrepository = UserRepository()
    userrepository.save_user(User(1, "John Snow"))
    userrepository.save_user(User(2, "Edward Stark"))

    try:
        user = userrepository.find_by_id(1)
        print(user.get_name())
    except UserNotFoundException as e:
        print(e)

    userrepository.delete_user(user)

    try:
        user = userrepository.find_by_id(2)
        print(user.get_name())
    except UserNotFoundException as e:
        print(e)

    foundusers = userrepository.find_by_name("John Snow")

    for user in foundusers:
        print(user.get_name())

    users = userrepository.find_all()
    for user in users:
        print(user.get_name())