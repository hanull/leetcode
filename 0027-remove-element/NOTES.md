처음에는 단순하게 val 값과 다른 값의 수(k)만 구해서 반환하면 되는 줄 알았다.
하지만, nums 배열에서 k-1 인덱스까지 값을 비교하기 때문에 val 값이 nums에 존재하면 안된다. 즉,  nums 배열에 변화를 줘야한다.
​
< 풀이 방법 >
투포인터로 시작점을 잡는다. count 인덱스는 val 값과 다른 값이 저장되는 위치, i는 단순 nums의 값을 확인하는 인덱스이다.
i=0부터 nums 배열을 확인하면서 val 값과 같은 경우, 다음으로 이동
val 값과 다른 경우, count 인덱스 위치에 해당 값(nums[i]) 을 저장