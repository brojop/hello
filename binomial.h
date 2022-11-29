/**
 * Author: Brandon Rojop
*/

/**
 * This function computes the number of ways to take 'k'
 * items from 'n' using Pascal's rule
*/
long choose(int n, int k);

/**
 * Computes the number of ways to take 'k' items from
 * 'n' using Pascal's rule but uses memoization
 * to store previously calculated values
*/
long chooseMemoization(int n, int k, long **array);