class Solution {
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        getDia(root);
        return dia;
    }

    int getDia(TreeNode root){
        if(root == null) return -1;

        int lh = getDia(root.left);
        int rh = getDia(root.right);

        if(lh+rh+2 > dia) dia = lh+rh+2;

        return 1 + Math.max(lh, rh);

    }
}
