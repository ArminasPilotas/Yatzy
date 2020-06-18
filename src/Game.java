import java.util.*;

public class Game {
    String playerName;
    Dice dice;
    ScoreBoard scoreBoard;

    public Game(Dice diceService,ScoreBoard scoreBoardService) {
        dice=diceService;
        scoreBoard=scoreBoardService;
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
            scoreBoard.resetCategoriesListScore();
            dice.rollDices();
            int rolltimes=1;
            dice.printDices();
            scoreBoard.calculateScore(dice.getDiceList());
            scoreBoard.printScoreBoard();
            if(askForReroll()){ //ask player which dices he/she wants to reroll
                while(rolltimes<3){
                    clearConsole();
                    dice.printDices();
                    scoreBoard.printScoreBoard();
                    scoreBoard.resetCategoriesListScore();
                    System.out.println("Rolls left " + (3-rolltimes));
                    Scanner scanner=new Scanner(System.in);
                    List<Integer> numbers=new ArrayList<Integer>();
                    System.out.println("Enter how much dices do you want to reroll: ");
                    int size=scanner.nextInt();
                    System.out.println("Enter indexes from 1 to 5 which dices to reroll");
                    for(int i=0;i<size;i++){
                        numbers.add(scanner.nextInt());
                    }
                    dice.rerollDices(numbers);
                    clearConsole();
                    dice.printDices();
                    scoreBoard.calculateScore(dice.getDiceList());
                    scoreBoard.printScoreBoard();
                    rolltimes++;
                    if(rolltimes==3||!askForReroll()){
                        askWhichCategoryUpdate();
                        break;
                    }

                }
            }
            else{ //if player don't wants to reroll dices ask him where to update score
                askWhichCategoryUpdate();
            }
        }
            showFinishGameMessage();
    }
    public boolean isGameEnded(){ //set to public for testing purposes
        HashMap<String,Integer> scores=scoreBoard.getSelectedCategoriesList();
        return !scores.containsValue(0);
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
                return false;

        }
    }
    private void askWhichCategoryUpdate(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter in which category update score: ");
        scoreBoard.updateScore(scanner.nextLine());

    }
    private void showFinishGameMessage(){
        clearConsole();
        System.out.println("Good game " + playerName + " your score is: ");
        for(Map.Entry<String,Integer> entry: scoreBoard.getSelectedCategoriesList().entrySet()){
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }

    public ScoreBoard getScoreBoard() { //this method is for testing purposes only
        return scoreBoard;
    }
}


