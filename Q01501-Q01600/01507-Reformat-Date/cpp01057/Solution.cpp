// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Reformat Date.
// Memory Usage: 6.3 MB, less than 5.92% of C++ online submissions for Reformat Date.
class Solution {
public:
    string reformatDate(string date) {
        unordered_map<string, string> help = {
                    {"Jan", "01"},
                    {"Feb", "02"},
                    {"Mar", "03"},
                    {"Apr", "04"},
                    {"May", "05"},
                    {"Jun", "06"},
                    {"Jul", "07"},
                    {"Aug", "08"},
                    {"Sep", "09"},
                    {"Oct", "10"},
                    {"Nov", "11"},
                    {"Dec", "12"}
                };

        stringstream ss(date);
        string year, month, day;
        ss >> day >> month >> year;

        month = help[month];
        day.pop_back();
        day.pop_back();
        if (day.size() == 1) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;

    }

};