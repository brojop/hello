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

    //how would I read a file when end is unknown?


    char tempBuffer[150];

    char *line = fgets(tempBuffer, 150, in);

    //when end is reached, end the string
    while(line != NULL) {
        line = fgets(tempBuffer, 150, in);
    }


    fclose(in);
    return line;
}


char **getFileLines(const char *filePath, int *numLines) {
    if(filePath == NULL || numLines <= 0) {
        return NULL;
    }

    FILE *in = fopen(filePath, "r");
    if(in == NULL) {
        return NULL;
    }

    char tempBuffer[150];

    char **line = (char **) malloc(sizeof(char) * 1000);
    *line = fgets(tempBuffer, 150, in);

    char *tokens;

    while(line != NULL) {
        int n = strlen(tempBuffer);
        if(tempBuffer[n - 1] == '\n') {
            tempBuffer[n - 1] = '\0';
        }
        int i = 0;
        tokens = strtok(line, "\n");
        i++;
    }



    fclose(in);

    return line;
}
