package permutions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class SolutionStackTailStack {
    
    class TailStack<T extends Comparable> extends LinkedList<T> implements
            Comparable<TailStack<T>> {

        public TailStack(Collection<? extends T> c) {
            super();
            super.addAll(c);
        }

        public TailStack() {
            super();
        }

        @Override
        public int compareTo(TailStack<T> o) {
            if (this.size() > o.size())
                return 1;
            if (this.size() < o.size())
                return -1;
            if (this.size() == 0)
                return 0;

            Iterator<T> thisIterator = this.iterator();
            Iterator<T> thatIterator = o.iterator();

            while (thisIterator.hasNext()) {
                T thisNext = thisIterator.next();
                T thatNext = thatIterator.next();
                if (thisNext.compareTo(thatNext) > 0)
                    return 1;
                if (thisNext.compareTo(thatNext) < 0)
                    return -1;
            }
            return 0;
        }

        @Override
        public T pop() {
            return super.removeLast();
        }

        @Override
        public void push(T it) {
            super.offer(it);
        }

        @Override
        public T peek() {
            return super.getLast();
        }

    }

    public LinkedList<TailStack<Integer>> search(int size) {
        LinkedList<TailStack<Integer>> mappers = new LinkedList<TailStack<Integer>>();

        LinkedList<TailStack<Integer>> s = new LinkedList<TailStack<Integer>>();
        s.push(new TailStack<Integer>());
        LinkedList<Integer> allNums = new LinkedList<Integer>();
        for (int i = 0; i < size; i++)
            allNums.add(i);

        TailStack<Integer> poped = new TailStack<Integer>();
        while (s.size() > 0) {
            TailStack<Integer> top = s.peek();
            boolean breakit = false;
            for (Integer i : allNums) {
                if (top.contains(i))
                    continue;
                TailStack<Integer> num = new TailStack<Integer>(top);
                num.push(i);
                if (num.compareTo(poped) > 0) {
                    s.push(num);
                    if (num.size() > size - 1) {
                        mappers.add(num);
                    }
                    breakit = true;
                    break;
                }
            }
            if (!breakit)
                poped = s.pop();
        }
        
        return mappers;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        LinkedList<TailStack<Integer>> mappers = search(num.length);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (TailStack<Integer> mapper : mappers){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(Integer i : mapper){
                tmp.add(num[i]);
            }
            result.add(tmp);
        }
        
        return result;
    }
}