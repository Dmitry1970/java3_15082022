package ru.gb.baranov.homework4.Homework4;

public class Hw4 {

    static volatile char c = 'A';
    static Object mon = new Object();

    static class CreateThreeThread implements Runnable {
        private char currentLetter;
        private char nextLetter;

        public CreateThreeThread(char currentLetter, char nextLetter) {
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

    public static void main(String[] args) {

        new Thread(new CreateThreeThread('A', 'B')).start();
        new Thread(new CreateThreeThread('B', 'C')).start();
        new Thread(new CreateThreeThread('C', 'A')).start();
    }
}
