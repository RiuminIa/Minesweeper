package uloha3.minesWeeper;

public class PrintBoard {
    private String poleNumbers="    ";
    private static int bombs;

    public static int getBombs() {
        return bombs;
    }

    public static void setBombs(int bombs) {
        PrintBoard.bombs = bombs;
    }

    void initial(Vstupy vstup, OnePoint[][] pole) {
        for (int z = 0; z < vstup.getWidth(); z++) {
            poleNumbers = poleNumbers + z + " ";
        }
        bombs=OnePoint.getBombAmount();
        print(pole,vstup);

    }
    void print(OnePoint[][] pole,Vstupy vstup){
        System.out.println(poleNumbers+"   Bomb Amount:"+bombs);
        for(int i=0;i< vstup.getHeight();i++){
            System.out.print(""+i+"|  ");
            for(int w=0;w< vstup.getWidth();w++){
                if(pole[i][w].isEmpty()){
                    if (pole[i][w].isHasBomb()){
                        System.out.print('b'+ " ");
                    }
                    else {
                        System.out.print(pole[i][w].getAktiv() + " ");
                    }
                }
                else{
                    System.out.print(pole[i][w].getNeitral()+" ");
                }
            }
            System.out.println();

        }
    }

    }

