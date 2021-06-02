package com.company.NM.MatrixSolvation;

import com.company.NM.Printer;

import java.util.Arrays;
import java.util.Scanner;

public class GaussJordanMethod {

    int noOfEquations;
    float[][] gaussMatrix;
    float[] b;
    static public  void main(String[] args) {
        System.out.println("Total no of Equations--> ");

        GaussJordanMethod gjMethod=new GaussJordanMethod(new Scanner(System.in).nextByte());
        GaussEliminationMethod gaussMethod=new GaussEliminationMethod(gjMethod.noOfEquations);
        gaussMethod.setMatrix();
        gaussMethod.printMatrix();
        gaussMethod.rowOperation();
        gjMethod.gaussMatrix=gaussMethod.a;
        gjMethod.b=gaussMethod.b;
        gjMethod.gaussJordanOperations();
        gaussMethod.backSubstitution(gjMethod.gaussMatrix, gjMethod.b, gjMethod.noOfEquations );

    }
    public GaussJordanMethod(int noOfEquations)
    {
        this.noOfEquations=noOfEquations;
    }

    public void gaussJordanOperations()
    {

        int row=noOfEquations;
        float pointer=gaussMatrix[noOfEquations-1][noOfEquations-1];

        while (pointer!=gaussMatrix[0][0])
        {

            for (int i = row-2; i>=0; i--) {

                float multiplier=gaussMatrix[i][row-1]/pointer;
                for (int j = 0; j < noOfEquations; j++)
                {

                    gaussMatrix[i][j]-=gaussMatrix[row-1][j]*multiplier;
                }

                b[i]=b[i]-b[row-1]*multiplier;
            }
            pointer=gaussMatrix[row-2][row-2];
            row--;
        }
        System.out.println();
     new Printer().display(gaussMatrix,b,noOfEquations);


    }


}
