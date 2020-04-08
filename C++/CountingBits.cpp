#include <iostream>
#include <vector>

using namespace std;
vector<int> countBits(int num);
void main() {
	countBits(2);
}

vector<int> countBits(int num) {
	vector<int> result;
	result.push_back(0);
	for (int i = 1;i <= num;i++) {
		int count = 0;
		for (int j = 0;j < 32;j++) {
			if (i&(1 << j)) {
				count++;
			}			
		}
		result.push_back(count);
	}
	return result;
}