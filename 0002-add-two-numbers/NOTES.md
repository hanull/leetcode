두 리스트가 null이 아닐 때까지 두 노드의 합을 구하면 된다.
10이 넘는 경우, 1의 자리 수가 다음 노드의 수가 되고 몫이 carry가 된다. 따라서 %10으로 다음 노드를 구하고 /10으로 sum을 초기화 해준다.
​
단, 반복을 두 리스트가 null이 아닐 때까지만 진행하면 example3 처럼 마지막에 carry가 존재하는 경우를 추가하지 못한다. 따라서, 두 리스트가 null이 아니거나 sum이 없을 때까지 진행해야 마지막 1까지 출력할 수 있다.