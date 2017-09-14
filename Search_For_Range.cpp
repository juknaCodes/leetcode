#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int binarySearch(const vector<int> &A, int B, int start, int end);
vector<int> searchRange(vector<int> &A, int B);

void main() {
	int A[] = { 5, 7, 8,8,8,8, 8, 8, 9,10 };
	vector<int> myInt(A, A + sizeof(A) / sizeof(int));
	searchRange(myInt, 8);
}

int binarySearch(vector<int>& nums, int target, int left, int right) {
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		else if (nums[mid] > target) {
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	return -1;
}
vector<int> searchRange(vector<int>& nums, int target) {
	int index = binarySearch(nums, target, 0, nums.size() - 1);
	vector<int> range(2, -1);
	if (index == -1) {
		return range;
	}
	int leftIndex = index;
	while (1) {
		int currentIndex = binarySearch(nums, target, 0, leftIndex - 1);
		if (currentIndex == -1) {
			break;
		}
		if (currentIndex < leftIndex) {
			leftIndex = currentIndex;
		}
	}
	range[0] = leftIndex;
	int rigthIndex = index;
	while (1) {
		int currentIndex = binarySearch(nums, target, rigthIndex + 1, nums.size() - 1);
		if (currentIndex == -1) {
			break;
		}
		if (currentIndex > rigthIndex) {
			rigthIndex = currentIndex;
		}
	}
	range[1] = rigthIndex;
	return range;
}