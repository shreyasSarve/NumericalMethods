package com.company.NM;

public class Printer {



    public void display(float[][] matrix,float[] b,int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] +"   ");
            }
            System.out.println("   | "+b[i]);

        }
    }
}
