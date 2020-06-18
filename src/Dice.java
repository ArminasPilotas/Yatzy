import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private ArrayList<Integer> diceList;

    public Dice(){
        diceList=new ArrayList<Integer>();
    }
    public void rollDices(){ //rolls all dices
        for(int i=0;i<5;i++){
            Random rand=new Random();
            diceList.add(rand.nextInt(6)+1);
        }
    }
    public void rerollDices(List<Integer> diceIndexes){
        if(diceIndexes.size()>5||diceIndexes.size()==0){
            throw new Error("Invalid Bounds");
        }
        else{
            for(int i=0;i<diceIndexes.size();i++){
                Random rand=new Random();
                diceList.set(diceIndexes.get(i)-1,rand.nextInt(6)+1);
            }
        }

    }
    public void clearDices(){
        diceList.clear();
    }
    public ArrayList<Integer> getDiceList() {
        return diceList;
    }


    public void printDices() {
        System.out.println("Dices");
        for(int dice:diceList){
            System.out.print(dice + " ");
        }
        System.out.println();
    }
}
