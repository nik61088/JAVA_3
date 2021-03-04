package Lesson5;

import java.util.concurrent.Semaphore;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        Semaphore smp = new Semaphore(1);

        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

            if (length == 40){
                try {
                    System.out.println(c.getName() + " - WIN !!!");
                    smp.acquire(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    smp.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
