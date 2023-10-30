public class Philosopher extends Thread {
    private int counter;
    private final Fork rightFork;
    private final Fork leftFork;
    private final String name;
    boolean rightFlag = true;
    boolean leftFlag = true;



    public Philosopher(String name, Fork rightFork, Fork leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }


    @Override
    public void run() {
        try {
            while (counter < 3) {
                muse();
                synchronized (rightFork) {
                    takeRightFork();
                    synchronized (leftFork) {
                        takeLeftFork();
                        eat();
                        counter++;
                        putForks();
                    }
                }
            }
            System.out.println(name + " поел три раза и наелся");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeLeftFork() throws InterruptedException {
        if (leftFlag) {
            System.out.println(name + " взял вилку " + leftFork.number);
            leftFlag = false;
        }

    }

    private void takeRightFork() throws InterruptedException {
        if (rightFlag) {
            System.out.println(name + " взял вилку " + rightFork.number);
            rightFlag = false;
        }
    }

    private void putForks() throws InterruptedException {
        System.out.println(name + " положил обе вилки на стол");
        leftFlag = true;
        rightFlag = true;
    }

    private void muse() throws InterruptedException {
        System.out.println(name + " размышляет...");
        sleep(3000);
        System.out.println(name + " поразмышлял");
    }

    private void eat() throws InterruptedException {
        System.out.println(name + " ест");
        sleep(3000);
        System.out.println(name + " поел");
    }
}