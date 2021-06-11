#include <iostream>
#include <unordered_map>

using namespace std;


/// Ad-Hoc
/// Time Complexity: O(n)
/// Space Complexity: O(1)

class Solution {
public:
    int romanToInt(string s) {

        int sum = 0;
        int pre = getValue(s[0]);
        for (int i = 1; i < s.size(); i++) {
            int cur = getValue(s[i]);
            if (pre < cur) {
                sum -= pre;
            } else {
                sum += pre;
            }

            pre = cur;
        }

        sum += pre;

        return sum;

    }

    int getValue(char ch) {
        switch (ch) {
            case 'I':
                        return 1;
                    case 'V':
                        return 5;
                    case 'X':
                        return 10;
                    case 'L':
                        return 50;
                    case 'C':
                        return 100;
                    case 'D':
                        return 500;
                    case 'M':
                        return 1000;
                    default:
                        return 0;
                }
    }
};


int main() {

    return 0;
}