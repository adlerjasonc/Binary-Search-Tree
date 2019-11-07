// Binary Search Tree implementation
public class BST<E extends Comparable<? super E>> extends HW7_Abstract_Class<E>{
  private BSTNode<E> root; // Root of the BST
  private int nodecount; // Number of nodes in the BST

  // constructor
  BST() { root = null; nodecount = 0; }

  // Reinitialize tree
  public void clear() { root = null; nodecount = 0; }

  // Insert a record into the tree.
  // Records can be anything, but they must be Comparable
  // e: The record to insert.
  public void insert(E e) {
    root = inserthelp(root, e);
    nodecount++;
  }
  
  private BSTNode<E> inserthelp(BSTNode<E> rt, E value) {
	  if(rt == null) return new BSTNode<E>(value) ;
	  if (rt.value().compareTo(value) >= 0)
		  // rt value > key
		  rt.setLeft(inserthelp(rt.left(), value));
	  else // rt value <= leu
		  rt.setRight(inserthelp(rt.right(), value));
	  return rt;
  }

  // Remove a record from the tree
  // key: The key value of record to remove
  // Returns the record removed, null if there is none.
  public E remove(E key) {
    E temp = findhelp(root, key); // First find it
    if (temp != null) {
      root = removehelp(root, key); // Now remove it
      nodecount--;
    }
    return temp;
  }
  
  private BSTNode<E> removehelp(BSTNode<E> rt, E key) {
	  if (rt == null) return null;
	  if (rt.value().compareTo(key) > 0)
		  rt.setLeft(removehelp(rt.left(),key));
	  else if (rt.value().compareTo(key) < 0)
		  rt.setRight(removehelp(rt.right(), key));
	  else { // found it
		  if (rt.left() == null) return rt.right();
		  else if (rt.right() == null) return rt.left();
		  else { // two children
			  BSTNode<E> temp = getmax(rt.left());
			  rt.setValue(temp.value());
			  rt.setLeft(deletemax(rt.left()));
		  }
	  }
	  return rt;
  }
  
  private BSTNode<E> deletemax(BSTNode<E> rt){
	  if (rt.right() == null)  return rt.left();
	  rt.setRight(deletemax(rt.right()));
	  return rt;
  }
  
  private BSTNode<E> getmax(BSTNode<E> rt){
	  if (rt.right() == null) return rt;
	  return getmax(rt.right());  
  }

  // Return the record with key value k, null if none exists
  // key: The key value to find
  public E find(E key) { return findhelp(root, key); }

  private E findhelp(BSTNode<E> rt, E key) {
	  if(rt == null) return null;
	  if (rt.value().compareTo(key) > 0)
		  // rt value > key
		  return findhelp(rt.left(), key);
	  else if (rt.value().compareTo(key) == 0)
		  // rt value is key
		  return rt.value();
	  else return findhelp(rt.right(), key);
  }
  
  // Return the number of records in the dictionary
  public int size() { return nodecount; }
  
  /** countLeafNodes method counts the leaf nodes using countLeafHelper to assist
   * 
   */
  public int countLeafNodes()
  {
	  
	  return countLeafHelper( root );
  }
  
  /** countLeafHelper method helps count the leaf nodes
   * 
   */
  private int countLeafHelper( BSTNode<E> node )
  {
	  //int totalLeaves;
	  if ( node == null ) return 0;
	 
	  if ( node.left() == null && node.right() == null ) return 1;
	  
	  else 
		  {
		  int totalLeaves = countLeafHelper( node.left() ) + countLeafHelper( node.right()) ;
		  return totalLeaves;
		  }
  }
  
  /** height method finds the height of tree using heightHelper method to assist
   * 
   */
  public int height()
  {
	 return heightHelper( root );
  }
  
  /** heightHelper method helps find the height of tree
   * 
   */
  private int heightHelper( BSTNode<E> node )
  {
	
	  if ( node == null ) return -1;
	  else
	  {
		  int ltHeight = heightHelper( node.left() );
		  int rtHeight = heightHelper( node.right() );
	 
		  if ( ltHeight > rtHeight )
			  return ltHeight + 1;
		  else
			  return rtHeight + 1;
	
	  }
	  
  }
  
  /** depthOf method finds depth of the key using depthOfHelper method to assist
   * 
   */
  public int depthOf( E e )
  {
	  if ( find(e) == null )
	  {
		  //System.out.println(e);
		  return -1;
	  }
	  else
	  return depthOfHelper( root, e );
  }
  
  /** depthOfHelper method helps finds depth of the key
   * 
   */
  private int depthOfHelper( BSTNode<E> node, E key)
  {
	  //System.out.println(node.value());
	  //System.out.println(key);
	  if ( node.value().compareTo( key ) == 0 ) return 0;
	  else if ( node.value().compareTo( key ) > 0 )
	  {
		  int ltDepth = depthOfHelper( node.left(), key );
		  return ltDepth + 1;
	  }
	  else
	  {
		  int rtDepth = depthOfHelper( node.right(), key );
	 	  return rtDepth + 1;
	  }
  }}
  

