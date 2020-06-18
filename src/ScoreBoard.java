import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    private HashMap<String,Integer> categoriesScoreList;
    private HashMap<String,Integer> selectedCategoriesList;

    public ScoreBoard(){
        categoriesScoreList=new HashMap<String, Integer>();
        selectedCategoriesList =new HashMap<String, Integer>();
        initializeCategoriesList();
    }
    private void initializeCategoriesList(){
        categoriesScoreList.put("Fives",0);
        categoriesScoreList.put("Chance",0);
        categoriesScoreList.put("One Pair",0);
        selectedCategoriesList.put("Fives",0);
        selectedCategoriesList.put("Chance",0);
        selectedCategoriesList.put("One Pair",0);
    }
    public void calculateScore(ArrayList<Integer> dices){ //calculates score in all categories and stores to hashmap
        for(int i=0;i<5;i++){

            if(dices.get(i)==5) {
                categoriesScoreList.put("Fives", categoriesScoreList.get("Fives") + 5);
            }
            categoriesScoreList.put("Chance",categoriesScoreList.get("Chance")+dices.get(i));
        }
        int biggestPair=0;
        for(int i=0;i<4;i++){
            for(int j=i+1;j<5;j++){
                if(dices.get(i)==dices.get(j)&&biggestPair<dices.get(i)){
                    biggestPair=dices.get(i);
                }
            }
        }
        categoriesScoreList.put("One Pair",biggestPair);

    }
    public void updateScore(String combination) {
        if(!selectedCategoriesList.containsKey(combination)){
            throw new Error("Can't find combination");
        }
        selectedCategoriesList.put(combination, selectedCategoriesList.get(combination) + categoriesScoreList.get(combination));
        resetCategoriesListScore();
    }
    public void resetCategoriesListScore(){
        for(Map.Entry<String,Integer> entry: categoriesScoreList.entrySet()){
            entry.setValue(0);
        }
    }
    public void printScoreBoard() {
        System.out.println("Yours score board" + " Current score board");
        for(Map.Entry<String,Integer> entry: selectedCategoriesList.entrySet()){
            String key=entry.getKey();
            int mainValue=entry.getValue();
            System.out.println(key + " " + mainValue + "          " + key + " " + categoriesScoreList.get(key));
        }
    }
    public HashMap<String, Integer> getSelectedCategoriesList() {
        return selectedCategoriesList;
    }

    public HashMap<String, Integer> getCategoriesScoreList() { //for testing purposes
        return categoriesScoreList;
    }
}
