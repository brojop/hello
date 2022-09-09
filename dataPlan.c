/*
Author(s): Brandon Rojop, Jordyn Cheyney

This program will help customers of a mobile service provider, track their data usage over the course of their phone plan
*/
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {

    if(argc != 4) {
        printf("ERROR: invalid number of command line inputs\n");
        printf("Usage: number of GB provided, days since plan started, number of GB used.\n");
    }

   int gbProvided = atoi(argv[1]);
   int daysIntoPlan = atoi(argv[2]);
   double gbUsed = atof(argv[3]);

    int daysRemaining;
    double averageUse, expectedAverage, exceedAmount, whenExceeding, shortAmount, whenShort;
        daysRemaining = 30 - daysIntoPlan;
        averageUse = gbUsed/daysIntoPlan;
        expectedAverage = gbProvided / 30.0;
        exceedAmount = (averageUse * daysRemaining) - (gbProvided - gbUsed) ;
        whenExceeding = (gbProvided - gbUsed) / daysRemaining;
        shortAmount = (gbProvided - gbUsed) - (averageUse * daysRemaining);
        whenShort = (gbProvided - gbUsed) / daysRemaining;

    printf("%d days used, %d days remaining.\n", daysIntoPlan, daysRemaining);
    printf("Average daily use: %.2f GB/day.\n\n", averageUse);

    if (gbUsed > gbProvided) {
        printf("You have reached the maximum limit allowed by your phone plan\nand you have amassed charges due to the excess data used.\n");


     } else if(averageUse > expectedAverage) {
        printf("You are EXCEEDIDNG your average daily use (%.2f GB/day).\n", expectedAverage);
        printf("Continuing this high usage, you'll exceed your data plan by \n%.2f GB.\n\n", exceedAmount);
        printf("To stay below your data plan, use no more than %.2f GB/day.\n", whenExceeding);


    } else if (averageUse < expectedAverage) {
        printf("You are FALLING SHORT OF your average daily use (%.2f GB/day).\n", expectedAverage);
        printf("Continuing this low usage, you'll fall short of your data plan by \n%.2f GB.\n\n", shortAmount);
        printf("To ensure you maximize data usage, you should use approximately %.2f GB/day.\n", whenShort);


    } else if (averageUse == expectedAverage) {
        printf("You are USING the exact amount of your average daily use (%.2f GB/day).\n", expectedAverage);
        printf("Continuing this usage, you will use all of your data plan evenly \nthroughout the duration of the plan.\n\n");
        printf("To continue using your data efficiently, continue to use %.2f GB/day.\n", expectedAverage);
    }

    return 0;
}