import java.util.Scanner;

public class Game {
    private String title;
    private String guessedLetters;

    public Game(String title) {
        this.title = title.toUpperCase();
        this.guessedLetters = "";
    }

    public boolean guessLetter(char letter) {
        boolean isCorrect = false;
        letter = Character.toUpperCase(letter);
        for (int i = 0; i < title.length(); i++) {
            if (title.charAt(i) == letter) {
                guessedLetters += letter;
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            System.out.println("there is no such letter");
        }
        return isCorrect;
    }

    public boolean isGameOver() {
        return !getHiddenTitle().contains("_");
    }

    public String getHiddenTitle() {
        String hiddenTitle = "";
        for (int i = 0; i < title.length(); i++) {
            char letter = title.charAt(i);
            if (guessedLetters.indexOf(letter) >= 0) {
                hiddenTitle += letter;
            } else if (letter == ' ') {
                hiddenTitle += " ";
            } else {
                hiddenTitle += "_";
            }
            hiddenTitle += " ";
        }
        return hiddenTitle;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            System.out.println("Title of the movie:");
            System.out.println(getHiddenTitle());
            System.out.print("Enter a letter: ");
            char letter = scanner.next().charAt(0);
            guessLetter(letter);
        }
        System.out.println("Congratulations, you guessed the title of the movie: " + title);
    }
}

