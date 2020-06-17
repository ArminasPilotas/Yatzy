import java.util.ArrayList;
import java.util.Random;

public class Dice implements DicePrinter {
    private ArrayList<Integer> diceList;
    private ArrayList<Boolean> selectedDicesList;

    public Dice(){
        diceList=new ArrayList<Integer>();
        selectedDicesList=new ArrayList<Boolean>();
    }
    public void rollDices(){ //rolls all dices
        for(int i=0;i<5;i++){
            Random rand=new Random();
            diceList.add(rand.nextInt(6)+1);
        }
    }
    public void rerollDices(){
       for(int i=0;i<5;i++){
           if(selectedDicesList.get(i)){ //checks if need reroll
               Random rand=new Random();
               diceList.set(i,rand.nextInt(6)+1);
           }
       }
    }
    public void clearDices(){
        diceList.clear();
    }
    public ArrayList<Integer> getDiceList() {
        return diceList;
    }

    public ArrayList<Boolean> getSelectedDicesList() {
        return selectedDicesList;
    }

    @Override
    public void printDices() {
        System.out.println("Dices");
        for(int dice:diceList){
            System.out.print(dice + " ");
        }
        System.out.println();
    }
}
