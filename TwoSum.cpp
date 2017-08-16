#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
vector<int> twoSum(vector<int>& nums, int target);

void main() {
	int a[] = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
	vector<int> nums(a, a + sizeof(a) / sizeof(int));
	twoSum(nums, -1);
}

bool compare(pair<int,int> a, pair<int, int> b) {
	if (a.second < b.second) {
		return true;
	}
	else if (a.second > b.second) {
		return false;
	}
	else {
		return a.first < b.first;
	}
}

vector<int> twoSum(vector<int>& A, int B) {
	map<int, int>numberIndex;
	vector<pair<int, int>> indexes;
	for (int i = 0;i<A.size();i++) {
		int target = B - A[i];
		if (numberIndex.find(target) != numberIndex.end()) {
			indexes.push_back(make_pair(numberIndex.find(target)->second, i + 1));
		}
		if (numberIndex.find(A[i]) == numberIndex.end()) {
			numberIndex[A[i]] = i + 1;
		}

	}
	vector<int>a;
	if (indexes.size() == 0) {
		return a;
	}
	sort(indexes.begin(), indexes.end(), compare);
	a.push_back(indexes[0].first);
	a.push_back(indexes[0].second);
	return a;
}