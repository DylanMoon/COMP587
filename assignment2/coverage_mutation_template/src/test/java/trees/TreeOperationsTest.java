package trees;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TreeOperationsTest {
    @Test
    public void bogusTest() {
        // illustrates how to write a test
        // assertEquals(expected, expression_being_tested)
        assertEquals(2, 1 + 1);
    }


    /*
    *   TestTree:
    *               F
    *              / \
    *            B    G
    *           / \    \
    *          A   D    I
    *             / \  / \
    *            C  E H   J
    *                      \
    *                       K
    *
    *   Breadth Fist Ordering:
    *       F B G A D I C E H J K
    *
    *   Preorder:
    *       F B A D C E G I H J K
    *
    *
    */


    Node<String> TestTree = new Node<String>("F",
            new Node<String>("B",
                    new Node<String>("A", null, null),
                    new Node<String>("D",
                            new Node<String>("C", null, null),
                            new Node<String>("E", null, null))),
            new Node<String>("G",
                    null,
                    new Node<String>("I",
                            new Node<String>("H", null, null),
                            new Node<String>("J",
                                    null,
                                    new Node<String>("K", null, null)))));

    TreeOperations t = new TreeOperations();

    @Test
    public void nullDepthTest(){
        assertEquals(0, TreeOperations.maxDepth(null));
    }

    @Test
    public void depthTest1(){
        Node<Integer> tree = new Node<Integer>(42, null, null);
        assertEquals(1, TreeOperations.maxDepth(tree));
    }

    @Test
    public void depthTest2(){
        assertEquals(5, TreeOperations.maxDepth(TestTree));
    }

    @Test
    public void bfsTest1(){
        ArrayList<String> bfs = new ArrayList<>();
        bfs.add("F");
        bfs.add("B");
        bfs.add("G");
        bfs.add("A");
        bfs.add("D");
        bfs.add("I");
        bfs.add("C");
        bfs.add("E");
        bfs.add("H");
        bfs.add("J");
        bfs.add("K");
        assertEquals(bfs, TreeOperations.bfs(TestTree));
    }

    @Test
    public void bfsTest2(){
        assertEquals(new ArrayList<>(), TreeOperations.bfs(null));
    }

    @Test
    public void preorderTest1(){
        ArrayList<String> pot = new ArrayList<>();
        pot.add("F");
        pot.add("B");
        pot.add("A");
        pot.add("D");
        pot.add("C");
        pot.add("E");
        pot.add("G");
        pot.add("I");
        pot.add("H");
        pot.add("J");
        pot.add("K");
        assertEquals(pot, TreeOperations.preorder(TestTree));
    }

    @Test
    public void preorderTest2(){
        assertEquals(new ArrayList<>(), TreeOperations.preorder(null));
    }
}
