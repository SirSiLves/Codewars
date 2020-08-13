package me.ruosch.battleship;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FieldValidator {

    private static int[][] battleField1 = {
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private static int[][] battleField2 = {
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 1, 0, 0}
    };

    private static int[][] battleField3 = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
        // write your code here
        Object testVariable = battleField1;
        try {
            Class c = Class.forName("me.ruosch.battleship.FieldValidator");

            for (Method m : c.getDeclaredMethods()) {
                if (m.getName().equals("fieldValidator")) System.out.println(m.invoke(null, testVariable));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static boolean fieldValidator(int[][] field) {

        int battleship = 0;
        int cruisers = 0;
        int destroyers = 0;
        int submarines = 0;

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {

                if (field[y][x] == 1) {

                    int shipSize = validateShip(field, y, x);

                    if (shipSize == 4) battleship++;
                    else if (shipSize == 3) cruisers++;
                    else if (shipSize == 2) destroyers++;
                    else if (shipSize == 1) submarines++;
                }
            }
        }
        return (battleship == 1 && cruisers == 2 && destroyers == 3 && submarines == 4);
    }


    public static int validateShip(int[][] field, int y, int x) {

        int shipSize = 0;

        //validate vertical
        for (int i = 0; i < 4; i++) {

            if ((x + i < 10 && field[y][x + i] == 1)
                    && (y + 1 < 10 && field[y + 1][x + i] != 1 && (x > 0 && field[y + 1][x + i - 1] != 1 || x == 0) || y == 9)
                    && (y - 1 >= 0 && field[y - 1][x + i] != 1 || y == 0)) {

                if (x > 0 && field[y][x - 1] != 1 || x == 0) {
                    shipSize++;

                } else break;
            } else break;
        }

        if (shipSize == 0) {

            //validate horizontal
            for (int j = 0; j < 4; j++) {

                if ((y + j < 10 && field[y + j][x] == 1)
                        && (x + 1 < 10 && field[y + j][x + 1] != 1 || x == 9)
                        && (x - 1 >= 0 && field[y][x - 1] != 1 || x == 0)) {

                    if (y > 0 && field[y - 1][x] != 1 || y == 0) {
                        shipSize++;

                    } else break;
                } else break;
            }
        }

        return shipSize;
    }


}
