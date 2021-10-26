package org.example;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        UselessBox uselessBox = new UselessBox();
        Thread user = new Thread(uselessBox::onSwitch, "Пользователь");
        Thread toy = new Thread(uselessBox::offSwitch, "Игрушка");
        user.start();
        toy.start();
        while (true) {
            if (user.isInterrupted()) {
                toy.interrupt();
                System.out.println("Поток " + toy.getName() + " остановлен");
                break;
            }
        }
    }
}
