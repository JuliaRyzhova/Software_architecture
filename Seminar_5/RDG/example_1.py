class User:
    def __init__(self, id, name, email, db_connection):
        self.id = id
        self.name = name
        self.email = email
        self.db_connection = db_connection

    # Python автоматически создает геттеры и сеттеры для вас.
    # Если вы хотите управлять доступом к переменной, вы можете использовать декораторы @property и @<var>.setter

    def insert(self):
        # Используйте db_connection для вставки этой строки в базу данных
        pass

    def update(self):
        # Используйте db_connection для обновления этой строки в базе данных
        pass

    def delete(self):
        # Используйте db_connection для удаления этой строки из базы данных
        pass