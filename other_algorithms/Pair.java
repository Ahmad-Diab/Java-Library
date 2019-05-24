package other_algorithms;

import java.util.Objects;

class Pair<T extends Comparable ,S extends Comparable> implements Comparable<Pair>
{
    T first ;
    S second ;
    Pair(T a , S b)
    {
        first = a ;
        second = b ;
    }
    @Override
    public int compareTo(Pair o)
    {
        if(first.compareTo(o.first) == 0)
            return second.compareTo(o.second);
        return first.compareTo(o.first);
    }
    @Override
    public int hashCode() {
        return Objects.hash(first , second);
    }
    @Override
    public boolean equals(Object obj) {
        return (first.equals(((Pair<T , S>)obj).first) && second.equals(((Pair<T , S>)obj).second)) ;
    }
}