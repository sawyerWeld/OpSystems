#include <stdio.h>
#include <ctype.h>
#include <pthread.h>
#include "sudoku.h"

int board[9][9]; // [column][row]

int main()
{    
	printf("\n%s\n\n", "Multithreaded Sudoku Verification");

	populate(); // uses a solved board
	check();

	populateUnsolved(); // uses an unsolved board
    check();
}

int check() {
	// rows
	int r = 0;
	pthread_t rows_thread;
	pthread_create(&rows_thread, NULL, checkRows, &r);
	
	// cols
	int c = 0;
	pthread_t cols_thread;
	pthread_create(&cols_thread, NULL, checkCols, &c);

	// squares (the main thread)
	int sq = checkSqr();

	pthread_join(rows_thread, NULL);
	pthread_join(cols_thread, NULL);
	
	char* status = (r == 1 && c == 1 && sq == 1) ? "YES" : "NO";
	printf("\n\n%s %s\n\n", "Is this puzzle solved?", status);
}

void* checkRows(void *arg) {
	int c = 1;
	for (int i = 0; i < 9; i++) {
		int nums[] = {0,0,0,0,0,0,0,0,0};
		for (int j = 0; j < 9; j++) {
			int cur = board[j][i];
			if (nums[cur-1] == 1) {c = 0; break;}
			nums[cur-1]++;
		}
		if (c == 0) {break;}
	}
	int *row_ptr = (int *) arg;
	*row_ptr = c;
}

void* checkCols(void *arg) {
	int c = 1;
	for (int i = 0; i < 9; i++) {
		int nums[] = {0,0,0,0,0,0,0,0,0};
		for (int j = 0; j < 9; j++) {
			int cur = board[i][j];
			if (nums[cur-1] == 1) {c = 0; break;}
			nums[cur-1]++;
		}
		if (c == 0) {break;}
	}
	int *col_ptr = (int *) arg;
	*col_ptr = c;
}

int checkSqr() {
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++) {
			if (checkSquare(i,j) != 1) {return 0;} 
		}
	return 1;
}

int checkSquare(int r, int c) {
	int nums[] = {0,0,0,0,0,0,0,0,0};
	for (int i = r; i < 9; i += 3) {
		for (int j = c; j < 9; j += 3) {
			int cur = board[i][j];
			if (nums[cur-1] == 1)
				return 0;
		}
	}
	return 1;
}

int populate() {
	FILE* myfile = fopen("sudo.txt","r");
	int c;
	int col = 0;
	int row = 0;
	while ((c = getc(myfile)) != EOF) {
		printf("%c",c);
		if (isdigit(c)) {
			board[row][col] = c - '0';
			col++;
			if (col == 9) {
				col = 0;
				row ++;
			}
		}
	}
}

int populateUnsolved() {
	for (int i = 0; i < 9; i++) {
    	for (int j = 0; j < 9; j++){
    		board[i][j] = i+1;
    		printf("%d ", i+1);
    	}
    	printf("\n");
	}
}
