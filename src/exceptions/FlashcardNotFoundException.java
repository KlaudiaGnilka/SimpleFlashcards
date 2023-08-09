package exceptions;

public class FlashcardNotFoundException extends RuntimeException{
    public FlashcardNotFoundException(String message){
        super(message);
    }
}
