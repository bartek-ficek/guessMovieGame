package LearnBF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    File file = new File("files/movies.txt");
    Scanner fileScanner;
    List<String> listOfMovies = new ArrayList<>();

    {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFiles() {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            listOfMovies.add(line);
        }
    }
}
