package dzLesson1;

import dzLesson1.fruit.Fruit;
import dzLesson1.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> conteiner;

    public Box() {
        this.conteiner = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.conteiner = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : conteiner) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public void transfer (Box<? super T> another){
        if (another == this){
            return;
        }
        another.conteiner.addAll(this.conteiner);
        this.conteiner.clear();
    }

    public void addFruit (T fruit) {
        conteiner.add(fruit);
    }
}
