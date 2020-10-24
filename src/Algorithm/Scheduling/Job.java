package Algorithm.Scheduling;

import java.util.Arrays;

/**
 * @Classname Job
 * @Description 作业/任务信息
 */
public class Job {
    public static int processNumber; //作业数量
    public int[] arriveTime; //到达时间
    public int[] serviceTime; //执行时长
    public int[] processOrder; //调度顺序

    public int[] startTime; //开始时间
    public int[] waitTime; //等待时间
    public int[] completeTime; //完成时间
    public int[] turnAroundTime; //周转时间
    public int averageTurnAroundTime; //平均周转时间
    public int[] turnAroundTimeWithWeight; //带权周转时间
    public int averageTurnAroundTimeWithWeight; //平均带权周转时间

    public static int getProcessNumber() {
        return processNumber;
    }

    public static void setProcessNumber(int processNumber) {
        Job.processNumber = processNumber;
    }

    public int[] getArriveTime() {
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

    public int getAverageTurnAroundTime() {
        return averageTurnAroundTime;
    }

    public void setAverageTurnAroundTime(int averageTurnAroundTime) {
        this.averageTurnAroundTime = averageTurnAroundTime;
    }

    public int[] getTurnAroundTimeWithWeight() {
        return turnAroundTimeWithWeight;
    }

    public void setTurnAroundTimeWithWeight(int[] turnAroundTimeWithWeight) {
        this.turnAroundTimeWithWeight = turnAroundTimeWithWeight;
    }

    public int getAverageTurnAroundTimeWithWeight() {
        return averageTurnAroundTimeWithWeight;
    }

    public void setAverageTurnAroundTimeWithWeight(int averageTurnAroundTimeWithWeight) {
        this.averageTurnAroundTimeWithWeight = averageTurnAroundTimeWithWeight;
    }

    @Override
    public String toString() {
        return "Job{" +
                "arriveTime=" + Arrays.toString(arriveTime) +
                ", serviceTime=" + Arrays.toString(serviceTime) +
                ", processOrder=" + Arrays.toString(processOrder) +
                ", startTime=" + Arrays.toString(startTime) +
                ", waitTime=" + Arrays.toString(waitTime) +
                ", completeTime=" + Arrays.toString(completeTime) +
                ", turnAroundTime=" + Arrays.toString(turnAroundTime) +
                ", averageTurnAroundTime=" + averageTurnAroundTime +
                ", turnAroundTimeWithWeight=" + Arrays.toString(turnAroundTimeWithWeight) +
                ", averageTurnAroundTimeWithWeight=" + averageTurnAroundTimeWithWeight +
                '}';
    }
}
