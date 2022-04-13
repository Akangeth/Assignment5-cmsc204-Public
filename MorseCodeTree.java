import java.util.ArrayList;

/**
 * Class that uses tree nodes to create binary trees
 * 
 * @author Allan Kangethe 
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> theRootNode;

	/**
	 * Constructor that will call on buildTree() to build the trees
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns the root of the node
	 * 
	 * @return theRootNode the root node
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return theRootNode;
	}

	/**
	 * sets the root node
	 * @param theNewNode - node that rootNode will be set to
	 */
	@Override
	public void setRoot(TreeNode<String> theNewNode) {
		// TODO Auto-generated method stub
		theRootNode = new TreeNode<String>(theNewNode);
	}

	/**
	 * Method that inserts a letter into a tree based on the morse code
	 * 
	 * @param code   - morse code
	 * @param letter - letter that will be placed into the tree
	 */
	@Override
	public void insert(String code, String letter) {
		// TODO Auto-generated method stub
		addNode(theRootNode, code, letter);

	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   the root of the tree for this particular recursive instance of
	 *               addNode
	 * @param code   the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub

		// keep calling this method until code is one character
		if (code.length() > 1) {
			if (code.charAt(0) == '-') {
				addNode(root.right, code.substring(1), letter);
			} else if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			}
		}
		// once code is one character, insert it into the tree
		else if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.left = new TreeNode<String>(letter);
			} else if (code.charAt(0) == '-') {

				root.right = new TreeNode<String>(letter);
			}
		}
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		String fetch = fetchNode(theRootNode, code);
		return fetch;
	}

	/**
	 * A recursive method that gets the data of the tree node and checks with the code 
	 * @param root the root of the tree
	 * @param code the morse code for this current recursive instance of the fetchNode
	 * @return the data correlating to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String theCode) {
		// TODO Auto-generated method stub
		String string = "";
		// keep calling method until code is one character
		if (theCode.length() > 1) {
			if (theCode.charAt(0) == '-') {
				string = fetchNode(root.right, theCode.substring(1));
			} else if (theCode.charAt(0) == '.') {
				string = fetchNode(root.left, theCode.substring(1));
			}
		}
		
		else {
			if (theCode.equals("-")) {
				return root.right.getData();
			} else if (theCode.equals(".")) {
				return root.left.getData();
			}
		}
		return string;
	}

	/**
	 * not supported for LinkedConverterTree
	 * 
	 * @param data data of node that will be deleted
	 * @return show the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @return show to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T> into
	 * their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		
		theRootNode = new TreeNode<>("");
		// 1
		insert(".", "e");
		insert("-", "t");
		// 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		// 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in Left, Right, Node
	 *  for testing to get the tree built
	 * 
	 * @return an ArrayList of the things within the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(theRootNode, list);
		return list;
	}

	/**
	 * The recursive method to put the items of the linked converter tree in an
	 * ArrayList<T>
	 * 
	 * @param root the root of the tree for this current recursive instance
	 * @param list the ArrayList 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> theRoot, ArrayList<String> theList) {
		if (!(theRoot == null)) {
			if (theRoot.left != null) {
				LNRoutputTraversal(theRoot.left, theList);
			}
			
			theList.add(theRoot.data);
			if (theRoot.right != null) {
				LNRoutputTraversal(theRoot.right, theList);
			}
		}

		if (theRoot == null) {
			return;
		}
	}
}