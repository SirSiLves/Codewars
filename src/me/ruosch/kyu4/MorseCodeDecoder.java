package me.ruosch.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


/*
 *
 *   Decode the Morse code
 *   https://www.codewars.com/kata/54b724efac3d5402db00065e/java
 *
 * */


public class MorseCodeDecoder {

    public static void main(String[] args) {
//        decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011");
//        decodeBits("000111000111111111000111000111111111000111000111111111000111000");
        decodeBits("00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110");
    }

    public static int getShortestSequence(String bits) {
        int index = 0;
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < bits.length(); i++) {
            if (!(i < bits.length() - 1 && bits.substring(i, i + 1).equals(bits.substring(i + 1, i + 2)))) {
                tempList.add(bits.substring(index, i + 1));
                index = i + 1;
            }
        }
        tempList.sort(Comparator.comparingInt(String::length));
        return tempList.get(0).length();
    }


    public static String convertedBitString(String bits) {
        int shortestSeq = getShortestSequence(bits);
        String convertedS = "";
        for (int i = 0; i < bits.length(); i += shortestSeq) {
            convertedS += bits.substring(i, i + 1);
        }

        return convertedS;
    }

    public static String decodeBits(String bits) {

        bits = bits.replaceAll("^0+", "").replaceAll("0+$", "");
        bits = convertedBitString(bits);

        String morseString = bits.replaceAll("0000000", "   ")
                .replaceAll("000", " ")
                .replaceAll("111", "-")
                .replaceAll("1", ".")
                .replaceAll("0", "");

        System.out.println(morseString);
        return morseString;
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return "decodedMorseCode";
//        return Arrays.stream(word.split(" ")).map(MorseCode::get).collect(Collectors.joining());
    }
}
