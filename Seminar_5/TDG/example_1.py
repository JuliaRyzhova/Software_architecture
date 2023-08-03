import sqlite3

class StudentTableGateway:
    def __init__(self, conn):
        self.conn = conn

    def findAll(self):
        sql = "SELECT * FROM students"
        cur = self.conn.cursor()
        cur.execute(sql)
        return cur.fetchall()

    def insert(self, id, name, course):
        sql = "INSERT INTO students (id, name, course) VALUES (?, ?, ?)"
        cur = self.conn.cursor()
        cur.execute(sql, (id, name, course))
        self.conn.commit()

    def update(self, id, name, course):
        sql = "UPDATE students SET name = ?, course = ? WHERE id = ?"
        cur = self.conn.cursor()
        cur.execute(sql, (name, course, id))
        self.conn.commit()

    def delete(self, id):
        sql = "DELETE FROM students WHERE id = ?"
        cur = self.conn.cursor()
        cur.execute(sql, (id,))
        self.conn.commit()