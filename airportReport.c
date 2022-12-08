#include <stdlib.h>
#include <string.h>

#include "airport.h"


int main(int argc, char **argv) {
    Airport* JFK = createAirport("New York, NY 11430", "International", "JFK", 40.641766, -73.780968, 13, "New York City", "USA");
    Airport* Tampa = createAirport("4100 George J Bean Pkwy, Tampa, FL 33607", "International", "Tampa International", 41.978611, -87.904724, 26, "Tampa", "USA");
    Airport* Nashville = createAirport("1 Terminal Drive Suite 501, Nashville, TN 37214", "International", "nashville international airport", 36.131687, -86.668823, 599, "Nashville", "USA");
    Airport* Denver = createAirport("8500 Pena Blvd, Denver, CO 80249", "International", "Denver INternatioanl", 39.849312, -104.673828, 5434, "Denver", "USA");
    Airport* Oxford = createAirport("Langford Lane, Oxford OX5 1RA", "International", "London Oxford Airport", 51.836944, -1.32, 5434 "Oxford", "England");
    Airport** airports = (Airport**) malloc(sizeof(Airport*) * 5);
    airports[0] = JFK;
    airports[1] = Tampa;
    airports[2] = Nashville;
    airports[3] = Denver;
    airports[4] = Oxford;
    generateReports(airports,5);
}

