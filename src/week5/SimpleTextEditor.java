package week5;

public class SimpleTextEditor {
    private String s;
    private Stack history =new Stack();

    SimpleTextEditor(String s) {
        this.s = s;
        history.push(s);
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    /**
     * This method edits text using your commands.
     *
     * @param ops array of String of operations
     */
    public void operation(String[] ops){
        for (int i=0;i<ops.length;i++){
            char op=ops[i].charAt(0);
            switch (op){
                case '1':
                    ops[i]=ops[i].substring(2);
                    this.append(ops[i]);
                    break;
                case '2':
                    int k=(int) ops[i].charAt(2)-48;
                    this.delete(k);
                    break;
                case '3':
                    int j=(int) ops[i].charAt(2)-48;
                    this.print(j);
                    break;
                case '4':
                    this.undo();
                    break;
                default:
                    System.out.println("invalid operation");
            }
        }
    }

    private void append(String a){
        this.s=this.s.concat(a);
        this.history.push(this.s);
    }

    private void delete(int k){
        this.s=this.s.substring(0,s.length()-k);
        this.history.push(this.s);
    }

    private void print(int j){
        System.out.println(this.s.charAt(j));
    }

    private void undo(){
        if (this.history.size()>1){
            this.history.pop();
            this.s=(String) history.peek();
        } else {
            System.out.println("Cannot undo because it's the first version");
        }
    }

    public static void main(String[] args) {
        SimpleTextEditor a=new SimpleTextEditor("abcde");
        String[] b={"3","1 fg","3","2 2","3","4","3","4","3"};
        a.operation(b);
    }
}