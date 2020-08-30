package me.ruosch.kyu4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingCardsSolution {

    // The characters used in the messages
    private final List<Character> ALPHABET = Arrays.asList(
            ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );

    // The original classic deck of 52 playing cards
    private final List<String> ORIGINAL_DECK = Arrays.asList(
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC", // Clubs
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD", // Diamonds
            "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH", // Hearts
            "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS"  // Spades
    );

    // An array containing the results of the factorial operations from 0! to (number of playing cards)!
    private BigInteger[] factorialValues;

    PlayingCardsSolution() {
        // Compute and store the factorial values up to ORIGINAL_DECK.size()!
        factorialValues = new BigInteger[ORIGINAL_DECK.size() + 1];
        factorialValues[0] = new BigInteger("1");
        for (int index = 1; index <= ORIGINAL_DECK.size(); index ++) {
            factorialValues[index] = factorialValues[index - 1].multiply(new BigInteger(String.valueOf(index)));
        }
    }

    /**
     * Takes a String containing a message, and returns an array of Strings representing
     * a deck of playing cards ordered to hide the message, or null if the message is invalid.
     */
    public String[] encode(String message) {
        // The base (which is the number of letters in the alphabet) of the numeral system
        // used to compute the message numeric value
        BigInteger base = new BigInteger(String.valueOf(ALPHABET.size()));

        // The numeric value of the message
        BigInteger messageNumericValue = new BigInteger("0");

        // The deck permutation, represented in the factorial number system; the
        // permutation number is equal to the numeric value of the message
        int[] deckPermutation = new int[ORIGINAL_DECK.size()];

        // A copy of the original deck, used to create the final deck
        String[] originalDeck = new String[ORIGINAL_DECK.size()];

        // The final deck, with the message hidden in it
        String[] deck = new String[ORIGINAL_DECK.size()];

        // Compute the numeric value of the message (with the same method as a classic
        // numeral system, from right to left)
        for (int index = message.length() - 1; index >= 0 ; index --) {
            // Get the value corresponding to this character
            int characterValue = ALPHABET.indexOf(message.charAt(index));

            // If the value is equal to -1, the character is invalid
            if (characterValue == -1) {
                return null;
            }

            // Multiply the character value by the base raised to the power
            // of the character rank, and add the result to the message numeric value
            messageNumericValue = messageNumericValue.add(
                    base.pow(message.length() - 1 - index).multiply(BigInteger.valueOf(characterValue)));
        }

        // Check if the message numeric value is not too large
        if (messageNumericValue.compareTo(factorialValues[ORIGINAL_DECK.size()]) >= 0) {
            return null;
        }

        // Compute the permutation, in the factorial number system, corresponding to the message numeric value
        for (int index = 0; index < ORIGINAL_DECK.size(); index ++) {
            // Successively divide the message numeric value by the factorial values,
            // from (number of playing cards - 1)! to 0!
            BigInteger[] result = messageNumericValue.divideAndRemainder(factorialValues[ORIGINAL_DECK.size() - 1 - index]);

            // The result is the next digit of the permutation represented in the factorial number system
            deckPermutation[index] = result[0].intValue();

            // The remainder is kept to be divided in the next operation
            messageNumericValue = result[1];
        }

        // Create a copy of the original playing cards deck
        for (int index = 0; index < ORIGINAL_DECK.size(); index ++) {
            originalDeck[index] = ORIGINAL_DECK.get(index);
        }

        // Build the final deck
        for (int index = 0; index < ORIGINAL_DECK.size(); index ++) {
            // Successively get one digit of the permutation, represented in the factorial number system
            int cardDigit = deckPermutation[index];

            // Count the remaining available cards and take the one corresponding to the current digit
            int currentCardNumber = -1;
            int currentCardIndex = -1;
            do {
                currentCardIndex ++;
                if (originalDeck[currentCardIndex] != "") {
                    currentCardNumber ++;
                }
            } while (currentCardNumber != cardDigit);

            // Add the card to the final deck, and remove it from the original deck,
            // as it won't be available any more
            deck[index] = originalDeck[currentCardIndex];
            originalDeck[currentCardIndex] = "";
        }

        return deck;
    }

    /**
     * Takes an array of Strings representing a deck of playing cards, and returns
     * the message that is hidden inside, or null if the deck is invalid.
     */
    public String decode(String[] deck) {
        // The playing card values
        List<Integer> deckCardsValues = new ArrayList<Integer>();

        // The numeric value of the deck permutation
        BigInteger deckNumericValue = new BigInteger("0");

        // The number of characters contained in the hidden message
        int numberOfCharacters;

        // The base (which is the number of letters in the alphabet) of the numeral system
        // used with the message numeric value
        BigInteger base = new BigInteger(String.valueOf(ALPHABET.size()));

        // The retrieved character values
        List<Integer> charactersValues = new ArrayList<Integer>();

        // The decoded hidden message
        String message = "";

        // Check if the number of cards in the deck is correct
        if (deck.length != ORIGINAL_DECK.size()) {
            return null;
        }

        // Get the value of each playing cards
        for (int index = 0; index < ORIGINAL_DECK.size(); index ++) {
            // Get the value corresponding to this card
            int cardValue = ORIGINAL_DECK.indexOf(deck[index]);

            // If the value is equal to -1, the card is invalid
            if (cardValue == -1) {
                return null;
            }

            // If the value is already present if the list, that means the cards is
            // present two times in the deck, so the deck is invalid
            if (deckCardsValues.contains(cardValue)) {
                return null;
            }

            deckCardsValues.add(cardValue);
        }

        // Count the number of "smaller" cards (smaller values) present at the right
        // of each card, and compute the numeric value of this deck permutation
        for (int index = 0; index < ORIGINAL_DECK.size() - 1; index ++) {
            int numberOfSmallerCards = 0;
            for (int indexBis = index + 1; indexBis < ORIGINAL_DECK.size(); indexBis ++) {
                if (deckCardsValues.get(index) > deckCardsValues.get(indexBis)) {
                    numberOfSmallerCards ++;
                }
            }

            // Multiply the number of smaller cards by the factorial of the rank,
            // and add the result to the deck numeric value
            deckNumericValue = deckNumericValue.add(
                    factorialValues[ORIGINAL_DECK.size() - 1 - index].multiply(BigInteger.valueOf(numberOfSmallerCards)));
        }

        // If the numeric value is equal to zero, the hidden message is empty
        if (deckNumericValue.toString() == "0") {
            return "";
        }

        // Retrieve the number of characters contained in the hidden message
        // (log base x of y = log base e of y / log base e of x)
        numberOfCharacters = (int) (Math.log(deckNumericValue.doubleValue()) / Math.log(ALPHABET.size())) + 1;

        // Retrieve the characters numeric values
        for (int index = numberOfCharacters; index > 0; index --) {
            // Successively divide the deck numeric value by the base raised to the power
            // of the rank, from base ^ (number of characters - 1)! to base ^ 0
            BigInteger[] result = deckNumericValue.divideAndRemainder(base.pow(index - 1));

            // The result is the value of the next character
            charactersValues.add(result[0].intValue());

            // The remainder is kept to be divided in the next operation
            deckNumericValue = result[1];
        }

        // Rebuild the secret message
        for (int characterValue : charactersValues) {
            message += ALPHABET.get(characterValue);
        }

        return message;
    }
}
