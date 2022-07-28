package Classes;

import java.util.StringJoiner;

public class Car {
    private String model;
    private String color;
    private int maxSpeed;

    public Car() {
        this.model = "Default first name";
        this.color = "Default last name";
        this.maxSpeed = 0;
    }

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public int improveThisCar(int value) {
        this.maxSpeed += value;
        return maxSpeed;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("Model ='" + model + "'")
                .add("Color ='" + color + "'")
                .add("Max speed = " + maxSpeed)
                .toString();
    }
}
