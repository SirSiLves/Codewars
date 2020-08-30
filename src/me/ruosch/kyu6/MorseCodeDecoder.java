package me.ruosch.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;


/*
 *
 *   Decode the Morse code
 *   https://www.codewars.com/kata/54b724efac3d5402db00065e/java
 *
 * */


public class MorseCodeDecoder {


    public static void main(String[] args) {
//        System.out.println(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
        System.out.println(MorseCodeDecoder.decode("   .   . "));
    }


    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)

        String decodedWord = "";
        String[] words = morseCode.split("   ");

        for(int i = 0; i < words.length; i++){
            String[] morse = words[i].split(" ");

            for(String m : morse){
                String getCode = (m); //MorseCode.get(m);
                if(getCode != null) decodedWord += getCode;
            }

            if(i < words.length - 1 && !(words[i].equals(""))){
                decodedWord += " ";
            }
        }

        return decodedWord;
    }


//    public static String decode2(String morseCode) {
//        return Arrays.stream(morseCode.trim().split("   "))
//                .map(MorseCodeDecoder::decodeWord)
//                .collect(Collectors.joining(" "));
//    }
//
//    private static String decodeWord(String word) {
//        return Arrays.stream(word.split(" ")).map(MorseCode::get).collect(Collectors.joining());
//    }

}
