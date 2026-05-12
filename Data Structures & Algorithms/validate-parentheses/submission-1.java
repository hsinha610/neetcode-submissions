class Solution {
    public boolean isValid(String s) {
        int l = s.length();
        Stack st = new Stack();
        for(int i=0;i<l;i++){
            char ele = s.charAt(i);

            if(ele == '(' || ele == '{' || ele == '['){
                st.push(ele);
            } else {
                if(ele == ')'){
                    if(!st.empty() && (char)st.peek() == '('){

                        st.pop();
                    } else {
                        return false ;
                    }
                } else if(ele == '}'){
                    if(!st.empty() && (char) st.peek() == '{'){
                        st.pop();
                    } else {
                        return false ;
                    }
                } else if(ele == ']'){
                    if(!st.empty() && (char)st.peek() == '['){
                        st.pop() ;
                    } else {
                        return false ;
                    }
                }
            }
        }
        return st.empty() ;
    }
}
