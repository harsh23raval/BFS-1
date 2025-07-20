// Time Complexity : O(n) -> since we are traversing all elements of the TreeNode
// Space Complexity : O(n) -> Queue will at most contain the elements equal to the maximum breadth of the tree
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //base case
        if(numCourses == 0){
            return true;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        int[] inDegress = new int[numCourses];

        for(int[] curr : prerequisites){
            int course = curr[0];
            int dependency = curr[1];

            inDegress[course]++;

            if(!map.containsKey(dependency)){
                map.put(dependency, new ArrayList<>());
            }
            map.get(dependency).add(course);
        }

        for(int i=0; i<inDegress.length; i++){
            if(inDegress[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int dependency = q.poll();
            List<Integer> edges = map.get(dependency);

            if(edges == null){
                continue;
            }

            for(int e : edges){
                inDegress[e]--;
                if(inDegress[e] == 0){
                    q.add(e);
                }
            }

            numCourses--;

            if(numCourses < 0){
                return true;
            }
        }

        
        for(int i = 0; i < inDegress.length; i++ ){
            if(inDegress[i] != 0){
                return false;
            }
        }

        return true;
    }
}