package uloha3.minesWeeper;

import javax.net.ssl.HostnameVerifier;
import java.util.Scanner;

public class Step {
    private Vstupy vstup;
    private int horizontal;
    private int vertical;
    private String data;
    private String userCommand;
    private OnePoint[][] pole;


    public String getUserCommand() {
        return userCommand;
    }

    public void setUserCommand(String userCommand) {
        this.userCommand = userCommand;
    }

    public Step(Vstupy vstup) {
        this.vstup = vstup;
    }

    public void stebByStep(OnePoint[][] pole) {
        data = vstup.getData();
        Scanner scan = new Scanner(data);
        vertical = scan.nextInt();
        horizontal = scan.nextInt();
        if (scan.hasNext()) {
            userCommand = scan.next();
        }
        else{
            userCommand ="-o";
        }
        this.pole = pole;
    }
    public void mark(){
        if(pole[vertical][horizontal].getNeitral()=='!'){
            pole[vertical][horizontal].setNeitral((char)0);
        }
        else{
            pole[vertical][horizontal].setNeitral('!');
        }
    }
    public int wash() {
        if (pole[vertical][horizontal].isHasBomb()) {
            if (pole[vertical][horizontal].getNeitral()!='!') {
                pole[vertical][horizontal].setEmpty(true);
                return -1;
            }
        } else if ((pole[vertical][horizontal].getAktiv()) != 0) {
            pole[vertical][horizontal].setEmpty(true);
            return 1;
        } else {
            recurs(vertical, horizontal);
        }
        return 0;
    }

    public int recurs(int v, int h) {
        if (pole[v][h].getNeitral()=='!'){
            return 0;
        }
        if (pole[v][h].getAktiv() != 0) {
            pole[v][h].setEmpty(true);
            return 0;
        }
        // if (pole[vertical][horizontal].isEmpty()) {
        pole[v][h].setEmpty(true);
        // }
        if (((v - 1) >= 0) && !(pole[v - 1][h].isEmpty())) {
            recurs(v - 1, h);
        }
        if (((v - 1) >= 0) &&((h - 1) >= 0) && !(pole[v - 1][h-1].isEmpty())) {
            recurs(v - 1, h-1);
        }
        if (((h - 1) >= 0) && !(pole[v][h - 1].isEmpty())) {
            recurs(v, h - 1);
        }
        if (((v + 1)<vstup.getHeight()) &&((h - 1) >= 0) && !(pole[v + 1][h-1].isEmpty())) {
            recurs(v + 1, h-1);
        }
        if (((v + 1) < vstup.getHeight()) && !(pole[v + 1][h].isEmpty())) {
            recurs(v + 1, h);
        }
        if (((v + 1)<vstup.getHeight()) &&((h + 1) < vstup.getWidth()) && !(pole[v + 1][h+1].isEmpty())) {
            recurs(v + 1, h+1);
        }
        if (((h + 1) < vstup.getWidth() && !(pole[v][h + 1].isEmpty()))) {
            recurs(v, h + 1);
        }
        if (((v - 1)>=0) &&((h + 1) < vstup.getWidth()) && !(pole[v - 1][h+1].isEmpty())) {
            recurs(v - 1, h+1);
        }
        if ((v == vertical) && (h == horizontal)) {
            return 0;
        }
        return 0;
    }
}