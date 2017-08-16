#include <iostream>
#include <vector>

using namespace std;
vector<int> findDuplicates(vector<int>& nums);

void main() {
	int a[] = { 4,3,2,7,8,2,3,1 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	findDuplicates(A);
}

vector<int> findDuplicates(vector<int>& nums) {
	vector<int> result;
	for (int i = 0;i<nums.size();i++) {
		int m = abs(nums[i]) - 1; // index start from 0
		if (nums[m] > 0) {
			nums[m] *= -1;
		}
		else {
			result.push_back(abs(nums[i]));
		}
	}
	
	return result;

}