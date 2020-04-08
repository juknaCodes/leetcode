#include <iostream>
#include <string>

using namespace std;

bool judgeCircle(string moves);

void main() {
	judgeCircle("ULTTB");
}

bool judgeCircle(string moves) {
	int sum = 0;
	for (int i = 0;i<moves.length();i++) {
		if (moves[i] == 'U') {
			sum += 1;
		}
		else if (moves[i] == 'L') {
			sum += -1;
		}
		else if (moves[i] == 'D') {
			sum += -1;
		}
		else {
			sum += 1;
		}
	}
	return sum == 0 ? true : false;
}