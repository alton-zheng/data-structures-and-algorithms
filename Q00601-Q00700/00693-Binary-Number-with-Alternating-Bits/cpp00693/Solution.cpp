class Solution {
public:
    bool hasAlternatingBits(int n) {
        return [](unsigned int i){return !(i & (i+1));}((n ^ (n>>1)));
    }
};6