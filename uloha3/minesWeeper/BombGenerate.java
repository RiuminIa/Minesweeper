package uloha3.minesWeeper;

import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;

public class BombGenerate {

    private int[] poleBomb;
    public int[] getPoleBomb() {
        return poleBomb;
    }

    public void setPoleBomb(int[] poleBomb) {
        this.poleBomb = poleBomb;
    }

    public BombGenerate(int size, int amount){
        int tempBomb;
        Random rand=new Random();
        int w;
        poleBomb=new int[amount];
        Arrays.fill(poleBomb,Integer.MAX_VALUE);
        for(int i=0;i<amount;i++){
            do{
                tempBomb= rand.nextInt(size);
                w=Arrays.binarySearch(poleBomb,tempBomb);
            }while((Arrays.binarySearch(poleBomb,tempBomb))>0);
            poleBomb[i]=tempBomb;
            sort(poleBomb);
        }
    }
}
