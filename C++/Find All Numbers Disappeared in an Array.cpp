#include <iostream>
#include <vector>

using namespace std;
vector<int> findDisappearedNumbers(vector<int>& nums);

void main() {
	int a[] = { 4,3,2,7,8,2,3,1 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	findDisappearedNumbers(A);
}

vector<int> findDisappearedNumbers(vector<int>& nums) {
	//vector<int> numbers(nums.size(), 0);
	//for(int i=0;i< nums.size();i++){
	//numbers[nums[i]-1] = 1;
	//}
	//vector<int> result;
	//for(int i=0;i< numbers.size();i++){
	//if (numbers[i] == 0) {
	//result.push_back(i+1);
	//}
	//}
	//return result;
	for (int i = 0;i<nums.size();i++) {
		int m = abs(nums[i]) - 1; // index start from 0
		nums[m] = nums[m]>0 ? -nums[m] : nums[m];
	}
	vector<int> result;
	for (int i = 0;i<nums.size();i++) {
		if (nums[i] > 0) {
			result.push_back(i + 1);
		}
	}

	return result;

}