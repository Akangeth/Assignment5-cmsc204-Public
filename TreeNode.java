/**
 * Class that is used to create a tree in MorseCodeTree
 * 
 * @author Allan Kangethe
 *
 * @param <T> 
 */
public class TreeNode<T> {
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected T data;

	/**
	 * Constructor passes data to create a tree node
	 * 
	 * @param data data of tree node
	 */
	public TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * Copies constructor
	 * 
	 * @param tree node to set the node
	 */
	public TreeNode(TreeNode<T> theTreeNode) {
		this.right = theTreeNode.right;
		this.left = theTreeNode.left;
		this.data = theTreeNode.data;
	}


	/**
	 * Returns data of the tree node
	 * 
	 * @return data data of the tree node
	 */
	public T getData() {
		return data;
	}
}