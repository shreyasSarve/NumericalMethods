package com.company.NM.MatrixSolvation;

import java.util.Arrays;
import java.util.Scanner;

public class GaussJordanMethod {

    int noOfEquations;
    float[][] gaussMatrix;
    float[] b;
    public  void main(String[] args) {
        System.out.println("Total no of Equations--> ");
        GaussJordanMethod gjMethod=new GaussJordanMethod(new Scanner(System.in).nextByte());
        GaussEliminationMethod gaussMethod=new GaussEliminationMethod(gjMethod.noOfEquations);
        gaussMethod.setMatrix();
        gaussMethod.printMatrix();
        gaussMethod.rowOperation();
        gjMethod.gaussMatrix=gaussMethod.a;
        System.out.println(Arrays.deepToString(gaussMatrix));
        gjMethod.b=gaussMethod.b;
        gjMethod.gaussJordanOperations();

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
            for (int i = 0; i < noOfEquations; i++) {
                float multiplier=gaussMatrix[i][row-1]/pointer;
                for (int j = 0; j < noOfEquations; j++)
                {
                    gaussMatrix[i][j]-=gaussMatrix[row-1][j]*multiplier;
                }
                b[i]=b[i]-b[row-1]*multiplier;
            }
        }
        System.out.println("Hello");
        System.out.println(Arrays.deepToString(gaussMatrix));
    }


}
