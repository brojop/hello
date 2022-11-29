#include <stdio.h>
#include <stdlib.h>

#include "binomial.h"
#include "binomial.c"

int main(int argc, char **argv) {
    if(argc != 3) {
        printf("ERROR: need argumens 'n' and 'k'");
    }

    int n = atoi(argv[1]);
    int k = atoi(argv[2]);

    long **table = (long **) malloc(sizeof(long *)* (n + 1));
    for(int i=0; i<n+1;i++) {
        table[i] = (long *) malloc(sizeof(long)* (k + 1));
    }

    for(int i = 0; i < n+1; i++) {
        for(int j = 0; j < k+1; j++) {
            table[i][j] = -1;
        }
        if(n == k || k == 0) {
        table[n][k] = 1;

    }
    }



    long memoizationResult = chooseMemoization(n, k, table);
    long chooseResult = choose(n , k);

    printf("%ld\n", chooseResult);
    printf("%ld\n", memoizationResult);


    return 0;
}