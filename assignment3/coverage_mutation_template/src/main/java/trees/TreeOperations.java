package trees;

public class TreeOperations {
    public static <A> int nodeCount(final Node<A> root){
        if(root == null) return 0;
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }
}
