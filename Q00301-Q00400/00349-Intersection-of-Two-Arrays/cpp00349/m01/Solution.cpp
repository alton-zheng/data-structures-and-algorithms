class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {

        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(), nums2.end());

        int first = 0, second = 0;

        vector<int> res;

        while (first < nums1.size() && second < nums2.size()) {

            while (first + 1 < nums1.size() && nums1[first] == nums1[first + 1]) {
                first++;
            }

            while (second + 1 < nums2.size() && nums2[second] == nums2[second + 1]) {
                second++;
            }


            if (nums1[first] == nums2[second]) {
               res.push_back(nums1[first]);

            }

            if (nums1[first] < nums2[second]) {
                first++;
            } else {
                second++;
            }
        }

        return res;




    }
};