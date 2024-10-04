class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int tank = 0;
        int start = 0;
        for (int i=0; i<gas.length; i++) {
            int diff = gas[i] - cost[i];
            
            totalSum += diff;
            tank += diff;
            
            // 사용 가능한 가스보다 비용이 더 크기 때문에 start 위치부터 시작할 수 없다.
            // 따라서 가스 탱크 값을 0으로 초기화하고, 다음 위치를 시작 위치로 한다.
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        
        // totalSum 값이 0보다 작다는 것은 총 cost 값이 gas보다 크다는 것이다.
        // 따라서 어떤 위치에서 시작하던지 제자리로 돌아올 수 없다.
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}