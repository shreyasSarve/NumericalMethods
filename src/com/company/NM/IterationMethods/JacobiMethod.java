package com.company.NM.IterationMethods;



import java.util.Arrays;
import java.util.Scanner;
/*
4 1 1  2
1 5 2 -6
1 2 3 -4      */
/*
        0.5 -0.5 -0.5
*/
public class JacobiMethod {
    public static void main(String[] args) {
        int noOfEquations;


        Scanner scan=new Scanner(System.in);
        System.out.print("How Many Equations--> ");
        noOfEquations=scan.nextByte();

        float[] x=new float[noOfEquations];
        float[][] a=new float[noOfEquations][noOfEquations];
        float[] b=new float[noOfEquations];
        int iterations;
        System.out.println("""
                Enter Matrix in Augmented form like
                2 1 1 10
                3 2 3 18
                1 4 9 16""");
        System.out.println("Enter Matrix-> ");
            for (int i = 0; i <noOfEquations; i++) {
                for (int j = 0; j < noOfEquations; j++) {
                    a[i][j] = scan.nextFloat();
                }
             b[i]=scan.nextFloat();
            }
        System.out.println();
        for (int i = 0; i < noOfEquations; i++) {
            for (int j = 0; j < noOfEquations; j++) {
                System.out.print(a[i][j] + "X" + (j + 1) + " + ");
            }
            System.out.print("="+b[i]);
            System.out.println();
        }
        System.out.print("Enter total no of Iterations you want to Perform --> ");
            iterations=scan.nextByte();
        System.out.print("Enter Initials(Initial Approximations)");
        for (int i = 0; i <noOfEquations; i++) {
            x[i]=scan.nextFloat();
        }

        int iteration=0;


        while (iteration<=iterations)
        {
            float[] temp =Arrays.copyOf(x,noOfEquations);

            System.out.println();
            for (int i = 0; i < noOfEquations; i++)
            {
                System.out.print(temp[i]+"  ");
            }
            x=Arrays.copyOf(b,noOfEquations);                   //x=b;//x will refer to the same address as b;
            System.out.println("\nIteration no->"+iteration);
            for (int i = 0; i < noOfEquations; i++) {
                for (int j = 0; j < noOfEquations; j++) {
                    if(j!=i)
                        x[i]=x[i]-a[i][j]*temp[j];
                }
                x[i]=x[i]/a[i][i];
            }

            for (int i = 0; i < noOfEquations; i++) {
                System.out.println("x"+(i+1)+"="+" "+x[i]);
            }
         iteration++;

        }




    }
}
