class Student:
    def __init__(self, id, name, course):
        self.id = id
        self.name = name
        self.course = course

    def __eq__(self, other):
        return self.id == other.id


class StudentTableGateway:
    def __init__(self):
        self.students = []

    def find_all(self):
        return self.students.copy()

    def find(self, id):
        for student in self.students:
            if student.id == id:
                return student
        return None

    def insert(self, student):
        self.students.append(student)

    def update(self, student):
        for index, s in enumerate(self.students):
            if s.id == student.id:
                self.students[index] = student
                break

    def delete(self, id):
        student = self.find(id)
        if student:
            self.students.remove(student)


if __name__ == "__main__":
    gateway = StudentTableGateway()

    alice = Student(1, "Alice", "Computer Science")
    bob = Student(2, "Bob", "Physics")

    gateway.insert(alice)
    gateway.insert(bob)

    for student in gateway.find_all():
        print(student.name)

    alice_updated = Student(1, "Alicia", "Computer Science")
    gateway.update(alice_updated)

    print(gateway.find(1).name)

    gateway.delete(1)

    for student in gateway.find_all():
        print(student.name)