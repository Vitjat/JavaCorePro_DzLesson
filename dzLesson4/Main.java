package dzLesson4;

// второе задание в процессе

public class MainOne {
    static volatile char c = 'A';
    static Object mon = new Object();

    public static void main(String[] args) {
        System.out.println("Flow");
        new Thread(new WaitNotifyAll('A', 'B')).start();
        new Thread(new WaitNotifyAll('B', 'C')).start();
        new Thread(new WaitNotifyAll('C', 'A')).start();
    }

    static class WaitNotifyAll implements Runnable {
        private char currentLetter;
        private char nextLetter;

        public WaitNotifyAll(char currentLetter, char nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    try {
                        while (c != currentLetter)
                            mon.wait();
                        System.out.print(currentLetter);
                        c = nextLetter;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

