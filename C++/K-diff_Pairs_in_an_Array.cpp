#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;
int findPairs(vector<int>& nums, int k);

void main() {
	int a[] = { 1, 3, 1, 5, 4 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	findPairs(A, 0);

}

int binarySearch(vector<int>& nums, int low, int high, int target) {
	while (low <= high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		else if (target < nums[mid]) {
			high = mid - 1;
		}
		else {
			low = mid + 1;
		}
	}
	return -1;
}

int findPairs(vector<int>& nums, int k) {
	//Approach 1
	//unordered_map<int, int> pairs;
	//int count = 0;

	//for (int i = 0;i < nums.size();i++) {
	//	if (pairs.find(nums[i] - k) != pairs.end()) {
	//		count++;
	//	} 

	//	if (pairs.find(nums[i] + k) != pairs.end()) {
	//		count++;
	//	}

	//	if (pairs.find(nums[i]) == pairs.end()) {
	//		pairs[nums[i]] = i;
	//	}

	//}
	//return count;
	if (k < 0) return 0;
	sort(nums.begin(), nums.end());
	int count = 0;
	for (int i = 0;i < nums.size();i++) {
		if (i > 0 && nums[i] == nums[i - 1]) {
			continue;
		}
		if (k != 0) {
			if (binarySearch(nums, i + 1, nums.size() - 1, nums[i] + k) != -1) {
				count++;
			}

			if (binarySearch(nums, i + 1, nums.size() - 1, nums[i] - k) != -1) {
				count++;
			}
		}
		else {
			if (binarySearch(nums, i + 1, nums.size() - 1, nums[i]) != -1) {
				count++;
			}
		}

	}
	return count;
}