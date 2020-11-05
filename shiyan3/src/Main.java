/*
    Name:  linrui
    Date: 2019/4/24
*/

public class Main {
    public static void main(String[] args) {
        //五个进程的初始状态都为“就绪”，用“R”表示，当一个进程运行结束后，它的状态为“结束”，用“E”表示。
        Pcb pcb1 = new Pcb("进程1", null, 3, 5, 'R');
        Pcb pcb2 = new Pcb("进程2", null, 8, 9, 'R');
        Pcb pcb3 = new Pcb("进程3", null, 6, 5, 'R');
        Pcb pcb4 = new Pcb("进程4", null, 4, 6, 'R');
        Pcb pcb5 = new Pcb("进程5", null, 5, 4, 'R');

        Pcb pcbArray[] = new Pcb[]{pcb1, pcb2, pcb3, pcb4, pcb5};
        while(pcbArray.length != 0){
//        while(true){
            Method method = new Method();
            method.status(pcbArray);
            method.createQueue(pcbArray);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("======================================");
        }
    }
}
