package dzLesson7;

public class Main {
    public static void main(String[] args) {
        try {
            TestStart.start(MyTest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
