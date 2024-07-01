package udemyds.bst;

public interface Tree <T>{

    public void insert(T data);
    public void remove(T data);
    public void traversal(); // natural order - inorder
    public T getMin();
    public T getMax();
}
