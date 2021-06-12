// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Average Salary Excluding the Minimum and Maximum Salary.
// Memory Usage: 7.2 MB, less than 39.57% of C++ online submissions for Average Salary Excluding the Minimum and Maximum Salary.

class Solution {
public:
 double average(vector<int>& salary) {

        double count = 0;
        int min = INT_MAX, max = INT_MIN;
        for (int i = 0; i < salary.size(); i++) {
            count += salary[i];
            if (min > salary[i]) {
                min = salary[i];
            }

            if (max < salary[i]) {
                max = salary[i];
            }

        }

        return (count - min - max) / (salary.size() - 2);
    }
}