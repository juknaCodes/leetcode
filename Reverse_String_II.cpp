#include <iostream>
#include <string>

using namespace std;
string reverseStr(string s, int k);

void main() {
	reverseStr("aA",20);
}

string reverseStr(string s, int k) {
	//if (s.length() < k) {
	//	reverse(s.begin(), s.end());
	//	return s;
	//}
	//for (int i = 0;i<s.length();) {
	//	int endIndex = i + k <= s.length() ? i + k : s.length();
	//	reverse(s.begin() + i, s.begin() + endIndex);
	//	i += (2 * k);

	//}
	//return s;
	string vowels = "";
	for (int i = s.length() - 1; i >= 0;i--) {
		if (tolower(s[i])== 'a' || tolower(s[i]) == 'e' || tolower(s[i]) == 'i' || tolower(s[i]) == 'o' || tolower(s[i]) == 'u') {
			vowels.push_back(s[i]);
		}
	}
	int j = 0;
	for (int i = 0; i<s.length();i++) {
		if (tolower(s[i]) == 'a' || tolower(s[i]) == 'e' || tolower(s[i]) == 'i' || tolower(s[i]) == 'o' || tolower(s[i]) == 'u') {
			s[i] = vowels[j++];
		}
	}

	return s;

}