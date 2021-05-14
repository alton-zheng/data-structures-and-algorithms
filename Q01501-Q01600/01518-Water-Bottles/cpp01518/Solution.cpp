class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int remain = numExchange;

        while (remain >= numExchange) {
            int temp = remain / numExchange;
            res += temp;
            remain = remain % numExchange + temp;
        }

        return res;

    }
};