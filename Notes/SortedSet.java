package Notes;

public class SortedSet {
    public static SortedSet<Integer> s; //Add value in ascending order in set.
    public static SmallestInfiniteSet() {
        s=new TreeSet<>();
        for (int i = 1; i < 1001; i++) {
            s.add(i);
        }
    }
    
    public static int popSmallest() {
        int k=s.first();
        s.remove(k);
        return k;
    }
    
    public static void addBack(int num) {
        s.add(num);
    }
}
