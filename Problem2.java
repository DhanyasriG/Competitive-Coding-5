// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(m), where m is the maximum number of nodes at any level in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We will use BFS approach to traverse the tree level by level with 
// size variable to identify the number of nodes at each level.
//  we will keep track of the maximum value encountered and add it to the result list after every level

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        if(root==null) return result;  //base case

        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                if(curr.val>max){
                    max=curr.val;
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}