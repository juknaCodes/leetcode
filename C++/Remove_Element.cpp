#include <iostream>
#include <vector>

using namespace std;
int removeElement(vector<int>& nums, int val);

void main() {
	int a[] = { 4,0,2,0,8,0,3,1 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	removeElement(A, 0);
}

int removeElement(vector<int>& nums, int val) {
	int index = 0;
	for (int i = 0;i<nums.size();i++) {
		if (nums[i] != val) {
			nums[index++] = nums[i];
		}
	}
	return index;

}