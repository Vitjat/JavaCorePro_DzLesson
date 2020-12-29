package dzLesson1;

import dzLesson1.fruit.Apple;
import dzLesson1.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"5", "7", "element3"}; //1 задание
        swap(arr, 0, 2);

        Integer[] intArr = new Integer[3]; //2 задание
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;
        ArrayList<Integer> arrList = arrayList(intArr);
        System.out.println("Массив ArrayList - " + arrayList(intArr));


        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<Orange>(orange1, orange2);

        System.out.println(Box.compare(box2));

    }

    /** 1 задание*/
    public static void swap(String[] arr, int n, int n1) {
        System.out.println("Массив без изменений - " + Arrays.toString(arr) );
        Object sw = arr[n];
        arr[n] = arr[n1];
        arr[n1] = (String) sw;
        System.out.println("Отредактированный массив - " + Arrays.toString(arr) + "\n");
    }

    /** 2 задание*/
    public static <T> ArrayList <T> arrayList (T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

}
