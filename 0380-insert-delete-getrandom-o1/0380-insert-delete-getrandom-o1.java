import java.util.*;

class RandomizedSet {

    private final static Random random = new Random();

    private final Map<Integer, Integer> indexesByValue;
    private final List<Integer> values;

    public RandomizedSet() {
        indexesByValue = new HashMap<>();
        values = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (values.contains(val)) {
            return false;
        }
        
        indexesByValue.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!values.contains(val)) {
            return false;
        }

        int targetIndex = indexesByValue.get(val);
        if (targetIndex < values.size() - 1) {
            int lastValue = values.get(values.size() - 1);
            values.set(targetIndex, lastValue);
            indexesByValue.put(lastValue, targetIndex);
        }
        indexesByValue.remove(val);
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        int selectedIndex = random.nextInt(values.size());
        return values.get(selectedIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
