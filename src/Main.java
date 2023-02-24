import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            String[] titles = scanner.nextLine().split(",");
            String title = titles[rand.nextInt(titles.length)];
            Game game = new Game(title);
            game.play();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open the file");
        }
    }
}