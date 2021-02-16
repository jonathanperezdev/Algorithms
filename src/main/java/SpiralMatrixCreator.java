package main.java;

import org.junit.Test;

import java.util.Arrays;

public class SpiralMatrixCreator {
    public int[][] createSpiralMatrix(int width, int high) {
        int column = width - 1;
        int row = high;

        Position position = new Position();
        int[][] matrix = new int[high][width];

        matrix[0][0] = position.getStepNumber();

        int i = 0;
        while (true) {

            if (i > 2)
                column--;
            if (column == 0)
                break;

            position = walkThroughMatrix(matrix,
                    column,
                    Position.Direction.values()[i % 4],
                    position);
            i++;

            row--;
            if (row == 0)
                break;

            position = walkThroughMatrix(matrix,
                    row,
                    Position.Direction.values()[i % 4],
                    position);
            i++;
        }

        return matrix;
    }

    private Position walkThroughMatrix(int[][] matrix, int stepsToWalk, Position.Direction direction, Position position) {
        int i = 0;
        do {
            switch (direction) {
                case RIGHT:
                    position.setX(position.getX() + 1);
                    break;
                case LEFT:
                    position.setX(position.getX() - 1);
                    break;
                case DOWN:
                    position.setY(position.getY() + 1);
                    break;
                case UP:
                    position.setY(position.getY() - 1);
                    break;
            }

            position.setStepNumber(position.getStepNumber() + 1);
            matrix[position.getY()][position.getX()] = position.getStepNumber();
            i++;
        } while (i < stepsToWalk);

        return position;
    }
}



class Position {

    public enum Direction {RIGHT,DOWN, LEFT, UP};

    private int x ;
    private int y;
    private int stepNumber = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }
}

class SpiralMatrixCreatorTest{

    public static void main(String[] args){
        test1();
    }

    @Test
    public static void  test1(){
        SpiralMatrixCreator spiralMatrixCreator =  new SpiralMatrixCreator();
        printMatrix(spiralMatrixCreator.createSpiralMatrix(8,5));
    }

    private static void printMatrix(int[][] matrix){
        // Loop through all rows
        for (int i = 0; i < matrix.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }
}
