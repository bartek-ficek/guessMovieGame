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

    public String expressionDraw() {
        int random = (int) (Math.random() * listOfMovies.size());
        String randomMovie = listOfMovies.get(random);
//        System.out.println(randomMovie);
        return randomMovie;
    }


    public void changeToUnderscore() {
        String s = expressionDraw();
        System.out.println(s);
        char[] sAsArray = s.toCharArray();
//        System.out.println(s.toString() + "  " + sAsArray.length);
        char[] underscore = new char[sAsArray.length];
        for (int i = 0; i < sAsArray.length; i++) {
            if (sAsArray[i] == ' ') {
                underscore[i] = ' ';
            } else {
                underscore[i] = '_';
            }
        }
        System.out.println(underscore);

    }


}
