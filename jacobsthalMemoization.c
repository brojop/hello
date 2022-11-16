#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>

/**
 * Computes the n-th Jacobsthal number using an iterative
 * method
 */
long long jacobsthalIterative(int n);

long long jacobsthalMemoization(int n, long long *array);
//      Hint: it should return a long long (integers)
//            it should take a cache (array) of long longs as well

/**
 * This program computes the n-th Jacobsthal number using recursion.
 * It also reports how long the program takes to execute.
 *
 */
int main(int argc, char **argv) {

  if (argc != 2) {
    fprintf(stderr, "Usage: %s n\n", argv[0]);
    exit(1);
  }
  int n = atoi(argv[1]);

  long long* table = (long long*)malloc(sizeof(long long) * (n + 1));
  //TODO: set up our table/cache which is of size n + 1 since we
  //compute values from J(0) to J(n) inclusive

  table[0] = 0;
  table[1] = 1;
  for(int i = 2; i < (n + 1); i++) {
    table[i] = -1;
  }

  time_t start, end;
  start = time(NULL);
  long long iterativeResult = jacobsthalIterative(n);

  long long memoizationResult = jacobsthalMemoization(n , table);

  end = time(NULL);

  int time = (end - start);

  printf("Iterative:   Jacobsthal(%d) = %lld\n", n, iterativeResult);
  printf("Memoization: Jacobsthal(%d) = %lld\n", n, memoizationResult);

  printf("Total Computation Time: %d seconds\n", time);

  return 0;
}

long long jacobsthalMemoization(int n, long long *array) {
  if(array[n] != -1) {
    return array[n];
  } else {
    long long solution = jacobsthalMemoization(n - 1, array) + (2 * jacobsthalMemoization(n - 2, array));
    array[n] = solution;
    return solution;
  }

}

long long jacobsthalIterative(int n) {
  if(n <= 1) {
    return n;
  }
  long long prev = 0;
  long long curr = 1;
  for(int i=2; i<=n; i++) {
    long long t = 2 * prev + curr;
    prev = curr;
    curr = t;
  }
  return curr;
}
