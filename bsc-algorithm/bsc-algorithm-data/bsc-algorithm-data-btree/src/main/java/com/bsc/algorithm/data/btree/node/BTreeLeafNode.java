package com.bsc.algorithm.data.btree.node;

public class BTreeLeafNode<K extends Comparable<K>> extends AbstractBTreeNode<K> {  
  
    private final Object[] keys;
    private int nkey;  
  
    public BTreeLeafNode(int degree){  
        super(degree);  
        keys = new Object[2*degree - 1];  
    }  
  
  
    @Override  
    protected boolean isLeaf() {  
        return true;  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    K search(K key) {  
        int index = indexOfKey(key);  
        if (index >=0)  
            return (K) keys[index];  
        return null;  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    K getKey(int idx) {  
        return (K) keys[idx];  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    protected K setKey(K newKey, int oldKeyIndex) {  
        K old = (K) keys[oldKeyIndex];  
        keys[oldKeyIndex] = newKey;  
        return old;  
    }  
  
    @Override  
    protected void setChild(AbstractBTreeNode<K> sub, int index) {  
        throw new RuntimeException("Could not set child of leaf node.");  
    }  
  
    @Override  
    public  AbstractBTreeNode<K> getChild(int index) {  
        return null;  
    }  
  
    @Override  
    public void splitChild(int child) {  
        throw new  RuntimeException("Could not split child of leaf node.");  
    }  
  
    @Override  
    protected int setNKey(int nkey) {  
        int old = this.nkey;  
        this.nkey = nkey;  
        return old;  
    }  
  
    @Override  
    public int nkey() {  
        return nkey;  
    }  
  
    @Override  
    int nchild() {  
        return 0;  
    }  
  
    @Override  
    protected int setNChild(int nchild) {  
        throw new RuntimeException("Could set NChild of leaf node.");  
    }  
  
    @Override  
    public void insertNotFull(K key) {  
        checkNotFull();  
        this.insertKey(key);  
    }  
  
    @Override  
    public void deleteNotEmpty(K key) {  
        this.deleteKey(key);  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    protected K splitSelf(AbstractBTreeNode<K> newNode) {  
        if (! (newNode instanceof BTreeLeafNode)){  
            throw new RuntimeException("Instance not match.");  
        }  
        if (!isFull()){  
            throw new RuntimeException("Node is not full");  
        }  
  
        K middle = (K)keys[degree -1];  
        BTreeLeafNode<K> node = (BTreeLeafNode<K>)newNode;  
        int i = 0;  
        while (i < degree-1){  
            node.keys[i] = this.keys[i + degree];  
            this.keys[i + degree] = null;  
            i++;  
        }  
        this.keys[degree -1] = null;  
        this.nkey = degree -1;  
        node.nkey = degree -1;  
        return middle;  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    protected void merge(K middle, AbstractBTreeNode<K> sibling) {  
        if ( !(sibling instanceof BTreeLeafNode)){  
            throw new RuntimeException("Sibling is not leaf node");  
        }  
        BTreeLeafNode<K> node = (BTreeLeafNode<K>)sibling;  
        this.insertKey(middle);  
        for (int i = 0; i < node.nkey(); i++){  
            this.insertKey((K)node.keys[i]);  
        }  
    }  
  
    @Override  
    public String toString() {  
        StringBuffer sb = new StringBuffer();  
        sb.append("leaf----").append("size: ").append(nkey).append(" keys:").append("[");  
        for(int i = 0; i < nkey; i++){  
            sb.append(keys[i]).append(",");  
        }  
        sb.append("]");  
        return sb.toString();  
    }  
  
} 