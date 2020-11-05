/*
    Name:  linrui
    Date: 2019/4/24
*/

//创建Pcb类
public class Pcb {
    private String pcbname;     //pcb名
    private Pcb next;           //指向下一个进程
    private int runtime;        //运行时间
    private int priorvalue;     //进程优先级
    private char status;        //进程状态

    //构造方法
    public Pcb(String pcbname, Pcb next, int runtime, int priorvalue, char status) {
        this.pcbname = pcbname;
        this.next = next;
        this.runtime = runtime;
        this.priorvalue = priorvalue;
        this.status = status;
    }


    public String getPcbname() {
        return pcbname;
    }

    public void setPcbname(String pcbname) {
        this.pcbname = pcbname;
    }

    public Pcb getNext() {
        return next;
    }

    public void setNext(Pcb next) {
        this.next = next;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getPriorvalue() {
        return priorvalue;
    }

    public void setPriorvalue(int priorvalue) {
        this.priorvalue = priorvalue;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

}
