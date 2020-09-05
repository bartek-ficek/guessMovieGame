package LearnBF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    String randomMovie;
    private List<String> fullList;
    File file = new File("files/movies.txt");
    Scanner fileScanner;
    List<String> listOfMovies = new ArrayList<>();

    public Game(){
        fullList=readFiles();
        randomMovie=expressionDraw();
    }

    {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFiles() {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            listOfMovies.add(line);
        }
        return listOfMovies;
    }

    public String expressionDraw() {
        int random = (int) (Math.random() * fullList.size());
        randomMovie = fullList.get(random);
        return randomMovie;
    }


    public void changeToUnderscore() {
        String s = randomMovie;
        System.out.println(s);
        char[] sAsArray = s.toCharArray();
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
