#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int arrayPairSum(vector<int>& nums);

void main() {
	int a[] = { 1,2,3,4,5,6 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	arrayPairSum(A);
}

int arrayPairSum(vector<int>& nums) {
	sort(nums.begin(), nums.end());
	int sum = 0;
	for (int i = 0;i<nums.size();i += 2) {
		sum += nums[i];
	}
	return sum;
}