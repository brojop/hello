#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char rnaToProtein(const char *rna) {
  if(rna == NULL || strlen(rna) != 3) {
    return 0;
  }
FILE *translation = fopen(rna, "r");
    if(translation == NULL) {
        return 0;
    }
     char tempBuffer[150];

    char **line = (char **) malloc(sizeof(char) * 1000);
    *line = fgets(tempBuffer, 150, translation);

    fclose(translation);

}

int main(int argc, char **argv) {





    if(argc != 3) {
        printf("ERROR: invalid number of command line inputs\n");
        printf("You dont have the write characters in your string\n");
    }

   char inputFile = atol(argv[1]);
   char outputFile = atol(argv[2]);



  return 0;
}