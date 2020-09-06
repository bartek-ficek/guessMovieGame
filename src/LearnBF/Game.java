package LearnBF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    String randomMovie;
    char[] expressionAsArray;
    private List<String> fullList;
    File file = new File("files/movies.txt");
    Scanner fileScanner;
    Scanner inputScanner;
    List<String> listOfMovies = new ArrayList<>();
    char[] underscoreArray;


    public Game() {
        fullList = readFiles();
        randomMovie = expressionDraw();
        expressionAsArray = randomMovie.toCharArray();
        underscoreArray = changeExpressionToUnderscore();
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


    public char[] changeExpressionToUnderscore() {
//        System.out.println(randomMovie);

        char[] underscoreArray = new char[expressionAsArray.length];
        for (int i = 0; i < expressionAsArray.length; i++) {
            if (expressionAsArray[i] == ' ' || expressionAsArray[i] == '\'') {
                underscoreArray[i] = ' ';
            } else {
                underscoreArray[i] = '_';
            }

        }
        return underscoreArray;
    }


    public void guessLetterLoop() {

        int chances = 0;
        boolean correctAnswer = false;
        String workingNameOfMovie = randomMovie;
        do {
            System.out.print("\nYou are guessing:");
            System.out.print(underscoreArray);
            System.out.print("\nYou have guessed (" + chances + ") wrong letters:\nGuess a letter: ");
            inputScanner = new Scanner(System.in);
            String guess = inputScanner.nextLine();
            char[] guessAsChar = guess.toCharArray();

            if (!(workingNameOfMovie.contains(guess))) {
                chances++;
            } else {
                while (workingNameOfMovie.contains(guess)) {
                    int indexOfLetter = workingNameOfMovie.indexOf(guess);
                    underscoreArray[indexOfLetter] = guessAsChar[0];
                    workingNameOfMovie = workingNameOfMovie.replaceFirst(guess, " ");

                    for (int index = 0; index <= underscoreArray.length-1; index++) {
//                        System.out.println(underscoreArray);
                        if (underscoreArray[index] == '_') {
                            break;
                        }
                        else if (underscoreArray[index] != '_' && index == underscoreArray.length-1) {
                            correctAnswer=true;
                            System.out.println("\nYou Win!!! Congratulation! \nThe right answer is: "+randomMovie.toUpperCase());
                            break;
                        }
                    }
                }
            }

            if (chances == 10) {
                System.out.println("\nYou Lose! Try again!");
                break;
            }
            if (correctAnswer) break;
        }
        while (chances < 11);
    }
}


