#include <iostream>
#include <vector>

using namespace std;
int findDuplicate(vector<int>& nums);

void main() {
	int a[] = { 4,1,2,4,3 };
	vector<int>A(a, a + sizeof(a) / sizeof(int));
	findDuplicate(A);
}

int findDuplicate(vector<int>& nums) {
	int low = 1;
	int high = nums.size() - 1;
	int mid;
	while (low<high) {
		mid = (low + high) / 2;
		int count = 0;
		for (int i = 0;i<nums.size();i++) {
			if (nums[i] <= mid) {
				count++;
			}
		}
		if (count <= mid) {
			low = mid + 1;
		}
		else {
			high = mid;
		}
	}
	return low;

}