// Runtime: 404 ms, faster than 91.00% of C++ online submissions for Throne Inheritance.
// Memory Usage: 160.1 MB, less than 98.07% of C++ online submissions for Throne Inheritance.
class ThroneInheritance {
private:
    unordered_map<string, vector<string>> parentChildren;
    unordered_set<string> dead;
    string king;

public:
    ThroneInheritance(string kingName): king {move(kingName)} {}

    void birth(string parentName, string childName) {
        parentChildren[move(parentName)].push_back(move(childName));
    }

    void death(string name) {
        dead.insert(move(name));
    }

    vector<string> getInheritanceOrder() {
        vector<string> res;

        function<void(const string&)> preOrder = [&](const string& parentName) {

            if (!dead.count(parentName)) {
                res.push_back(parentName);
            }

            if (parentChildren.count(parentName)) {
                for (const string& child: parentChildren[parentName]){
                    preOrder(child);
                }
            }
        }

        preOrder(king);
        return res;
    }
};

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance* obj = new ThroneInheritance(kingName);
 * obj->birth(parentName,childName);
 * obj->death(name);
 * vector<string> param_3 = obj->getInheritanceOrder();
 */