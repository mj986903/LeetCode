class MyStack {

    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }

    private static void reverseQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
    }
    
    public int pop() {
        reverseQueue(q);
        int popElement = q.poll();
        reverseQueue(q);
        return popElement;
    }
    
    public int top() {
        reverseQueue(q);
        int topElement = q.peek();
        reverseQueue(q);
        return topElement;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */