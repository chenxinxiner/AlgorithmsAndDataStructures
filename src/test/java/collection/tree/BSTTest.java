package collection.tree;

import org.junit.jupiter.api.Test;

class BSTTest {

    @Test
    void put() throws Exception {
        BinarySearchTree<String, String> stringIntegerBST = new BinarySearchTree<String, String>();
        stringIntegerBST.put("h","h");
        stringIntegerBST.put("a","a");
        stringIntegerBST.put("f","qweq");
        stringIntegerBST.put("m","m");
        stringIntegerBST.put("e","e");
        stringIntegerBST.put("c","asdasda");
        stringIntegerBST.put("d","d");
        stringIntegerBST.put("j","j");
        stringIntegerBST.put("k","k");
        System.out.println(stringIntegerBST.size()+" "+stringIntegerBST.get("c"));
        System.out.println("max= "+stringIntegerBST.min());
        System.out.println("min= "+stringIntegerBST.max());
        System.out.println("floor= "+stringIntegerBST.floor("g"));
        System.out.println("ceiling= "+stringIntegerBST.ceiling("g"));
        System.out.println("select= "+stringIntegerBST.select(4));
        System.out.println("rank= "+stringIntegerBST.rank("j"));
        // stringIntegerBST.deleteMin();
        // stringIntegerBST.deleteMax();
        stringIntegerBST.delete("j");
        System.out.println();
    }

    @Test
    void get() throws Exception {
        BinarySearchTree<Double,Double> binarySearchTree = new BinarySearchTree();
        double[] doubles = new double[10000000];
        for (int i = 0; i < 10000000; i++) {
            double n = Math.random();
            binarySearchTree.put(n,n);
            doubles[i] = n;
        }
        System.out.println();
        long l = System.currentTimeMillis();
        System.out.println(binarySearchTree.get(doubles[399909]));
        System.out.println(binarySearchTree.get(doubles[120000]));
        System.out.println("floor= "+binarySearchTree.floor(0.12312314134));
        System.out.println("ceiling= "+binarySearchTree.ceiling(0.123123141434));
        System.out.println("select= "+binarySearchTree.select(1321233));
        System.out.println("rank= "+binarySearchTree.rank(doubles[231232]));
        System.out.println("时间 ="+(System.currentTimeMillis()-l));
    }

    @Test
    public void test2() {
        String a = "aaaa";
        String b = "bbbb";
        a = b;
        b = "ccc";
        System.out.printf(a);
    }
}