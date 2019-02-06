package data_structures;

import java.util.*;

class ModifiedQueue
{
	Queue<Integer> q = new LinkedList<>();
	Deque<Integer> d = new LinkedList<>();
	
	void add(int x)
	{
		q.add(x);
		while(!d.isEmpty() && d.getLast() > x)
			d.removeLast();
		d.addLast(x);
	}
	
	int remove()
	{
		int c = q.remove();
		if(c == d.getFirst().intValue())
			d.removeFirst();
		return c;
	}
	
	int min() { return d.getFirst(); }
}