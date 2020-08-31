package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalTraversal {
    public void traverse(TreeNode root, int X, int Y, HashMap<Integer, Map<Integer, List<Integer>>> map){
        if(root == null) return ;
        if(!map.containsKey(X))
            map.put(X, new HashMap<>());
        if(!map.get(X).containsKey(Y))
            map.get(X).put(Y, new ArrayList<>());
		// add value at x and y position
        map.get(X).get(Y).add(root.val);
		// traverse both left and right
        traverse(root.left, X - 1, Y + 1, map);
        traverse(root.right, X + 1, Y + 1, map);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
	    // variable to return answer
        List<List<Integer>> ans = new ArrayList<>();
		// We need to x and y co-ordinates
        // So, I used map for faster access
		// Here, key is X co-ordinate
		// and value is another map which stores
		// Y co-ordinate and value at that position
        HashMap<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        traverse(root, 0, 0, map);
		// Now we need to traverse from left to right on the X - axis
		// So, get keys and sort them
        List<Integer> set = new ArrayList<>(map.keySet());
        Collections.sort(set);
        for(Integer key : set){
            // Now, at each point, we need to add 
			// nodes from top to bottom
			// So, get values at the X, and sort Y
			// and add all node values top to bottom
            Map<Integer, List<Integer>> temp = map.get(key);
            List<Integer> pos = new ArrayList<>(temp.keySet());
            Collections.sort(pos);
            List<Integer> t = new ArrayList<>();
            for(Integer Y : pos){
                Collections.sort(temp.get(Y));
                t.addAll(temp.get(Y));
            }
			// Now, add that group to answer
            ans.add(t);
        }
        return ans;
    }
}