package Algorithm.Scheduling;

import java.util.Scanner;

/**
 * SJF最短作业优先算法
 *
 * 完成时间 = 开始时间 + 需要运行时间
 * 周转时间 = 完成时间 - 到达时间
 * 带权周转时间 = 周转时间 / 需要运行时间
 */
public class SJF {

    public static double[] quickSort(double[] a, int low, int high) {
        if(low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
        return a;
    }

    private static int getMiddle(double[] a, int low, int high) {
        double temp = a[low];
        while (low < high) {
            //从右向左找比基准小的元素并交换
            while(low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            //从左往右找比基准大的元素并交换
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void SJF(Job job) {
        System.out.println("<<< 操作后 >>>");
        System.out.println("到达时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.arriveTime[j] + "\t");
        }
        System.out.println("\n执行时长:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.serviceTime[j] + "\t");
        }

        //todo
        quickSort(job.serviceTime, 0, job.serviceTime.length - 1);

        //todo
        //第一个作业执行
        job.startTime[0] = job.arriveTime[0];
        job.completeTime[0] = job.arriveTime[0] + job.serviceTime[0];
        job.startTime[0] = job.arriveTime[0];
        job.turnAroundTime[0] = job.completeTime[0] - job.arriveTime[0]; //周转时间
        job.turnAroundTimeWithWeight[0] = job.turnAroundTime[0]
                / job.serviceTime[0];

        //todo
        for (int i = 1; i < job.processNumber ; i++) {
            job.startTime[i] = job.completeTime[i - 1];
            job.waitTime[i] = job.startTime[i] - job.arriveTime[i];
            job.completeTime[i] = job.arriveTime[i] + job.waitTime[i]
                    + job.serviceTime[i];
            job.turnAroundTime[i] = job.completeTime[i] - job.arriveTime[i]; //周转时间=等待时间+运行时间
            job.turnAroundTimeWithWeight[i] = job.turnAroundTime[i]
                    / job.serviceTime[i]; //带权周转时间=周转时间/运行时间
        }

        double temp1 = 0, temp2 = 0;
        for (int i = 0; i < job.getProcessNumber(); i++) {
            temp1 += job.turnAroundTime[i];
            temp2 += job.turnAroundTimeWithWeight[i];
        }
        job.averageTurnAroundTime = temp1 / job.getProcessNumber();
        job.averageTurnAroundTimeWithWeight = temp2 / job.getProcessNumber();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Job job = new Job();
        System.out.println("<<< 操作前 >>>");
        System.out.println("作业数量:");
        job.setProcessNumber(sc.nextInt());

        job.arriveTime = new double[job.getProcessNumber()];
        job.serviceTime = new double[job.getProcessNumber()];
        job.startTime = new double[job.getProcessNumber()];
        job.waitTime = new double[job.getProcessNumber()];
        job.completeTime = new double[job.getProcessNumber() + 1];
        job.turnAroundTime = new double[job.getProcessNumber() + 1];
        job.turnAroundTimeWithWeight = new double[job.getProcessNumber()];

        System.out.println("到达时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            job.arriveTime[j] = sc.nextInt();
        }
        System.out.println("执行时长:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            job.serviceTime[j] = sc.nextInt();
        }

        SJF(job);

        System.out.println("\n开始时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.startTime[j] + "\t");
        }
        System.out.println("\n等待时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.waitTime[j] + "\t");
        }
        System.out.println("\n完成时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.completeTime[j] + "\t");
        }
        System.out.println("\n周转时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.turnAroundTime[j] + "\t");
        }
        System.out.println("\n平均周转时间:\n" +
                job.averageTurnAroundTime);
        System.out.println("带权周转时间:");
        for (int j = 0; j < job.getProcessNumber(); j++) {
            System.out.print(job.turnAroundTimeWithWeight[j] + "\t");
        }
        System.out.println("\n平均带权周转时间:\n" +
                job.averageTurnAroundTimeWithWeight);
    }

}
