package easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SortCarsByCode {
    public static void main(String args[]){
        List<Car> cars =
                Stream.of(new Car(12, "Audi"),
                        new Car(6, "BMW"),
                        new Car(18, "Renault"),
                        new Car(15, "Suzuki")).collect(Collectors.toList());

        cars.stream()
                .sorted(Comparator.comparingInt(Car::getCod).reversed())
                .forEach(System.out::println);
    }
}

class Car {

    public Car(Integer cod, String brand) {
        this.cod = cod;
        this.brand = brand;
    }

    private Integer cod;
    private String brand;

    public Integer getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cod=" + cod +
                ", brand='" + brand + '\'' +
                '}';
    }
}
