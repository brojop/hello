#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "file_utils.h"

char *getFileContents(const char *filePath) {
    if(filePath == NULL) {
        return NULL;
    }

    FILE *in = fopen(filePath, "r");
    if(in == NULL) {
        return NULL;
    }

    char tempBuffer[150];
    char *line = fgets(tempBuffer, 150, in);

    while(line != NULL) {
        line = fgets(tempBuffer, 150, in);
    }


    fclose(in);
    return line;
}


char **getFileLines(const char *filePath, int *numLines) {
    if(filePath == NULL || *numLines <= 0) {
        return NULL;
    }

    FILE *in = fopen(filePath, "r");
    if(in == NULL) {
        return NULL;
    }

    char tempBuffer[150];
    char **line = (char **) malloc(sizeof(char) * 1000);

    while(line != NULL) {
        int n = strlen(tempBuffer);
        *line = fgets(tempBuffer, 150, in);

        if(tempBuffer[n - 1] == '\n') {
            tempBuffer[n - 1] = '\0';
        }

        strcpy(*line, tempBuffer);
    }

    fclose(in);

    return line;
}
