import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {// 3 машины

            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.next();

            int speed = 0; //скорость
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");

                if (scanner.hasNextInt()) {// проверка целого числа
                    speed = scanner.nextInt();

                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость. Введите значение от 1 до 250.");
                    }
                } else {
                    System.out.println("Неправильная скорость. Введите целое число.");
                    scanner.next();
                }
            }
            Car car = new Car(name, speed);//автомобиль
            race.checkLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.leaderName);//победитель

        scanner.close();
    }
}

class Car {//класс авто
    String name;
    int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {//класс гонка
    String leaderName = "";
    int leaderDistance = 0;

    public void checkLeader(Car car) {
        int distance = car.speed * 24;
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.name;
        }
    }
}