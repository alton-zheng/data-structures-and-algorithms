// Runtime: 88 ms, faster than 60.37% of C++ online submissions for Design HashSet.
// Memory Usage: 41.9 MB, less than 68.59% of C++ online submissions for Design HashSet.
class MyHashSet {
private:
    vector<list<int>> s;
    static const int BASE = 769;
    static int hash(int key) {
        return key % BASE;
    }
public:
    /** Initialize your data structure here. */
    MyHashSet(): s(BASE) {}

    void add(int key) {
        if (!contains(key)) {
            int h = hash(key);
            s[h].push_back(key);
        }
    }

    void remove(int key) {
        if (contains(key)) {
            int h = hash(key);
            s[h].remove(key);
        }
    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int h = hash(key);
        for (auto it = s[h].begin(); it != s[h].end(); it++) {
            if ((*it) == key) {
                return true;
            }
        }

        return false;
    }
};