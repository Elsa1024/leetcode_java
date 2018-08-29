public class ZigzagIterator {
    Iterator<Integer> it1, it2;
    int nextIterator;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        nextIterator = 1;
    }

    public int next() {
        if (nextIterator == 1) {
            if (it1.hasNext()) {
                nextIterator = it2.hasNext() ? 2 : 1;
                return it1.next();
            } else {
                nextIterator = 2;
                return it2.next();
            }
        } else {
            if (it2.hasNext()) {
                nextIterator = it1.hasNext() ? 1 : 2;
                return it2.next();
            } else {
                nextIterator = 1;
                return it1.next();
            }
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
