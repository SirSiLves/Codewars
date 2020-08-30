package me.ruosch.kyu6;

/*
 *
 *   Jewel Thief
 *   https://www.codewars.com/kata/5b40a38f6be5d82775000003
 *
 * */

public class Dinglemouse {

    public static int count = 0;

    public static void main(String[] args) {
        Safe safe = new Safe();
        System.out.println(crack(safe));
    }


    public static int crack(Safe safe) {

        String fullCode = "";
        String code = "";

        int i = 0;
        while (i < 3) {
            for (int j = 0; j < 200; j++) {
                code = j % 100 < 10 ? "0" : "";
                code = fullCode + (j > 99 ? "L" : "R") + code + j % 100;

                if (i == 0 && safe.unlock(code).equals("click")) break;
                else if (i == 1 && safe.unlock(code).equals("click-click")) break;
                else if (i == 2 && safe.unlock(code).equals("click-click-click")) break;
            }

            fullCode = code + "-";
            i++;
        }

        return safe.open();
    }


}


class Safe {

    public String unlock(String combination) {
        if (combination.equals("R56")) {
            Dinglemouse.count++;
            return "click";
        } else if (combination.equals("L32")) {
            Dinglemouse.count++;
            return "click";
        } else return "";
    }

    public int open() {
        if (Dinglemouse.count == 3) return 95995;
        else return 0;
    }
}
