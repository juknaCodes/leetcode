#include <iostream>
#include <vector>

using namespace std;
double findMaxAverage(vector<int>& nums, int k);

void main() {
	int a[] = { 4,2,1,3,3 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	findMaxAverage(A, 2);
}

double findMaxAverage(vector<int>& nums, int k) {
	int size = nums.size();
	if (k > size) return -1;

	int sum = 0;
	for (int i = 0; i < k;i++) {
		sum += nums[i];
	}
	int max_sum = sum;
	for (int i = k;i < size;i++) {
		sum = sum + nums[i] - nums[i - k];
		if (sum > max_sum) {
			max_sum = sum;
		}
	}

	return (double)max_sum/k;
}