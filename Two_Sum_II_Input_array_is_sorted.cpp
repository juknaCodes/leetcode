#include <iostream>
#include <vector>

using namespace std;
vector<int> twoSum(vector<int>& numbers, int target);


void main() {

}

vector<int> twoSum(vector<int>& numbers, int target) {
	int l = 0, r = numbers.size() - 1;
	vector<int> indexes;
	while (l<r) {
		int sum = numbers[l] + numbers[r];
		if (sum == target) {
			indexes.push_back(l + 1);
			indexes.push_back(r + 1);
			return indexes;
		}
		else if (sum > target) {
			r--;
		}
		else {
			l++;
		}
	}
	return indexes;
}