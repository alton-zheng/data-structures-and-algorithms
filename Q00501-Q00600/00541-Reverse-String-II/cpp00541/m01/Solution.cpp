
class Solution {
public:
    string reverseStr(string s, int k) {

        int l = s.size();
        for(int i = 0; i < l; i+= 2*k) {

            int left = i, right = i + k - 1 >= l ? l - 1 : i + k - 1;

            while (left < right) {
                swap(s[left], s[right]);
                left++;
                right--;
            }
        }

        return s;
    }
};