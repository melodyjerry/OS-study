/*
    Name:  linrui
    Date: 2019/4/24
*/

//使用进程
public class Method {
    //判断当前进程状态，如果运行时间为0，把它改成结束状态
    public void status(Pcb pcb[]) {
        for (int i = 0; i < pcb.length; i++) {
            pcb[i].setNext(null);
            //运行时间=0，则把它的状态修改成“结束”（E）运行时间=0，则把它的状态修改成“结束”（E）
            if (pcb[i].getRuntime() == 0) {
                pcb[i].setStatus('E');
            }
        }
    }

    //把五个进程按给定的优先数从大到小连成队列。用一单元指出队首进程，用指针指出队列的连接情况。
    public LinkedQueue createQueue(Pcb pcb[]) {
        LinkedQueue linkedQueue = new LinkedQueue();
        //冒泡排序 按进程优先级进行排序
        for (int i = 0; i < pcb.length - 1; i++) {
            //两两交换循环
            for (int j = 0; j < pcb.length - 1 - i; j++) {
                //创建临时变量进行交换
                if (pcb[j].getPriorvalue() < pcb[j + 1].getPriorvalue()) {
                    Pcb tmp = pcb[j];
                    pcb[j] = pcb[j + 1];
                    pcb[j + 1] = tmp;
                }
            }
        }
        //进程每运行一次优先数就减“1”。并且其优先级减少,运行时间减少
        //优先级-1
        pcb[0].setPriorvalue(pcb[0].getPriorvalue() - 1);
        //时间-1
        pcb[0].setRuntime(pcb[0].getRuntime() - 1);

        //如果当前的进程不是结束状态，插入到队列中
        //处理器调度总是选队首进程运行。采用动态改变优先数的办法

        System.out.print("当前就绪的pcb为:");
        for (int i = 0; i < pcb.length; i++) {
            if (pcb[i].getStatus() != 'E') {
                linkedQueue.push(pcb[i]);

                System.out.print(" " + pcb[i].getPcbname());
            }
        }

        System.out.println();
        //打印运行后的队列
        linkedQueue.printPcb(linkedQueue.front);
        if(linkedQueue.front == null) {
            System.out.println("当前无进程");
            System.exit(1);
        }
        return linkedQueue;
    }
}
