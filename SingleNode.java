public class SingleNode {
    private Object  value;
    private SingleNode next;
    
    public SingleNode(Object value) {
      this.value = value;
      this.next = null;
    }

    public Object getValue() {
      return value;
    }

    public SingleNode getNext() {
      return next;
    }

    public void setNext(SingleNode nextNode) {
      this.next = nextNode;
    }

}
