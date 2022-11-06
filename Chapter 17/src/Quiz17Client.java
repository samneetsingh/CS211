public class Quiz17Client {
    public static void main(String[] args) {
        // Another example: partial stutter the Ref Tree2 from text exercises:
        IntTreeNode six = new IntTreeNode(6, null, new IntTreeNode(9, null, null));
        IntTreeNode seven = new IntTreeNode(7, new IntTreeNode(4, null, null), null);
        IntTreeNode eight = new IntTreeNode(8, new IntTreeNode(0, null, null), null);
        IntTree refTree2 = new IntTree(new IntTreeNode(2, eight, new IntTreeNode(1, seven, six)));
        refTree2.printSideways();
        System.out.println("---------------------------------");
        refTree2.partialStutter();
        refTree2.printSideways();
    }
}