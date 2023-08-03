class Student:
    def __init__(self, id, name, course):
        self.id = id
        self.name = name
        self.course = course

    # Геттеры и сеттеры
    def get_id(self):
        return self.id

    def get_name(self):
        return self.name

    def get_course(self):
        return self.course


class StudentDao:
    def __init__(self):
        self.students = []

    def get_all_students(self):
        return self.students.copy()

    def get_student(self, id):
        for student in self.students:
            if student.get_id() == id:
                return student
        return None

    def insert_student(self, student):
        self.students.append(student)

    def update_student(self, student):
        existing_student = self.get_student(student.get_id())
        if existing_student:
            index = self.students.index(existing_student)
            self.students[index] = student

    def delete_student(self, student):
        self.students = [s for s in self.students if s.get_id() != student.get_id()]


if __name__ == "__main__":
    student_dao = StudentDao()

    student1 = Student(1, "Alice", "Computer Science")
    student2 = Student(2, "Bob", "Physics")

    student_dao.insert_student(student1)
    student_dao.insert_student(student2)

    for student in student_dao.get_all_students():
        print(student.get_name())

    print(student_dao.get_student(1).get_name())

    student_dao.update_student(Student(1, "Alicia", "Computer Science"))
    print(student_dao.get_student(1).get_name())

    student_dao.delete_student(student1)
    for student in student_dao.get_all_students():
        print(student.get_name())

