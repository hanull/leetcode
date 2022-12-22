import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            add(i, answer);
        }
        return answer;
    }
    
    public void add(int index, List<List<Integer>> answer) {
        List<Integer> numbers = new ArrayList<>();
        if (index <= 1) {
            for (int i=0; i<= index; i++) {
                numbers.add(1);
            }
            answer.add(numbers);
            return;
        }
        numbers.add(1);
        for (int i=1; i<answer.get(index - 1).size(); i++) {
            numbers.add(answer.get(index - 1).get(i - 1) + answer.get(index - 1).get(i));
        }
        numbers.add(1);
        answer.add(numbers);
    }
}