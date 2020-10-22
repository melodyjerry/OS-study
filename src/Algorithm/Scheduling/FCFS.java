package Algorithm.Scheduling;

/**
 * @Classname FCFS
 * @Description TODO
 * @Date 2020/10/22 20:49
 * @Created by jerry
 */
import java.util.Scanner;

/**
 * 响应比=等待时间/运行时间+1
 * 周转时间=完成时间-到达时 间
 * 带权周转时间=周转时间/运行时间
 */
public class FCFS {
    public static int processNumber; //作业数量
    public int[] arriveTime; //到达时间
    public int[] serviceTime; //执行时长
    public int[] processOrder; //调度顺序

    public int[] startTime; //开始时间
    public int[] waitTime; //等待时间
    public int[] completeTime; //完成时间
    public int[] turnAroundTime; //周转时间
    public int[] turnAroundTimeWithWeight; //平均周转时间

    public int getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(int processNumber) {
        this.processNumber = processNumber;
    }

    /*public int[] getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int[] arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int[] getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int[] serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int[] getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(int[] processOrder) {
        this.processOrder = processOrder;
    }

    public int[] getStartTime() {
        return startTime;
    }

    public void setStartTime(int[] startTime) {
        this.startTime = startTime;
    }

    public int[] getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int[] waitTime) {
        this.waitTime = waitTime;
    }

    public int[] getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int[] completeTime) {
        this.completeTime = completeTime;
    }

    public int[] getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int[] turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int[] getTurnAroundTimeWithWeight() {
        return turnAroundTimeWithWeight;
    }

    public void setTurnAroundTimeWithWeight(int[] turnAroundTimeWithWeight) {
        this.turnAroundTimeWithWeight = turnAroundTimeWithWeight;
    }*/

    private void FCFS() {
        System.out.println("<<< 操作后 >>>");
        System.out.println("到达时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(arriveTime[j] + "\t");
        }
        System.out.println("\n执行时长:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(serviceTime[j] + "\t");
        }

        System.out.println("\n::::::\n");

        //todo
        //第一个作业执行
        startTime[0] = arriveTime[0];
        completeTime[0] = arriveTime[0] + serviceTime[0];
        startTime[0] = arriveTime[0];
        turnAroundTime[0] = completeTime[0] - arriveTime[0]; //周转时间
        turnAroundTimeWithWeight[0] = turnAroundTime[0]
                / serviceTime[0];

        //todo
        for (int i = 1; i < processNumber ; i++) {
            startTime[i] = completeTime[i - 1];
            waitTime[i] = startTime[i] - arriveTime[i];
            completeTime[i] = arriveTime[i] + waitTime[i]
                    + serviceTime[i];
            turnAroundTime[i] = completeTime[i] - arriveTime[i]; //周转时间=等待时间+运行时间
            turnAroundTimeWithWeight[i] = turnAroundTime[i]
                    / serviceTime[i]; //带权周转时间=周转时间/运行时间
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FCFS os_fcfs = new FCFS();
        System.out.println("<<< 操作前 >>>");
        System.out.println("作业数量:");
        os_fcfs.setProcessNumber(sc.nextInt());

        os_fcfs.arriveTime = new int[os_fcfs.processNumber];
        os_fcfs.serviceTime = new int[os_fcfs.processNumber];
        os_fcfs.startTime = new int[os_fcfs.processNumber];
        os_fcfs.waitTime = new int[os_fcfs.processNumber];
        os_fcfs.completeTime = new int[os_fcfs.processNumber + 1];
        os_fcfs.turnAroundTime = new int[os_fcfs.processNumber + 1];
        os_fcfs.turnAroundTimeWithWeight = new int[os_fcfs.processNumber + 1];

        System.out.println("到达时间:");
        for (int j = 0; j < processNumber; j++) {
            os_fcfs.arriveTime[j] = sc.nextInt();
        }
        System.out.println("执行时长:");
        for (int j = 0; j < processNumber; j++) {
            os_fcfs.serviceTime[j] = sc.nextInt();
        }

        os_fcfs.FCFS();


        System.out.println("\n开始时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(os_fcfs.startTime[j] + "\t");
        }
        System.out.println("\n等待时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(os_fcfs.waitTime[j] + "\t");
        }
        System.out.println("\n完成时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(os_fcfs.completeTime[j] + "\t");
        }
        System.out.println("\n周转时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(os_fcfs.turnAroundTime[j] + "\t");
        }
        /*System.out.println("平均周转时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print( + "\t");
        }*/
        System.out.println("\n带权周转时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print(os_fcfs.turnAroundTimeWithWeight[j] + "\t");
        }
        /*System.out.println("平均带权周转时间:");
        for (int j = 0; j < processNumber; j++) {
            System.out.print( + "\t");
        }*/
    }
}

