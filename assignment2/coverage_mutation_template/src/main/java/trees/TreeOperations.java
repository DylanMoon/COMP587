package trees;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeOperations {
    public static <A> ArrayList<A> bfs(final Node<A> root){
        if(root == null)return new ArrayList<>();
        ArrayList<A> visited = new ArrayList<>();
        Queue<Node<A>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<A> currentNode;
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            visited.add(currentNode.contents);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return visited;
    }
    public static <A> ArrayList<A> preorder(final Node<A> root){
       return preorder(root, new ArrayList<A>());
    }
    public static <A> ArrayList<A> preorder(final Node<A> root, final ArrayList<A> list) {
        if(root == null) return list;
        list.add(root.contents);
        preorder(root.left, list);
        preorder(root.right, list);
        return list;
    }
    public static <A> int maxDepth(final Node<A> root){
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
