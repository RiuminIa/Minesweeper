package uloha3.minesWeeper;

public class Game {
    private Vstupy vstup;
    private Board board;
    private Step step;
    public Game(){
        System.out.println("Hi it is Minesweeper game");
        vstup=new Vstupy();
        board=new Board(vstup);
        PrintBoard print=new PrintBoard();
        print.initial(vstup,board.getPole());
        step=new Step(vstup);
        while((OnePoint.getBombAmount()>0) || (PrintBoard.getBombs()!=OnePoint.getBombAmount())){
            step.stebByStep(board.getPole());
            if (step.getUserCommand().equals("-f")){
                step.mark();
            }
            else if (step.wash()==-1){
                System.out.println("You LOSE");
                break;
            }
            print.print(board.getPole(),vstup);
        }
        if (OnePoint.getBombAmount()==0)
        {
            System.out.println("You are WIN!!!");
        }
        else {
            print.print(board.getPole(), vstup);
        }
      //  System.out.println(vstup.getBombAmount());
    }
}
