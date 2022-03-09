package uloha3.minesWeeper;

import uloha3.minesWeeper.Utilities.KeyboardInput;

import java.util.Scanner;

public class Vstupy {
    private String data;
    private int width;
    private int height;
    private int bombAmount;
    public Vstupy() {
        do {
            if ((width = KeyboardInput.readInt("Enter the field width")) <= 0) {
                System.out.println("wrong format");
            }
        } while (width <= 0);
        do {
            if ((height = KeyboardInput.readInt("Enter the field height")) <= 0) {
                System.out.println("wrong format");
            }
        } while (height <= 0);
        do {
            if ((bombAmount = KeyboardInput.readInt("Enter amount of bombs")) <= 0) {
                System.out.println("wrong format");
            }
        } while (bombAmount <= 0);
    }
    public String getData() {
        return data=KeyboardInput.readString("Enter coordinats (vertical a gorizontal -f(for flags))");
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBombAmount() {
        return bombAmount;
    }

    public void setBombAmount(int bombAmount) {
        this.bombAmount = bombAmount;
    }
}
