package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    // 첫번째로 만들때는 온전히 구현만 해보고 부족한건 차근차근 더해나갈 생각
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        List<Car> cars = inputCars(sc);
        System.out.println("시도할 횟수는 몇회인가요?");
        int round = sc.nextInt();
        playRound(cars, round);
        showRound(cars);
        showWinnder(cars);
    }

    private static void showWinnder(List<Car> cars) {
        for (Car car : cars) {
            car.getPosition()
        }
    }

    private static void showRound(List<Car> cars) {
        // 차들의 이름과 각 차의 position 만큼 "-" 출력
        for (Car car : cars) {
            System.out.println(car.getName() + " : ");
            int position = car.getPosition();
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        // 문자를 더할때는 StringBuild가 더 좋아보임
    }

    private static void playRound(List<Car> cars, int round) {
        //depth가 2이기때문에 random 값이 4이상인지 판단하는 메서드를 따로 만들어줘야 될 거 같음
        Random random = new Random();
        while (round > 0) {
            round--;
            int random_val = random.nextInt(10);//0부터 9까지 랜덤
                // 여기서 한번 막힘
                for (Car car : cars) {
                    if (random_val >= 4) {
                        car.moveCar();
                        // "-"의 배열 리스트를 하나 만들어줘야 하나?
                    }
                }
            }

        }

    private static List<Car> inputCars(Scanner sc) {
        String name = sc.nextLine();
        String[] names = name.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            //새로운 입력받은 이름으로 car 객체 생성
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
