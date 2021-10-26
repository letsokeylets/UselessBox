package org.example;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        UselessBox uselessBox = new UselessBox();
        Thread user = new Thread(uselessBox::onTumbler, "Пользователь");
        Thread toy = new Thread(uselessBox::offTumbler, "Игрушка");
        user.start();
        toy.start();
        while (true) {
            //Как только поток пользователя завершил выполнение - необходимо остановить и игрушку
            if (user.isInterrupted()) {
                toy.interrupt();
                System.out.println("Поток " + toy.getName() + " остановлен");
                break;
            }
        }
    }
}
