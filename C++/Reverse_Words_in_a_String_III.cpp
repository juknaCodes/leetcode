#include <iostream>
#include <string>

using namespace std;
string reverseWords(string s);

void main() {

	reverseWords("Let's take LeetCode contest");

}
string reverseWords(string s) {
	int wordStart = 0;
	int wordEnd = 0;
	for (int i = 0;i<s.length();i++) {
		if (s[i] == ' ') {
			reverse(s.begin() + wordStart, s.begin() + i);			
			wordStart = i + 1;
		}
		
	}
	reverse(s.begin() + wordStart, s.end());
	return s;
}