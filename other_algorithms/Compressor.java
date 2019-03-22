package other_algorithms;

import java.util.*;

class Compressor<T> implements Iterable<T>
{
	TreeSet<T> set = new TreeSet<>() ; 
	HashMap<T , Integer> map = new HashMap<>() ; 
	
	void add(T x) {set.add(x);}
	
	void fix() {for(T x : set) map.put(x, map.size()) ;}
	
	int get(T x) {return map.get(x) ;}

	public Iterator<T> iterator() {return set.iterator();}
}
