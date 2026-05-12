class MinStack {
    Stack st = new Stack();
    Stack mSt = new Stack();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.empty()){
            st.push(val);
            mSt.push(val);
        } else {
            st.push(val);
            if(val<= (int)mSt.peek()){
                mSt.push(val);
            }
        }
    }
    
    public void pop() {
        int ele = (int) st.pop();
        if(ele > (int)mSt.peek()){

        } else {
            mSt.pop();
        }
    }
    
    public int top() {
        return (int) st.peek();
    }
    
    public int getMin() {
        return (int)mSt.peek();
    }
}
