
/**
 * Takes the given file and returns the entirety
 * of its contents in one string with
 * endline characters preserved
*/
char *getFileContents(const char *filePath);

/**
 * Takes the given file and returns the entirety of its
 * contents as an array of strings, with each line
 * being one singular element in the array;
 * endline characters are not preserved
*/
char **getFileLines(const char *filePath, int *numLines);