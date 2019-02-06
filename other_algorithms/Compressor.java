package other_algorithms;

import java.util.*;

class Compressor
{
	TreeSet<Long> set = new TreeSet<>();
	HashMap<Long, Integer> map = new HashMap<>();

	void add(long x) { set.add(x); }

	void fix() { for(long x: set) map.put(x, map.size()); }

	int get(long x) { return map.get(x); }
}