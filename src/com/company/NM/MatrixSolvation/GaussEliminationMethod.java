package com.company.NM.MatrixSolvation;

import java.util.Scanner;

public class GaussEliminationMethod {
/*2 1 1 10
3 2 3 18
1 4 9 16*/
    int noOfEquation;
    float[][] a;
    float[] b;
    float[] x;
    Scanner scan=new Scanner(System.in);

    public GaussEliminationMethod(int noOfEquation) {
        this.noOfEquation=noOfEquation;
         a=new float[noOfEquation][noOfEquation];
         b=new float[noOfEquation];
         x=new float[noOfEquation];
    }

    static public void main(String[] args) {
        System.out.println("""
                Enter Matrix in Augmented form like
                2 1 1 10
                3 2 3 18
                1 4 9 16""");

        System.out.println("Total No of equations--> ");
        int equations=new Scanner(System.in).nextByte();
        GaussEliminationMethod guassMethod =new GaussEliminationMethod(equations);

        guassMethod.setMatrix();
        guassMethod.printMatrix();
        guassMethod.rowOperation();
        System.out.println();
    }

    void setMatrix()
    {

        System.out.println("Enter Matrix --> ");
        for (int i = 0; i < noOfEquation; i++)
        {
            for (int j = 0; j < noOfEquation; j++)
            {
                a[i][j]=scan.nextFloat();
            }
            b[i]=scan.nextFloat();
        }
    }
    void printMatrix()
    {
        for (int i = 0; i < noOfEquation; i++)
        {
            for (int j = 0; j < noOfEquation; j++)
            {
                System.out.print(a[i][j]+"   ");
            }
            System.out.print("|"+b[i]+"\n");
        }

    }
    void rowOperation()
    {
        float pointer=a[0][0];
        int row =1;
        while (pointer!=a[noOfEquation-1][noOfEquation-1])
        {

            for (int i = row; i <noOfEquation ; i++)
            {
                float multiplier=a[i][row-1]/pointer;

                for (int j = 0; j < noOfEquation; j++)
                {
                    a[i][j]=a[i][j]-multiplier*a[row-1][j];
                }
                b[i]-=b[row-1]*multiplier;

            }
            printMatrix();
            System.out.println();
            pointer=a[row][row];
            row++;
        }
    }
}
