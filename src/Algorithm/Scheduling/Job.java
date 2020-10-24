package Algorithm.Scheduling;

import java.util.Arrays;

/**
 * @Classname Job
 * @Description 作业/任务信息
 */
public class Job {
    public static int processNumber; //作业数量
    public double[] arriveTime; //到达时间
    public double[] serviceTime; //执行时长
    public double[] processOrder; //调度顺序

    public double[] startTime; //开始时间
    public double[] waitTime; //等待时间
    public double[] completeTime; //完成时间
    public double[] turnAroundTime; //周转时间
    public double averageTurnAroundTime; //平均周转时间
    public double[] turnAroundTimeWithWeight; //带权周转时间
    public double averageTurnAroundTimeWithWeight; //平均带权周转时间

    public static int getProcessNumber() {
        return processNumber;
    }

    public static void setProcessNumber(int processNumber) {
        Job.processNumber = processNumber;
    }

    public double[] getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double[] arriveTime) {
        this.arriveTime = arriveTime;
    }

    public double[] getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double[] serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double[] getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(double[] processOrder) {
        this.processOrder = processOrder;
    }

    public double[] getStartTime() {
        return startTime;
    }

    public void setStartTime(double[] startTime) {
        this.startTime = startTime;
    }

    public double[] getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(double[] waitTime) {
        this.waitTime = waitTime;
    }

    public double[] getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(double[] completeTime) {
        this.completeTime = completeTime;
    }

    public double[] getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(double[] turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public double getAverageTurnAroundTime() {
        return averageTurnAroundTime;
    }

    public void setAverageTurnAroundTime(double averageTurnAroundTime) {
        this.averageTurnAroundTime = averageTurnAroundTime;
    }

    public double[] getTurnAroundTimeWithWeight() {
        return turnAroundTimeWithWeight;
    }

    public void setTurnAroundTimeWithWeight(double[] turnAroundTimeWithWeight) {
        this.turnAroundTimeWithWeight = turnAroundTimeWithWeight;
    }

    public double getAverageTurnAroundTimeWithWeight() {
        return averageTurnAroundTimeWithWeight;
    }

    public void setAverageTurnAroundTimeWithWeight(double averageTurnAroundTimeWithWeight) {
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
