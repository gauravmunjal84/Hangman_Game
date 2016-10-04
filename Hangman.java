public class Hangman {
    
    public static void main(String[] args) {
        // Enter amazing code here:
      if(args.length == 0){
        System.out.println("Please enter the word for game");
        System.exit(0);
      }
      Game game1 = new Game(args[0]);
      Prompter prompter = new Prompter(game1);
      prompter.play();
    }

}