#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

#include "airport.h"

Airport* createAirport(const char* gpsId,
                       const char* type,
                       const char* name,
                       double latitude,
                       double longitude,
                       int elevationFeet,
                       const char* city,
                       const char* countryAbbrv) {
    Airport *a = (Airport *)malloc(sizeof(Airport) + 1);

    a->gpsId = (char *)malloc(sizeof(char) * (strlen(gpsId) + 1));
    strcpy(a->gpsId, gpsId);

    a->type = (char *)malloc(sizeof(char) * (strlen(type) + 1));
    strcpy(a->type, type);

    a->name = (char *)malloc(sizeof(char) * (strlen(name) + 1));
    strcpy(a->name, name);

    a->latitude = latitude;

    a->longitude = longitude;

    a->elevationFeet = elevationFeet;

    a->city = (char *)malloc(sizeof(char) * (strlen(city) + 1));
    strcpy(a->city, city);

    a->countryAbbrv = (char *)malloc(sizeof(char) * (strlen(countryAbbrv) + 1));
    strcpy(a->countryAbbrv, countryAbbrv);

    return a;
}

void initAirport(Airport* airport,
                 const char* gpsId,
                 const char* type,
                 const char* name,
                 double latitude,
                 double longitude,
                 int elevationFeet,
                 const char* city,
                 const char* countryAbbrv) {
    airport->gpsId = (char *)malloc(sizeof(char) * (strlen(gpsId) + 1));
    strcpy(airport->gpsId, gpsId);

    airport->type = (char *)malloc(sizeof(char) * (strlen(type) + 1));
    strcpy(airport->type, type);

    airport->name = (char *)malloc(sizeof(char) * (strlen(name) + 1));
    strcpy(airport->name, name);

    airport->latitude = latitude;

    airport->longitude = longitude;

    airport->elevationFeet = elevationFeet;

    airport->city = (char *)malloc(sizeof(char) * (strlen(city) + 1));
    strcpy(airport->city, city);

    airport->countryAbbrv = (char *)malloc(sizeof(char) * (strlen(countryAbbrv) + 1));
    strcpy(airport->countryAbbrv, countryAbbrv);

    return;
}

char* airportToString(const Airport* a) {
    char **string = (char **)malloc(sizeof(char*) * 100);

    string[0] = a->gpsId;
    string[1] = a->type;
    string[2] = a->name;
    *string[3] = a->latitude;
    *string[4] = a->longitude;
    *string[5] = a->elevationFeet;
    string[6] = a->city;
    string[7] = a->countryAbbrv;

    return *string;
}

double getAirDistance(const Airport* origin, const Airport* destination){


    return 0;
}

double getEstimatedTravelTime(const Airport* stops,
                              int size,
                              double aveKmsPerHour,
                              double aveLayoverTimeHrs) {


    return 0;
}