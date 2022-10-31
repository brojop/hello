#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#include "string_utils.h"

void replaceChar(char *s, char oldChar, char newChar) {
    if(s == NULL) {
        return;
    }
    for(int i = 0; i < strlen(s); i++) {
        if(s[i] == oldChar) {
            s[i] = newChar;
        }
    }
    return;
}


char * replaceCharCopy(const char *s, char oldChar, char newChar) {
    if(s == NULL) {
        return 0;
    }
    char * stringCopy = (char *) malloc(sizeof(char) * (strlen(s) + 1));

    strcpy(stringCopy, s);
    int x = strlen(s);

    for(int i = 0; i < x; i++) {
        if(stringCopy[i] == oldChar) {
            stringCopy[i] = newChar;
        }
    }


    return stringCopy;
}

void removeChar(char *s, char c) {
    if(s == NULL) {
        return;
    }

    int x = strlen(s);
    for(int i = 0; i < x; i++) {
        if(s[i] == c) {
            for(int j = i; j < x; j++) {
                s[j] = s[j + 1];
            }
        } else {
        }
    }

    return;
}


char * removeCharCopy(const char *s, char c) {
    if(s == NULL) {
        return 0;
    }
    char * stringCopy = (char *) malloc(sizeof(char) * (strlen(s) + 1));
    strcpy(stringCopy, s);

    int x = strlen(s);
    for(int i = 0; i < x; i++) {
        if(stringCopy[i] == c) {
            for(int j = i; j < x; j++) {
                stringCopy[j] = stringCopy[j + 1];
            }
        } else{

        }
    }
    return stringCopy;
}

char **lengthSplit(const char *s, int n) {
    if(s == NULL || n <= 0) {
        return 0;
    }
    while()


    return 0;
}