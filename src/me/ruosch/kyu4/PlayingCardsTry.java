package me.ruosch.kyu4;


/*
 *
 *   Hide a message in a deck of playing cards
 *   https://www.codewars.com/kata/59b9a92a6236547247000110
 *
 * */


import java.math.BigInteger;

public class PlayingCardsTry {

    public static String[] numeralSystem = {
            "_", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    public static String[] sortedDeck = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
            "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
            "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS"
    };

    public static String[] aMessage = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
            "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
            "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "KS", "QS"
    };

    public static String[] attackTonightMessage = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "JD", "9D", "7S", "9S", "QD", "5S", "TH",
            "7D", "TS", "QS", "2H", "JS", "6H", "3S", "6S", "TD", "8S", "2S", "8H", "7H",
            "4S", "4H", "3H", "5H", "AS", "KH", "QH", "9H", "KD", "KS", "JH", "8D", "AH"
    };

    public static String[] attackAprovedMessage = {
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
            "AH", "2H", "3H", "4H", "8H", "9S", "3S", "2S", "8S", "TS", "QS", "9H", "7H",
            "KH", "AS", "JH", "4S", "KS", "JS", "5S", "TH", "7S", "6S", "5H", "QH", "6H"
    };


    public static void main(String[] args) {

        PlayingCardsTry playingCardsTry = new PlayingCardsTry();
//        System.out.println(Arrays.toString(playingCards.encode("ATTACK TONIGHT ON CODEWARS"))); // --> attackTonightMessage
        System.out.print(playingCardsTry.decode(attackTonightMessage)); // --> ATTACK APPROVED

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

        BigInteger n2 = new BigInteger("" + sortedDeck.length);
        System.out.println(n2);

        long n = sortedDeck.length;
        long permutationValue = findLexicographicalPosition(deck, n - 1);

//        long permutationValue = 4280298; // HALLO

        String decodedWord = "";

        int exp = (int) (Math.log(permutationValue) / Math.log(27));

        while (exp > 0) {

            int nsValue = 26;

            for (int i = numeralSystem.length - 1; i > 0; i--) {
                if (i * Math.pow(27, exp) > permutationValue) {
                    nsValue--;
                } else {
                    permutationValue -= Math.pow(27, exp) * i;
                    break;
                }
            }
            decodedWord += numeralSystem[nsValue];
            exp--;
        }

        decodedWord += numeralSystem[(int) permutationValue];
        return decodedWord;
    }


    public static long executeFactorial(long n) {
        return (n <= 2) ? n : n * executeFactorial(n - 1);
    }

    public static long findLexicographicalPosition(String[] encodedMessage, long n) {
        long lexPosition = 0;

        for (int i = 0; i < n; i++) {
            int lex = 0;

            for (int j = i + 1; j <= n; j++) {

                if (getIndex(encodedMessage[i]) > getIndex(encodedMessage[j])) {
                    lex++;
                }

            }
            lexPosition += lex * executeFactorial(n - i);
        }

        return lexPosition;
    }


    public static long getIndex(String encodedCard) {
        int n = 0;
        for (String card : sortedDeck) {
            if (card.equals(encodedCard)) return n;
            else n++;
        }
        return n;
    }


}
