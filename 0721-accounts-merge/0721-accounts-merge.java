class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToAccount = new HashMap<>();
        for (int i=0; i<accounts.size(); i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToAccount.containsKey(email)) {
                    emailToAccount.get(email).add(i);
                } else {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    emailToAccount.put(email, indexes);
                }
                
            }
        }
        
        List<List<String>> answer = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];
        for (int i=0; i<accounts.size(); i++) {
            if (visited[i]) {
                continue;
            }
            
            Set<String> emails = new TreeSet<>();
            dfs(i, emails, emailToAccount, accounts, visited);
            
            if (!emails.isEmpty()) {
                String name = accounts.get(i).get(0);
                List<String> temp = new ArrayList<>(emails);
                temp.add(0, name);
                
                answer.add(temp);
            }
        }
        
        return answer;
    }
    
    private void dfs(int current, Set<String> emails, Map<String, List<Integer>> emailToAccount, List<List<String>> accounts, boolean[] visited) {
        if (visited[current]) {
            return;
        }
        
        visited[current] = true;
        for (int i=1; i<accounts.get(current).size(); i++) {
            String email = accounts.get(current).get(i);
            emails.add(email);
            
            for (int index : emailToAccount.get(email)) {
                dfs(index, emails, emailToAccount, accounts, visited);
            }
        }
    }
}