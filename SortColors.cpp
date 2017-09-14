#include <iostream>
#include <vector>

using namespace std;

void sortColors(vector<int> &A);

void  main() {
	int A[] = { 0 ,1, 2, 0, 1, 2 };
	vector<int>myInt(A, A + sizeof(A) / sizeof(int));
	sortColors(myInt);
}

void sortColors(vector<int> &A) {
	int i=0,j,k = A.size()-1;
	for (;i < k;i++) {
		if (A[i] != 0) {
			break;
		}
	}
	j = i;
	for (;i <= k;i++) {
		if (A[i] == 0) {
			int temp = A[j];
			A[j] = A[i];
			A[i] = temp;
			j++;
		}
		else if (A[i] == 2) {
			int temp = A[k];
			A[k] = A[i];
			A[i] = temp;
			k--;
			i--;
		}
	}
}