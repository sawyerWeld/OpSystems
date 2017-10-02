#ifndef SUDOKU_H_
#define SUDOKU_H_

int populate();
int populateUnsolved();
void* checkRows(void *arg);
void* checkCols(void *arg);
int checkSqr();
int checkSquare(int c, int r);
int check();
void printStatus();

#endif