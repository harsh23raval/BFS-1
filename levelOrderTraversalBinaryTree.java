// Time Complexity : O(n) -> since we are traversing all elements of the TreeNode
// Space Complexity : O(n) -> Queue will at most contain the elements equal to the maximum breadth of the tree
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //base case
        if(root == null){
            return new ArrayList<>();        
        }

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            
            //sizeCounter
            int count = 1;

            //get the q size
            int size = q.size();
            System.out.println(size);

            //initialize the empty arrayList
            List<Integer> newArr = new ArrayList<>();

            //while size is not equal
                //poll from q and add to the arrayList

            while(count <= size){
                TreeNode curr = q.poll();
                count++;

                if(curr == null){
                    continue;
                }
                q.add(curr.left);
                q.add(curr.right);

                newArr.add(curr.val);
            }

            //add to res
            if(newArr.size() > 0){
                res.add(newArr);
            }
            
        }

        return res;
        
    }
}
