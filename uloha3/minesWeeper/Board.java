package uloha3.minesWeeper;

import java.util.Arrays;

public class Board {
    private Vstupy vstup;
    private OnePoint[][] pole;

    public Vstupy getVstup() {
        return vstup;
    }

    public void setVstup(Vstupy vstup) {
        this.vstup = vstup;
    }

    public OnePoint[][] getPole() {
        return pole;
    }

    public void setPole(OnePoint[][] pole) {
        this.pole = pole;
    }

    public Board(Vstupy data) {
        vstup = data;
        pole = new OnePoint[vstup.getHeight()][vstup.getWidth()];
        OnePoint.setBombAmount(vstup.getBombAmount());
        for (int q = 0; q < vstup.getHeight(); q++) {
            for (int w = 0; w < vstup.getWidth(); w++) {
                pole[q][w] = new OnePoint();
            }
        }
        BombGenerate bombs = new BombGenerate(vstup.getHeight() * vstup.getWidth(), vstup.getBombAmount());
        for (int bomb : bombs.getPoleBomb()) {
            pole[bomb / vstup.getWidth()][bomb % vstup.getWidth()].setHasBomb();
            for (int i = bomb / vstup.getWidth() - 1; i <= (bomb / vstup.getWidth() + 1); i++) {
                if ((i < 0) || (i > (vstup.getHeight() - 1))) {
                    continue;
                } else {
                    for (int z = bomb % vstup.getWidth() - 1; z <= (bomb % vstup.getWidth() + 1); z++) {
                        if ((z < 0) || (z > (vstup.getWidth() - 1)) || (pole[i][z].isHasBomb())) {
                            continue;
                        } else {
                            pole[i][z].increment();
                        }
                    }
                }
            }
        }

    }
}
