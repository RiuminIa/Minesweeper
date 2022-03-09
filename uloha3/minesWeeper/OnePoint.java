package uloha3.minesWeeper;

public class OnePoint {
    private boolean hasBomb;
    private boolean empty;
    private char neitral;
    private int aktiv;
    private static int bombAmount;

    public boolean isEmpty() {
        return empty;
    }

    public static int getBombAmount() {
        return bombAmount;
    }

    public static void setBombAmount(int bombAmount) {
        OnePoint.bombAmount = bombAmount;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public OnePoint(){
        neitral=(char)0;
        hasBomb=false;
    }

    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb() {
        this.hasBomb = true;
        this.aktiv='b';
    }

    public char getNeitral() {
        return neitral;
    }

    public void setNeitral(char neitral) {
        if(hasBomb){
            if(neitral=='!'){
                if(this.neitral!='!'){
                    bombAmount--;
                    PrintBoard.setBombs(PrintBoard.getBombs()-1);
                }
            }
            else if(this.neitral=='!'){
                bombAmount++;
                PrintBoard.setBombs(PrintBoard.getBombs()+1);
            }
        }
        else{
            if(neitral=='!'){
                if(this.neitral!='!'){
                    PrintBoard.setBombs(PrintBoard.getBombs()-1);
                }
            }
            else if(this.neitral=='!'){
                PrintBoard.setBombs(PrintBoard.getBombs()+1);
            }
        }
        this.neitral=neitral;
    }
    public int getAktiv() {
        return aktiv;
    }
    void increment(){
        this.aktiv++;
    }
    public void setAktiv(int aktiv) {
        this.aktiv = aktiv;
    }

}
