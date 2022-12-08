#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdio.h>

#include "airport.h"

Airport* createAirport(const char* gpsId, const char* type, const char* name, double latitude, double longitude, int elevationFeet, const char* city, const char* countryAbbrv) {
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
    char *string = (char *)malloc(sizeof(char) * 100);
    sprintf(string,"%s %s %s %f %f %d %s %s\n",a->gpsId,a->type,a->name,a->latitude,a->longitude,a->elevationFeet,a->city,a->countryAbbrv);

    return string;
}

double getAirDistance(const Airport* origin, const Airport* destination) {

    double latitude1 = origin->latitude;
    double longitude1 = origin->longitude;
    double latitude2 = destination->latitude;
    double longitude2 = destination->longitude;

    latitude1 = (latitude1/180) * M_PI;
    latitude2 = (latitude2/180) * M_PI;
    longitude1 = (longitude1/180) * M_PI;
    longitude2 = (longitude2/180) * M_PI;

    double airDistance = acos(sin(latitude1) * sin(latitude2) + cos(latitude1) * cos(latitude2) * cos(longitude2 - longitude1)) * 6371;

    return airDistance;
}

double getEstimatedTravelTime(const Airport* stops,
                              int size,
                              double aveKmsPerHour,
                              double aveLayoverTimeHrs) {

    double travelTime = 0;
    double distance = 0 ;

    for(int i = 0; i < size - 1; i++) {
        distance = getAirDistance(&stops[i], &stops[i + 1]);
    }

    travelTime = (distance / size) + (aveLayoverTimeHrs * size);

    return travelTime;
}

int cmpByGPSId(const void* a, const void* b) {
    const Airport *x = (const Airport *)a;
    const Airport *y = (const Airport *)b;
    int result  = strcmp(x->gpsId, y->gpsId);

    return result;
}

int cmpByType(const void* a, const void* b) {
    const Airport *x = (const Airport *)a;
    const Airport *y = (const Airport *)b;
    int result = strcmp(x->type, y->type);

    return result;
}

int cmpByName(const void* a, const void* b) {
    const Airport *x = (const Airport *)a;
    const Airport *y = (const Airport *)b;
    int result = strcmp(x->name, y->name);
    return result;
}

int cmpByNameDesc(const void* a, const void* b) {
    const Airport *x = (const Airport *)a;
    const Airport *y = (const Airport *)b;
    int result = strcmp(x->name, y->name);
    return result;
}

int cmpByCountryCity(const void* a, const void* b) {
    const Airport *x = (const Airport *)a;
    const Airport *y = (const Airport *)b;

    if(strcmp(x->countryAbbrv, y->countryAbbrv) == 0) {
        return strcmp(x->city, y->city);
    } else {
        return strcmp(x->countryAbbrv, y->countryAbbrv);
    }

}

int cmpByLatitude(const void* a, const void* b) {
    const Airport *x = (const Airport*)a;
    const Airport *y = (const Airport*)b;

    double x_latitude = x->latitude;
    double y_latitude = y->latitude;

    if(x_latitude > y_latitude) {
        return 1;
    } else if(x_latitude == y_latitude) {
        return 0;
    } else {
        return -1;
    }
}

int cmpByLongitude(const void* a, const void* b) {
    const Airport *x = (const Airport*)a;
    const Airport *y = (const Airport*)b;

    double x_longitude = x->longitude;
    double y_longitude = y->longitude;

    if(x_longitude > y_longitude) {
        return 1;
    } else if(x_longitude == y_longitude) {
        return 0;
    } else {
        return -1;
    }
}

int cmpByLincolnDistance(const void* a, const void* b) {

    const Airport *x = (const Airport*)a;
    const Airport *y = (const Airport*)b;

    Airport *lincoln = createAirport("2400 W Adams St, Lincoln, NE 68524" , "public", "Lincoln Municipal Airport", 40.846176, -96.75471, 940, "lincoln", "US");

    double xDistance = getAirDistance(x, lincoln);
    double yDistance = getAirDistance(y, lincoln);

    if(xDistance > yDistance) {
        return 1;
    } else if(xDistance == yDistance) {
        return 0;
    } else {
        return -1;
    }
}

void generateReports(Airport *airports, int n) {
    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByGPSId);
    printf("Sorted by: cmpByGPSId\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByType);
    printf("Sorted by: cmpByType\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByName);
    printf("Sorted by: cmpByName\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByNameDesc);
    printf("Sorted by: cmpByNameDesc\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByCountryCity);
    printf("Sorted by: cmpByCountryCity\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByLatitude);
    printf("Sorted by: cmpByLatitude\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByLongitude);
    printf("Sorted by: cmpByLongitude\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }
    qsort(airports, sizeof(Airport), n, cmpByLincolnDistance);
    printf("Sorted by: cmpByLincolnDistance\n");

    for(int i = 0; i < n; i++) {
        printf("%s\n", airportToString(&airports[i]));
    }


}