#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "string_utils.c"

int main(int argc, char **argv) {

    int size = 100;

    char * expectedResult = (char *) malloc(sizeof(char) * size);
    char * actualResult = (char *) malloc(sizeof(char) * size);

    char * string = (char *) malloc(sizeof(char) * size);

    int numPassed = 0;
    int numFailed = 0;

/**
    strcpy(string, 'abc abc abc abc abc');

    expectedResult = 'abd abd abd abd abd';
    actualResult = replaceChar(string, 'c', 'd');

    if(actualResult == expectedResult) {
        printf("PASSED!");
        numPassed++;
    } else if (actualResult != expectedResult) {
        printf("FAILED");
        numFailed++;
    }



    string = 'Pubie';

    expectedResult = 'Hubie';
    actualResult = replaceChar(string, 'p', 'h');

    if(actualResult == expectedResult) {
        printf("PASSED!");
    } else {
        printf("FAILED");
    }



    string = 'abcabcabcabcabc';

    expectedResult = 'abdabdabdabdabd';
    actualResult = replaceChar(string, 'c', 'd');

    if(actualResult == expectedResult) {
        printf("PASSED!");
    } else {
        printf("FAILED");
    }
*/


    strcpy(*string, 'abd abd abd abd abd');

    strcpy(cdexpectedResult, 'abc abc abc abc abc');
    actualResult = replaceCharCopy(string, 'd', 'c');

    if(actualResult == expectedResult) {
        printf("PASSED!");
        numPassed++;
    } else if(actualResult != expectedResult) {
        printf("FAILED");
        numFailed++;
    }



    printf("Number passed: %d\n", numPassed);
    printf("Number failed: %d\n", numFailed);



    return 0;
}