class Main {

    public static void main(String args[]) {
        Game game=new Game(new Dice(),new ScoreBoard());
        game.startGame();

    }

}