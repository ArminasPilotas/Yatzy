import java.util.HashMap;
import java.util.Scanner;

public class Game {
    String playerName;
    Dice dice;
    ScoreBoard scoreBoard;

    public Game() {
        dice=new Dice();
        scoreBoard=new ScoreBoard();
        this.playerName=null;
    }

    private final void showWelcomeWindow(){
        System.out.println("---Welcome To Yatzy---");
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.playerName=scanner.nextLine();
    }
    public void startGame(){
        showWelcomeWindow();
        while(!isGameEnded()){
            clearConsole();
            dice.clearDices();
            dice.rollDices();
            int rolltimes=1;
            dice.printDices();
            scoreBoard.calculateScore(dice.getDiceList());
            scoreBoard.PrintScoreBoard();
            if(askForReroll()){ //ask player which dices he/she wants to reroll
                while(rolltimes<=3){
                    Scanner scanner=new Scanner(System.in);

                    clearConsole();
                    dice.rerollDices();
                }
            }
            else{ //if player don't wants to reroll dices ask him where to update score
                askWhichCategoryUpdate();
            }
        }
    }
    private boolean isGameEnded(){
        HashMap<String,Integer> scores=scoreBoard.getSelectedCategoriesList();
        if(scores.containsValue(0)) return false;
        else return true;
    }
    private final void clearConsole(){
        for(int clear = 0; clear < 100; clear++) {
            System.out.println("\b") ;
        }
    }
    private boolean askForReroll() { //ask player if she/he wants to reroll dices
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to reroll dices? yes/no : ");
        answer = scanner.nextLine();
        answer = answer.toLowerCase();
        switch (answer) {
            case "yes":
                return true;
            case "no":
                return false;
            default:
                throw new Error("This input is not available");

        }
    }
    private void askWhichCategoryUpdate(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter in which category update score: ");
        scoreBoard.UpdateScore(scanner.nextLine());
    }
}


