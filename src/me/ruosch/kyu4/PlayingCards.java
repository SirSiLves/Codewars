package me.ruosch.kyu4;


/*
 *
 *   Hide a message in a deck of playing cards
 *   https://www.codewars.com/kata/59b9a92a6236547247000110
 *
 * */


import java.util.Arrays;

public class PlayingCards {

    public static String[] attackTonightMessage = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "JD", "9D", "7S", "9S", "QD", "5S", "TH",
            "7D", "TS", "QS", "2H", "JS", "6H", "3S", "6S", "TD", "8S", "2S", "8H", "7H",
            "4S", "4H", "3H", "5H", "AS", "KH", "QH", "9H", "KD", "KS", "JH", "8D", "AH"
    };

    public static String[] attackProvedMessage = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
            "AH", "2H", "3H", "4H", "8H", "9S", "3S", "2S", "8S", "TS", "QS", "9H", "7H",
            "KH", "AS", "JH", "4S", "KS", "JS", "5S", "TH", "7S", "6S", "5H", "QH", "6H"
    };

    public static String numeralSystem = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main(String[] args) {

        PlayingCards playingCards = new PlayingCards();

        System.out.println(Arrays.toString(playingCards.encode("ATTACK TONIGHT ON CODEWARS"))); // --> attackTonightMessage

        System.out.println(playingCards.decode(attackProvedMessage)); // --> ATTACK APPROVED

    }


    /**
     * Takes a String containing a message, and returns an array of Strings representing
     * a deck of playing cards ordered to hide the message, or null if the message is invalid.
     */
    public String[] encode(String message) {
        return null;
    }

    /**
     * Takes an array of Strings representing a deck of playing cards, and returns
     * the message that is hidden inside, or null if the deck is invalid.
     */
    public String decode(String[] deck) {
        return null;
    }


}
