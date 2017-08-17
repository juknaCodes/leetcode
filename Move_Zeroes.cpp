#include <iostream>
#include <vector>

using namespace std;
void moveZeroes(vector<int>& nums);

void main() {
	int a[] = { 4,0,2,0,8,0,3,1 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	moveZeroes(A);
}

void moveZeroes(vector<int>& nums) {
	int index = 0;
	for (int i = 0;i<nums.size();i++) {
		if (nums[i] != 0) {
			nums[index++] = nums[i];
		}
	}
	for (int i = index;i<nums.size();i++) {
		nums[i] = 0;
	}
}