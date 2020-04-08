#include <iostream>
#include <string>

using namespace std;
int countSegments(string s);

void main() {
	countSegments("Hello, my name is John");
}

int countSegments(string s) {
	int i = 0;
	int segmentCount = 0;
	bool withinSegment = false;
	while (i < s.length()) {
		if (s[i] == ' ') {
			i++;
			withinSegment = false;
			continue;
		}
		if (!withinSegment) {
			segmentCount++;
			withinSegment = true;
		}
		i++;
	}
	return segmentCount;

}