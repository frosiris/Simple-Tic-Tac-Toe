import java.util.*;

public class Main {
    public static String winnerRow(String[][] arrayList) {
        List<String> myWinnerList = new ArrayList<>();
        String winner = "";
        int counterRow;
        int counterEmpty;
        
        for (int i = 0; i < arrayList.length; i++) {
            counterRow = 0;
            counterEmpty = 0;
            for (int j = 0; j < arrayList.length; j++) {
                if (arrayList[i][j].equals("X")) {
                    counterRow++;
                } else if (arrayList[i][j].equals(" ")) {
                    counterEmpty++;
                }
                if (j == 2) {
                    if (counterRow == 3) {
                    myWinnerList.add("X");
                    } else if (counterRow == 0) {
                        if (counterEmpty == 0) {
                            myWinnerList.add("O");
                        } else {
                            myWinnerList.add("Draw");
                        }
                    } else {
                        myWinnerList.add("Draw");
                    }
                }
            }
        }
        
        if (myWinnerList.get(0) == "X" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "Draw") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "X" && myWinnerList.get(2) == "Draw") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "X") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "O" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "Draw") {
            winner = "O wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "O" && myWinnerList.get(2) == "Draw") {
            winner = "O wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "O") {
            winner = "O wins";
        } else {
            winner = "Draw";
        }
        return winner;
    }

    public static String winnerColumn(String[][] arrayList) {
        List<String> myWinnerList = new ArrayList<>();
        String winner = "";
        int counterColumn;
        int counterEmpty;
        
        for (int j = 0; j < arrayList.length; j++) {
            counterColumn = 0;
            counterEmpty = 0;
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i][j].equals("X")) {
                    counterColumn++;
                } else if (arrayList[i][j].equals(" ") || arrayList[i][j].equals("_")) {
                    counterEmpty++;
                }
                if (i == 2) {
                    if (counterColumn == 3) {
                    myWinnerList.add("X");
                    } else if (counterColumn == 0) {
                        if (counterEmpty == 0) {
                            myWinnerList.add("O");
                        } else {
                            myWinnerList.add("Draw");
                        }
                    } else {
                        myWinnerList.add("Draw");
                    }
                }
            }
        }
        
        if (myWinnerList.get(0) == "X" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "Draw") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "X" && myWinnerList.get(2) == "Draw") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "X") {
            winner = "X wins";
        } else if (myWinnerList.get(0) == "O" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "Draw") {
            winner = "O wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "O" && myWinnerList.get(2) == "Draw") {
            winner = "O wins";
        } else if (myWinnerList.get(0) == "Draw" && myWinnerList.get(1) == "Draw" && myWinnerList.get(2) == "O") {
            winner = "O wins";
        } else {
            winner = "Draw";
        }
        return winner;
    }
    
    public static String winnerDiagonal(String[][] arrayList) {
        int winnerDiagonal1 = 0; //x
        int winnerDiagonal2 = 0;
        int winnerDiagonal3 = 0; //o
        int winnerDiagonal4 = 0;
        String winner = "";
        
        if (arrayList[0][0].equals("X") && arrayList[1][1].equals("X") && arrayList [2][2].equals("X")) {
            winnerDiagonal1 = 1;
        }
        if (arrayList[0][2].equals("X") && arrayList[1][1].equals("X") && arrayList [2][0].equals("X")) {
            winnerDiagonal2 = 1;
        }
        if (arrayList[0][0].equals("O") && arrayList[1][1].equals("O") && arrayList [2][2].equals("O")) {
            winnerDiagonal3 = 1;
        }
        if (arrayList[0][2].equals("O") && arrayList[1][1].equals("O") && arrayList [2][0].equals("O")) {
            winnerDiagonal4 = 1;
        }

        if ((winnerDiagonal1 == 1 && winnerDiagonal2 == 0) || (winnerDiagonal1 == 0 && winnerDiagonal2 == 1)) {
            winner = "X wins";
        } else if ((winnerDiagonal3 == 1 && winnerDiagonal4 == 0) || (winnerDiagonal3 == 0 && winnerDiagonal4 == 1)) {
            winner = "O wins";
        } else {
            winner = "Draw";
        }
        return winner;
    }
    
    public static String checkValidMove(String moveX, String[][] arrayList, Integer moveCount) {
        Integer row = -1;
        Integer column = -1;
        String finalCheck = "OK";
        String[] parts = moveX.split(" ");
        
        try{
            row = Integer.parseInt(parts[0]) - 1;
            column = Integer.parseInt(parts[1]) - 1;

            if ((row < 0) || (column < 0) || (row > 2) || (column > 2)) {
                finalCheck = "Coordinates should be from 1 to 3!";
            } else if ((!arrayList[row][column].equals("_")) && (!arrayList[row][column].equals(" "))) {
                finalCheck = "This cell is occupied! Choose another one!";
            } else {
                if (moveCount % 2 == 0) {
                    arrayList[row][column] = "X";
                } else {
                    arrayList[row][column] = "O";
                }
            }

            if (finalCheck != "OK") {
                System.out.println(finalCheck);
            }
            
            return finalCheck;
        }
        catch (NumberFormatException ex){
            finalCheck = "You should enter numbers!";
            System.out.println(finalCheck);
            return finalCheck;
        }
    }
    
    public static void printTable(char separator, String[][] arrayList) {
        
        System.out.println("---------");
        String[][] emptyReferenceForComparison= new String[arrayList.length][arrayList.length];
        
        if (Arrays.deepEquals(arrayList, emptyReferenceForComparison) == true) {
            for (int p = 0; p < 3; p++){
                for (int q = 0; q < 3; q++){
                    arrayList[p][q] = " ";
                }
            }
        }
        
        for (int p = 0; p < 3; p++){
            for (int q = 0; q < 3; q++){
                if (p == 0 && q == 0){
                    System.out.print(separator);
                    System.out.print(" " + arrayList[p][q]);
                    }
                else if (p == 0 && q == 2){
                    System.out.print(" " + arrayList[p][q]);
                    System.out.print(" " + separator);
                    System.out.println("");
                    }
                else if (p == 1 && q == 0){
                    System.out.print(separator);
                    System.out.print(" " + arrayList[p][q]);
                    }
                else if (p == 1 && q == 2){
                    System.out.print(" " + arrayList[p][q]);
                    System.out.print(" " + separator);
                    System.out.println("");
                    }
                else if (p == 2 && q == 0){
                    System.out.print(separator);
                    System.out.print(" " + arrayList[p][q]);
                    }
                else if (p == 2 && q == 2){
                    System.out.print(" " + arrayList[p][q]);
                    System.out.print(" " + separator);
                    System.out.println("");
                    }
                else {
                    System.out.print(" " + arrayList[p][q]);
                    }
                }
            }
        
        System.out.println("---------");
    }
    
    public static String checkWinner(String[][] arrayList) {
        
        String winnerResultRow = winnerRow(arrayList);
        String winnerResultColumn = winnerColumn(arrayList);
        String winnerResultDiagonal = winnerDiagonal(arrayList);
        
        if (winnerResultRow.contains("wins")) {
            return winnerResultRow;
        } else if (winnerResultColumn.contains("wins")) {
            return winnerResultColumn;
        } else if (winnerResultDiagonal.contains("wins")) {
            return winnerResultDiagonal;
        } else {
            return "";
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        String[][] myArray = new String[3][3];
        String myString = "";
        String nextMoveCheck = "";
        char mySeparator = '|';
        String checkWinner = "";
        Integer moveCounter = 0;
        
        //Starting empty table
        printTable(mySeparator, myArray);
        
        //Ask player for move and check validity of coordinates
        do {
            myString = myScanner.nextLine();
            System.out.println("Enter the coordinates: " + myString);
            nextMoveCheck = checkValidMove(myString, myArray, moveCounter);
            if (nextMoveCheck == "OK") {
                moveCounter++;
                printTable(mySeparator, myArray);
            }
            checkWinner = checkWinner(myArray);
        }
        while ((checkWinner != "Draw") && (myScanner.hasNextLine()) && (!checkWinner.contains("wins")));
        System.out.println(checkWinner);
        
    }
}