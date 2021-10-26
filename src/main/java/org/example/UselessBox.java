package org.example;

/**
 * Класс бесполезной коробки
 */
public class UselessBox {

    //Тумблер
    public volatile boolean tumbler = false;
    final private Long TIMEOUT = 2000L;
    final private int ITTERATION = 5;
    private int startValue = 0;


    /**
     * Метод включающий тумблер ITTERATION раз (выключает только если тумблер реально был OFF)
     * используется пользователем
     */
    public void onTumbler() {
        try {
            Thread thread = Thread.currentThread();
            while (startValue < ITTERATION) {
                Thread.sleep(TIMEOUT);
                if (!tumbler) {
                    System.out.println(thread.getName() + " - включил тумблер");
                    tumbler = true;
                    startValue++;
                }
            }
            thread.interrupt();
            System.out.println("Поток " + thread.getName() + " остановлен");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод выключающий тумблер, если он был в положении ON
     * Используется игрушкой
     */
    public void offTumbler() {
        while (!Thread.currentThread().isInterrupted()) {
            if (tumbler) {
                System.out.println(Thread.currentThread().getName() + " - выключила тумблер");
                tumbler = false;
            }
        }
    }
}
