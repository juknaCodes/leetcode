#include <iostream>
#include <vector>

using namespace std;
int removeDuplicates(vector<int>& nums);

void main() {
	//int a[] = { 1,1,1,1,2,2,2,2,3,3,3,4,5 };
	//int a[] = { 1,2,2,2,2,3,3,3,4,5 };
	int a[] = { 1,2,2,2,2,3,3,3,4,5,5,5,5,5 };
	//int a[] = { 1,3,4,5};
	vector<int>A(a, a + sizeof(a) / sizeof(int));
	removeDuplicates(A);
}

int removeDuplicates(vector<int>& nums) {
	int index = 0;
	for (int i = 0;i<nums.size();i++) {
		while (i+1 < nums.size() && nums[i] == nums[i + 1]) {
			i++;
		}
		nums[index++] = nums[i];
	}
	return index;

}