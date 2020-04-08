#include <iostream>
#include <vector>

using namespace std;
vector<int> productExceptSelf(vector<int>& nums);

void main() {

}

vector<int> productExceptSelf(vector<int>& nums) {
	vector<int> prod(nums.size(), 0);
	int temp = 1;
	for (int i = 0;i<nums.size();i++) {
		prod[i] = temp;
		temp *= nums[i];
	}

	temp = 1;
	for (int i = nums.size() - 1;i >= 0;i--) {
		prod[i] *= temp;
		temp *= nums[i];
	}
	return prod;
}