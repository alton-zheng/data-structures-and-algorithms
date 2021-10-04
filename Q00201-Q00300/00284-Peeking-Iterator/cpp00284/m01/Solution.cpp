template <class T>
class PeekingIterator : public Iterator<T> {
public:
    PeekingIterator(const vector<T>& nums) : Iterator<T>(nums) {
        flag = Iterator<T>::hasNext();
        if (flag) {
            nextElement = Iterator<T>::next();
        }
    }

    T peek() {
        return nextElement;
    }

    T next() {
        T ret = nextElement;
        flag = Iterator<T>::hasNext();
        if (flag) {
            nextElement = Iterator<T>::next();
        }
        return ret;
    }

    bool hasNext() const {
        return flag;
    }
private:
    T nextElement;
    bool flag;
};
