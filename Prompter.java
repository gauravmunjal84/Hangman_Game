import java.io.Console;

public class Prompter{
  private Game mGame;
  public Prompter(Game game){
  mGame = game;
  }
  
  public void play(){
    while (mGame.getRemainingTries() > 0 && !mGame.isSolved()){
      displayProgress();
      promptForGuess();
    }
    if(mGame.isSolved()){
      System.out.printf("Congratulations !!! You solved the puzzle with %d tries remaining. \n", 
                         mGame.getRemainingTries());
    } else{
    System.out.printf("You have used all your tries, better luck next time, the word was **%s** \n ", mGame.getAnswer());
    }
  }
  
  public boolean promptForGuess(){
    Console console = System.console();
    boolean isHit = false;
    boolean isValidGuess = false;
    while(!isValidGuess){
    String guessAsString = console.readLine("Enter a letter:  ");
    try {
      isHit = mGame.applyGuess(guessAsString);
      isValidGuess=true;
    } catch (IllegalArgumentException iae){
      System.out.printf("%s Please try again\n", iae.getMessage()); 
    }
   }
    return isHit;
  }
  
  
  
  public void displayProgress(){
    System.out.printf(" You have %d tries to solve: %s\n", 
                      mGame.getRemainingTries(),
                      mGame.getCurrentProgress());
  }
}