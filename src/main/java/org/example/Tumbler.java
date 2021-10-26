package org.example;

/**
 * Класс игрушки, вклчающей и выключающей тумблер
 */
public class Tumbler {

    private UselessBox box;
    final private Long TIMEOUT = 2000L;
    final private int ITTERATION = 5;
    private int startValue = 0;

    public Tumbler(UselessBox box) {
        this.box = box;
    }

    public void onTumbler() {
        try {
            while (startValue < ITTERATION) {
                Thread.sleep(TIMEOUT);
                if (!box.getSwitcher()) {
                    System.out.println(Thread.currentThread().getName() + " - включил тумблер");
                    box.setSwitcher(true);
                    startValue++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void offTumbler() {
        if (box.getSwitcher()) {
            System.out.println(Thread.currentThread().getName() + " - выключила тумблер");
            box.setSwitcher(false);
        }
    }
}
