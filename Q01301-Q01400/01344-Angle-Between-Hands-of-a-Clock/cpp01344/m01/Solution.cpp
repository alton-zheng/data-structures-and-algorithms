// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Angle Between Hands of a Clock.
// Memory Usage: 5.8 MB, less than 96.06% of C++ online submissions for Angle Between Hands of a Clock.
class Solution {
public:
    double angleClock(int hour, int minutes) {
        double m = minutes / 5.0;
        double  h = hour % 12 + minutes / 60.0;
        double x = 360 * (abs(m - h)) / 12;
        return min(x, 360 - x);
    }
};