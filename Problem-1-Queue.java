class MyQueue {

    Node head;
    Node tail;
    int size = 0;
    public MyQueue() {
        head = null;
        tail = null;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
        size++;
    }
    
    public int pop() {
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
    
    public int peek() {
        return (head.data);
    }
    
    public boolean empty() {
        return (size == 0);
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
