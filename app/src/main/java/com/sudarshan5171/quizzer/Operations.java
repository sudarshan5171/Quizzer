package com.sudarshan5171.quizzer;

import java.util.Random;

public class Operations {

    int minValue, maxValue;
    public Operations() {
    }
    public Operations(int minVal,int maxVal)
    {
        this.maxValue=maxVal;
        this.minValue=minVal;
    }

    QuestionData nextMultiplicationProblem()
    {
        int a,b;
        String[] options = new String[4];
        Random rand = new Random();
        a=rand.nextInt(maxValue)+2;
        b=rand.nextInt(maxValue)+2;

        String prod = String.valueOf(a)+" x "+String.valueOf(b)+"= ?";
        int correctOption=rand.nextInt(4);

        for(int i=0;i<4;i++)
        {
            if(i!=correctOption)
            {
                int val1 = rand.nextInt(a+2)+a-1;
                int val2 = rand.nextInt(b+2)+b-1;
                options[i] = String.valueOf(val1*val2);
            }
            else
            {
                options[i] = String.valueOf(a*b);
            }
        }

        return new QuestionData(prod,options[0],options[1],options[2],options[3],String.valueOf(a*b));
    }
    QuestionData nextSumProblem()
    {
        int a,b;
        String[] options = new String[4];
        Random rand = new Random();
        a=rand.nextInt(maxValue)+minValue;
        b=rand.nextInt(maxValue)+minValue;

        String prod = String.valueOf(a)+" + "+String.valueOf(b)+"= ?";
        int correctOption=rand.nextInt(4);

        for(int i=0;i<4;i++)
        {
            if(i!=correctOption)
            {
                int val1 = rand.nextInt(maxValue)+minValue;
                int val2 = rand.nextInt(maxValue)+minValue;
                options[i] = String.valueOf(val1+val2);
            }
            else
            {
                options[i] = String.valueOf(a+b);
            }
        }
        return new QuestionData(prod,options[0],options[1],options[2],options[3],String.valueOf(a+b));
    }
    QuestionData nextTablesProblem()
    {
        int a,b;
        String[] options = new String[4];
        Random rand = new Random();
        a=rand.nextInt(10)+1;
        b=maxValue;

        String prod = String.valueOf(a)+" x "+String.valueOf(b)+"= ?";
        int correctOption=rand.nextInt(4);

        for(int i=0;i<4;i++)
        {
            if(i!=correctOption)
            {
                int val1 = rand.nextInt(maxValue)+minValue;
                int val2 = rand.nextInt(maxValue)+minValue;
                options[i] = String.valueOf(val1*val2);
            }
            else
            {
                options[i] = String.valueOf(a*b);
            }
        }

        return new QuestionData(prod,options[0],options[1],options[2],options[3],String.valueOf(a*b));
    }
    QuestionData nextSquareProblem()
    {
        int a,b;
        String[] options = new String[4];
        Random rand = new Random();
        a=rand.nextInt(maxValue)+2;

        String prod = String.valueOf(a)+" x "+String.valueOf(a)+"= ?";
        int correctOption=rand.nextInt(4);

        for(int i=0;i<4;i++)
        {
            if(i!=correctOption)
            {
                int val1 = rand.nextInt(a+2)+a-1;
                int val2 = rand.nextInt(a+4)+minValue;
                options[i] = String.valueOf(val1*val2);
            }
            else
            {
                options[i] = String.valueOf(a*a);
            }
        }

        return new QuestionData(prod,options[0],options[1],options[2],options[3],String.valueOf(a*a));    }
}
