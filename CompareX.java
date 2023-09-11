import java.util.Comparator;

class CompareX implements Comparator<Integer> {
    
    @Override
    public int compare(Integer a, Integer b) {
        int diff = a - b;
        return diff;
    }
}
