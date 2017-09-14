#include<iostream>
#include <string>
#include <vector>

using namespace std;
bool repeatedSubstringPattern(string s);

void main() {
	repeatedSubstringPattern("abac");
}

bool repeatedSubstringPattern(string s) {
	vector<int> lps(s.length(), 0);
	int i = 1;
	int len = 0;
	while (i < s.length()) {
		if (s[i] == s[len]) {
			len++;
			lps[i] = len;
			i++;
		}
		else {
			if (len != 0) {
				len = lps[len - 1];
			}
			else {
				len = 0;
				i++;
			}
		}
	}
	return lps[s.length() - 1] && ((lps[s.length()-1] % (s.length() - lps[s.length()-1])) == 0);

}