package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TreeOperationsTest {

    TreeOperations t = new TreeOperations();

    public static final int MIN_BOUND = 0;
    public static final int MAX_BOUND = 10000;

    private int _numNodes;
    private void SetNumNodes(final int num){
        _numNodes = num;
    }
    private int GetNumNodesRemaining(){
        return _numNodes;
    }
    private void DecrementNumNodesRemaining(){
        _numNodes--;
    }

    private <A> Node<A> GenerateTree(int numNodes){
        if(numNodes < 1) return null;
        SetNumNodes(numNodes);
        return GenerateTreeRecursive(new Random());
    }
    private <A> Node<A> GenerateTreeRecursive(Random rand){
        if(GetNumNodesRemaining() < 1)return null;
        DecrementNumNodesRemaining();
        var decision = rand.nextInt(30);
        if(decision < 10){
            return new Node<A>(null, GenerateTreeRecursive(rand), null);
        }
        if(decision < 20){
            return new Node<A>(null, null, GenerateTreeRecursive(rand));
        }
        return new Node<A>(null, GenerateTreeRecursive(rand), GenerateTreeRecursive(rand));
    }

    private <A> Node<A> AddNodeToHead(A contents, Node<A> left, Node<A> right){
        return new Node<A>(contents, left, right);
    }

    @Test
    public void TestAddTrees(){
        var rand = new Random();
        var numNodes1 = rand.nextInt(MAX_BOUND);
        var numNodes2 = rand.nextInt(MAX_BOUND);
        var tree1 = GenerateTree(numNodes1);
        var tree2 = GenerateTree(numNodes2);
        assertEquals(numNodes1, TreeOperations.nodeCount(tree1));
        assertEquals(numNodes2, TreeOperations.nodeCount(tree2));
        var tree3 =  AddNodeToHead(null, tree1, tree2);
        assertEquals(numNodes1 + numNodes2 + 1, TreeOperations.nodeCount(tree3));
    }


    @Test
    public void TestUnequalTrees(){
        var rand = new Random();
        var numNodes = rand.nextInt(MAX_BOUND);
        var tree1 = GenerateTree(numNodes);
        assertEquals(numNodes, TreeOperations.nodeCount(tree1));
        var tree2 = AddNodeToHead(null, tree1, null);
        assertTrue(TreeOperations.nodeCount(tree1) < TreeOperations.nodeCount(tree2));
    }

    @Test
    public void NumNodesTestGenerator(){


        var rand = new Random().nextInt(50);
        for (int i = MIN_BOUND; i < MAX_BOUND; i+= rand) {
            assertEquals(i, TreeOperations.nodeCount(GenerateTree(i)));
        }
    }

    @Test
    public void TestNullNode(){
        assertEquals(0, TreeOperations.nodeCount(null));
    }

}