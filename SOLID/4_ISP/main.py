from robot_worker import RobotWorker
from human_worker import HumanWorker

if __name__ == '__main__':
    human = HumanWorker()
    human.work()
    human.eat()

    robot = RobotWorker()
    robot.work()
