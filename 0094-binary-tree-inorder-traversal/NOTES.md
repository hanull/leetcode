​![https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/328601/All-DFS-traversals-(preorder-postorder-inorder)-in-Java-in-5-lines](https://user-images.githubusercontent.com/46413629/207991032-e02ac821-2a9a-46f9-8b00-20671b805ed4.png)

### preorder
```java
public List<Integer> preorder(TreeNode root) {
  List<Integer> nums = new ArrayList<>();
  if (root == null) {
    return nums;
  }
  
  nums.add(root.val);
  nums.addAll(preorder(root.left));
  nums.addAll(preorder(root.right));
  return nums;
}
```

### inorder
```java
public List<Integer> inorder(TreeNode root) {
  List<Integer> nums = new ArrayList<>();
  if (root == null) {
    return nums;
  }
  
  nums.addAll(inorder(root.left));
  nums.add(root.val);
  nums.addAll(inorder(root.right));
  return nums;
}
```

### postorder
```java
public List<Integer> postorder(TreeNode root) {
  List<Integer> nums = new ArrayList<>();
  if (root == null) {
    return nums;
  }
  
  nums.addAll(postorder(root.left));
  nums.addAll(postorder(root.right));
  nums.add(root.val);
  return nums;
}
```
