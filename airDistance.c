/*
* Author(s): Brandon Rojop, Jordyn Cheyney
* Date: 09/01/2022
* This program will calculate the air distance between two coordinate points
*
*/

#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main(int argc, char **argv) {

    double latitudeA, longitudeA, latitudeB, longitudeB, airDistance;
    int r;
    r = 6371;

    printf("Enter intial latitude: \n");
    scanf("%lf", &latitudeA);
    printf("Enter initial longitude: \n");
    scanf("%lf", &longitudeA);

    printf("Enter ending latitude: \n");
    scanf("%lf", &latitudeB);
    printf("Enter ending longitude: \n");
    scanf("%lf", &longitudeB);

    printf("    Location Distance\n");
    printf("=========================\n");
    printf("Origin:      (%f, %f) \n", latitudeA, longitudeA);
    printf("Destination: (%f, %f) \n", latitudeB, longitudeB);


    latitudeA = (latitudeA/180) * M_PI;
    latitudeB = (latitudeB/180) * M_PI;
    longitudeA = (longitudeA/180) * M_PI;
    longitudeB = (longitudeB/180) * M_PI;

    airDistance = acos(sin(latitudeA)*sin(latitudeB) + cos(latitudeA)*cos(latitudeB)*cos(longitudeB - longitudeA)) * r;

    printf("Air distance is %lf kms\n", airDistance);

    return 0;
}