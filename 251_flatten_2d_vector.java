public class Vector2D implements Iterator<Integer> {
    List<Integer> vec;
    Iterator<Integer> itr;
    
    public Vector2D(List<List<Integer>> vec2d) {
        vec = new ArrayList<>();
        for (List<Integer> list : vec2d)
            for (Integer element : list)
                vec.add(element);
        
        itr = vec.iterator();
    }

    @Override
    public Integer next() {
        return itr.hasNext() ? itr.next() : null; 
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }
}

/*
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> outerItr;
    Iterator<Integer> innerItr;
    
    public Vector2D(List<List<Integer>> vec2d) {
       outerItr = vec2d.iterator();
    }

    @Override
    public Integer next() {
       return innerItr.next();
    }

    @Override
    public boolean hasNext() {
        while ((innerItr == null || !innerItr.hasNext()) && outerItr.hasNext())
            innerItr = outerItr.next().iterator();
        return innerItr != null && innerItr.hasNext();
    }
}
*/
