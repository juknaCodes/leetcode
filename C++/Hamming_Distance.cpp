#include <iostream>

using namespace std;
int hammingDistance(int x, int y);

void main() {
	hammingDistance(2,3);
}

int hammingDistance(int x, int y) {
	int xored = x ^y;
	int count = 0;
	while (xored) {
		xored = xored & (xored - 1);
		count++;
	}
	return count;
}