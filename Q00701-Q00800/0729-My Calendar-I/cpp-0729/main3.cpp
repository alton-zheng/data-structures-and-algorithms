#include <iostream>
#include <set>

using namespace std;

/// Using Tree Set with naive scan
/// Time Complexity: book: O(n)
///                  total: O(n^2)
/// Space Complexity: O(n)
class MyCalendar {

private:
    set<pair<int, int>> calendar;

public:
    MyCalendar() {
        calendar.clear();
    }

    bool book(int start, int end) {

        pair<int, int> newp = make_pair(start, end);
        for(pair<int, int> p: calendar)
            if(overlapped(p, newp))
                return false;

        calendar.insert(newp);
        return true;
    }

private:
    // Another easy way to check whether pa and pb overlapped
    // pa.start < pb.end && pa.end > pb.start
    bool overlapped(const pair<int, int>&pa, const pair<int, int>& pb){
        return pa.first < pb.second && pa.second > pb.first;
    }
};


void printBool(bool res){
    cout << (res ? "True" : "False" ) << endl;
}

int main() {

    MyCalendar calendar;
    printBool(calendar.book(10, 20)); // returns true
    printBool(calendar.book(15, 25)); // returns false
    printBool(calendar.book(20, 30)); // returns true

    return 0;
}