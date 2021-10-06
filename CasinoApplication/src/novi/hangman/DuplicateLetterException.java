package novi.hangman;

public class DuplicateLetterException extends Throwable {
    public DuplicateLetterException(char letter) {
        super(String.format("You already tried the letter %s", letter));
    }
}
