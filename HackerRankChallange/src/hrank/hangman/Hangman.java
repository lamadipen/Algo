package hrank.hangman;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dipen on 3/9/2017.
 */
public class Hangman {
    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();

    int maxTires =6;
    int currentTry =0;

    ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public  Hangman() throws IOException
    {
        initilizeStreams();
        mysteryWord = pickWord();
        currentGuess = initilizeCurrentGuess();
    }


    private void initilizeStreams() throws IOException{
        try {
            File inFile = new File("dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentline = bufferedReader.readLine();
            while(currentline !=null)
            {
                dictionary.add(currentline);
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e)
        {
            System.out.println("Could not int streams");
        }
    }


    private String pickWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()%dictionary.size());
        return dictionary.get(wordIndex);
    }

    private StringBuilder initilizeCurrentGuess() {
        StringBuilder current = new StringBuilder();

        for(int i=0;i<mysteryWord.length()*2;i++)
        {
            if(i%2 ==0)
            {
                current.append("_");
            }
            else {
                current.append("_");
            }
        }
        return current;
    }

   /* public String drawPicture()
    {

    }*/





}
