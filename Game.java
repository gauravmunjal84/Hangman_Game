public class Game{
  public static final int MAX_MISSES = 7;
  private String mAnswer;
  private String mHits;
  private String mMisses;
  
  public Game(String answer){
  mAnswer=answer;
  mHits="";
  mMisses=""; 
  }
  
  private char validateGuess(char letter){
    if(!Character.isLetter(letter)){
      throw new IllegalArgumentException("Guess should be a character");
    }
    letter = Character.toLowerCase(letter);
    if(mHits.indexOf(letter) >=0 || mMisses.indexOf(letter) >= 0){
      throw new IllegalArgumentException("Guess has already been made, Try different letter");
    }
    return letter;
  }
  
  public boolean applyGuess(String letters){
    if(letters.length() == 0){
      throw new IllegalArgumentException ("No letters found");
    }
    return applyGuess(letters.charAt(0));
  }
  
  public boolean applyGuess(char letter){
    letter = validateGuess(letter);
    boolean isHit = mAnswer.indexOf(letter) >=0;
    if(isHit){
      mHits += letter;
      return true;
    } else{
      mMisses += letter;
      return false;
    }
  }
    
   public String getCurrentProgress(){
    String progress = "";
    for (char letter : mAnswer.toCharArray()){
      char display = '-';
      if(mHits.indexOf(letter) >= 0){
        display = letter;
      }
      progress = progress + display;
      
      }
         return progress;
   }
  
  public boolean isSolved(){
    return getCurrentProgress().indexOf('-') == -1;
  }
  
  public int getRemainingTries(){
    return MAX_MISSES - mMisses.length();
  }
  
  public String getAnswer(){
    return mAnswer;
  }
  } 
