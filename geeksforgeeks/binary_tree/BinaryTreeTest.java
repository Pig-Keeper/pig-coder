/*
 * @Created on Sun Jun 05 2022 17:34:14
 * @ProblemLink https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * @Author Pig Keeper
 */
package geeksforgeeks.binary_tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        new BinaryTree<Integer>()
        .insertByString("", 5)
        .insertByString("l", 2)
        .insertByString("r", 3)
        .insertByString("ll", 1)
        .insertByString("rl", 4)
        .printPreorder()
        .printInorder()
        .printPostorder();
    }
}
