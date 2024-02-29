class Solution {
    // TreeNode left = null;
    // int level = -1;
    public int findBottomLeftValue(TreeNode root) {
            if(root.left==null && root.right==null) return root.val;

            return getLeftMost(root, 0, new int[]{0, -1});

            
    }

    int getLeftMost(TreeNode root, int currLevel, int[] arr){
            // if(root == null) return 0;

            if(currLevel > arr[1]){
                arr[1] = currLevel;
                arr[0] = root.val;
            }

            if(root.left != null) getLeftMost(root.left, currLevel+1, arr);
            if(root.right != null) getLeftMost(root.right, currLevel+1, arr);

            return arr[0];
    }
}
