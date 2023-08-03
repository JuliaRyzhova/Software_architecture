import sqlite3

class Student:
    def __init__(self, id, name, course, conn):
        self.id = id
        self.name = name
        self.course = course
        self.conn = conn

    def insert(self):
        sql = "INSERT INTO students (id, name, course) VALUES (?, ?, ?)"
        cur = self.conn.cursor()
        cur.execute(sql, (self.id, self.name, self.course))
        self.conn.commit()

    def update(self):
        sql = "UPDATE students SET name = ?, course = ? WHERE id = ?"
        cur = self.conn.cursor()
        cur.execute(sql, (self.name, self.course, self.id))
        self.conn.commit()

    def delete(self):
        sql = "DELETE FROM students WHERE id = ?"
        cur = self.conn.cursor()
        cur.execute(sql, (self.id,))
        self.conn.commit()

    # Бизнес-логика
    def is_eligible_for_scholarship(self):
        return self.course == "Mathematics" or self.course == "Physics"