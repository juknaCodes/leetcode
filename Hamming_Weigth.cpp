#include <iostream>

using namespace std;
int hammingWeight(uint32_t x);

void main() {
	hammingWeight(2);
}

int hammingWeight(uint32_t n) {
	int count = 0;
	while (n) {
		n = n&(n - 1);
		count++;

	}
	return count;
}