#include <iostream>
#include <vector>

using namespace std;
vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c);

void main() {
	vector<int> A;
	A.push_back(1);
	A.push_back(2);
	vector<int>B;
	B.push_back(3);
	B.push_back(4);
	vector<vector<int>> C;
	C.push_back(A);
	C.push_back(B);
	matrixReshape(C, 1, 4);
}

vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
	int row = nums.size();
	int col = nums[0].size();
	if (row*col != r*c) {
		return nums;
	}
	vector <int> cols(c, 0);
	vector<vector<int>> newMatrix(r, cols);
	int row_index = 0;
	int col_index = 0;
	for (int i = 0;i < row;i++) {
		for (int j = 0;j < col;j++) {
			newMatrix[row_index][col_index++] = nums[i][j];
			if (col_index == c) {
				row_index++;
				col_index = 0;
			}
		}
	}
	return newMatrix;

}