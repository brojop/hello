/**
 * Author(s): Brandon Rojop, Jordyn Cheyney
 * Date: September 15, 2022
 *
 * This program will compute the new balance, contribution and monthly
 * interest earned on a 401k plan with adujstments made due to inflation.
 *
 * */
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main(int argc, char **argv) {

    if(argc != 6) {
        printf("ERROR: invalid number of inputs\n");
        printf("Usage: initial balance, monthly contribution amount, average annual rate of return on scale [0,1]\n");
        printf("average annual rate of inflation on scale [0,1], number of years until retirement\n");
    }


    double initialBalance = atof(argv[1]);
    double monthlyContribution = atoi(argv[2]);
    double avgReturnRate = atof(argv[3]);
    double avgInflationRate = atof(argv[4]);
    int numYears = atoi(argv[5]);

    if(monthlyContribution * 12 > 18500) {
        printf("Illegal: monthly contributions exceed $18,500 annual limit\n");
    }
    else if(0 > avgReturnRate || avgReturnRate > 1) {
        printf("ERROR: return rate is on the scale of [0,1]\n");
    }
    else if(0 > avgInflationRate || avgInflationRate > 1) {
        printf("ERROR: inflation rate is on the scale of [0,1]\n");
    }
    else if(initialBalance < 0 || monthlyContribution < 0 || numYears < 0) {
        printf("Illegal input: values can not be negative\n");
    }

    else {

    printf("Month     ");
    printf("Interest      ");
    printf("Balance\n");


    double interest, monthlyInterest;
    double totalBalance = initialBalance;
    int months = numYears * 12;
    double totalInterest = 0;

    monthlyInterest = ((1 + avgReturnRate)/(1 + avgInflationRate) - 1)/12;

    monthlyContribution = round(monthlyContribution * 100) / 100;

    for(int i = 1; i <= months; i++) {
        interest = totalBalance * monthlyInterest;
        interest = round(interest * 1000) / 1000;

        totalInterest = totalInterest + interest;


        totalBalance = interest + totalBalance + monthlyContribution;
        printf("%5d $ %10.2f $ %10.2f\n", i, interest, totalBalance);
    }

    printf("Total Interest Earned: $ %10.2f\n", totalInterest);
    printf("Total Nest Egg: $ %10.2f\n", totalBalance);
    }


    return 0;
}