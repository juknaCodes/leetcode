#include <iostream>
#include <vector>
#include <string>

using namespace std;
vector<string> summaryRanges(vector<int>& nums);

void main() {
	int a[] = { 0,1,2,4,5,7 };
	vector<int> A(a, a + sizeof(a) / sizeof(int));
	summaryRanges(A);

}

vector<string> summaryRanges(vector<int>& nums) {
	vector<string> result;
	if (nums.size() == 0) {
		return result;
	}
	int rangeStart = nums[0];
	int prev_range_member = rangeStart;
	for (int i = 1;i < nums.size(); i++) {
		if (nums[i] == prev_range_member + 1) {
			prev_range_member = nums[i];
		}
		else {
			string range = to_string(rangeStart);
			if (prev_range_member != rangeStart) {
				range.append("->");
				range.append(to_string(prev_range_member));
			}
			result.push_back(range);
			rangeStart = nums[i];
			prev_range_member = rangeStart;
		}
	}
	string range = to_string(rangeStart);
	if (prev_range_member != rangeStart) {
		range.append("->");
		range.append(to_string(prev_range_member));
	}	
	result.push_back(range);
	return result;
}