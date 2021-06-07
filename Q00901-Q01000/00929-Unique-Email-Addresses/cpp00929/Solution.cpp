// Runtime: 24 ms, faster than 75.78% of C++ online submissions for Unique Email Addresses.
// Memory Usage: 15.7 MB, less than 18.05% of C++ online submissions for Unique Email Addresses.
class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string> help;
        for (string e : emails) {
            int i = e.find("@");
            string local = e.substr(0, i);
            string rest = e.substr(i);

            if (local.find("+")) {
                local = local.substr(0, local.find("+"));
            }

            local.erase(remove(local.begin(), local.end(), '.'), local.end());

            help.insert(local + rest);

        }

        return help.size();
    }
};