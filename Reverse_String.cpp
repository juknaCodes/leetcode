#include <iostream>
#include <string>

using namespace std;
string reverseString(string s);

void main() {
	reverseString("ankuj");
}

string reverseString(string s) {
	for (int i = 0;i<s.length() / 2;i++) {
		char temp = s[i];
		s[i] = s[s.length() - 1 - i];
		s[s.length() - 1 - i] = temp;
	}
	return s;
}