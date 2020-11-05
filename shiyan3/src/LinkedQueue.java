/*
    Name:  linrui
    Date: 2019/4/24
*/

//创建进程队列
public class LinkedQueue {

    Pcb front;    //创建Pcb的头
    Pcb rear;     //创建Pcb的尾

    //队列插入
    public void push(Pcb pcb) {
        if (front == null && rear == null) {
            front = pcb;
            rear = pcb;
        } else {
            rear.setNext(pcb);
            rear = pcb;
        }
    }

    //出队列
    public Pcb pop() {
        if (front == null && rear == null) {
            System.out.println("队列为空");
        } else {
            Pcb oldfrout = front;
            front = front.getNext();
            return oldfrout;
        }
        return null;
    }

    //获取队列头
    public Pcb getFront() {
        return front;
    }

    //修改队列头
    public void setFront(Pcb front) {
        this.front = front;
    }

    public Pcb getRear() {
        return rear;
    }

    public void setRear(Pcb rear) {
        this.rear = rear;
    }


    public void printPcb(Pcb temp) {
        while (temp != null) {
            System.out.print("进程名为：" + temp.getPcbname());
            System.out.print("   ");
            System.out.print("运行时间为：" + temp.getRuntime());
            System.out.print("   ");
            System.out.print("优先级" + temp.getPriorvalue());
            System.out.print("   ");
            System.out.print("运行状态" + temp.getStatus());
            System.out.print("   ");
            if (temp.getNext() == null) {
                System.out.println();
            }
            if (temp.getNext() != null) {
                System.out.println("下一进程为：" + temp.getNext().getPcbname());
            }
            temp=temp.getNext();
        }
    }

}
