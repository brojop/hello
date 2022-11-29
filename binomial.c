#include <stdio.h>
#include <stdlib.h>

#include "binomial.h"

long choose(int n, int k) {
    if(k == n || k == 0) {
        return 1;
    } else {
        return (choose(n - 1, k - 1) + choose(n - 1, k));
    }
}

long chooseMemoization(int n, int k, long **array) {
    if(n < 0 || k < 0 || array == NULL){
        return 1;
    }
    if(array[n][k] != -1) {
        return array[n][k];
    } else {
        long solution = (chooseMemoization(n - 1, k - 1, array) + chooseMemoization(n - 1, k, array));
        array[n][k] = solution;
        return solution;
    }
    free(array);

}

