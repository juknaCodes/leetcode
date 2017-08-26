#include <iostream>
#include <vector>

using namespace std;
vector<int> singleNumber(vector<int>& nums);

void main() {
	int a[] = { 2,1,2,3,4,1 };
	vector<int>A(a, a + sizeof(a) / sizeof(int));
	singleNumber(A);
}

vector<int> singleNumber(vector<int>& nums) {
	int xored = 0;
	for (int i = 0;i<nums.size();i++) {
		xored ^= nums[i];
	}
	xored &= ~(xored - 1);

	vector<int> result(2, 0);

	for (int i = 0;i<nums.size();i++) {
		if (nums[i] & xored) {
			result[0] ^= nums[i];
		}
		else {
			result[1] ^= nums[i];
		}
	}
	return result;

}