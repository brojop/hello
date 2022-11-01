/**
 * Author: Brandon Rojop
 * Date: 10/27/22
*/


/**
 * In the string s, the characters that correspond with oldChar
 * will be replaced with the character in newChar
*/
void replaceChar(char *s, char oldChar, char newChar);

/**
 * Creates a copy of the string s, but in instances where a character
 * corresponds with 'oldChar', it will get replaced with 'newChar'
*/
char * replaceCharCopy(const char *s, char oldChar, char newChar);

/**
 * Takes string s and removes all instances where a charcter in the
 * string corresponds to 'c'
*/
void removeChar(char *s, char c);

/**
 * creates a copy of the string but removes all instances
 * where 'c' appears in the string
*/
char * removeCharCopy(const char *s, char c);

/**
 * Takes the string s and splits the characters into an array
 * of multiple strings all of size 'n'
*/
char **lengthSplit(const char *s, int n);