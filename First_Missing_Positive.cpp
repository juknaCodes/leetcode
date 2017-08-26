#include <iostream>
#include <vector>

using namespace std;
int firstMissingPositive(vector<int>& A);

void main() {
	int a[] = { 2,1 };
	vector<int>A(a, a + sizeof(a) / sizeof(int));
	firstMissingPositive(A);
}

int firstMissingPositive(vector<int>& A) {
	int size = A.size();
	for (int i = 0;i<A.size();i++) {
		if (A[i] <= 0 || A[i] > size)continue;
		int pos = A[i] - 1;
		if (A[pos] != A[i]) {
			int temp = A[pos];
			A[pos] = A[i];
			A[i] = temp;
			i--;
		}
	}

	for (int i = 0;i<size;i++) {
		if (A[i] != i + 1)return i + 1;
	}
	return size + 1;
}