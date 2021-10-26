package org.example;


/**
 * Класс бесполезной коробки
 */
public class UselessBox {

    //Тумблер
    public volatile boolean switcher = false;
    Tumbler tumbler = new Tumbler(this);

    public boolean getSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    /**
     * Метод включения тумблера для пользователя
     */
    public void onSwitch() {
        tumbler.onTumbler();
        Thread thread = Thread.currentThread();
        thread.interrupt();
        System.out.println("Поток " + thread.getName() + " остановлен");
    }

    /**
     * Метод выключения тумблера для игрушки
     */
    public void offSwitch() {
        while (!Thread.currentThread().isInterrupted()) {
            tumbler.offTumbler();
        }
    }


}
