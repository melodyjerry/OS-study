package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadFrame implements ActionListener {
    JFrame jframe; //创建窗体
    Panel panel; //创建面板
    Label label_title; //创建标签
    Label label_1;
    Label label_2;
    Label label_3;
    TextField textField; //创建文本框
    TextArea textArea; //创建文本域
    Button btn; //创建按钮
    JProgressBar jpb; //创建进度条

    /**
     * 无参构造子
     * 创建实体窗口
     */
    public ThreadFrame() {
        //更换外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);
//        jframe.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

        //创建窗体
        jframe = new JFrame("多线程实现阶乘计算");
        jframe.setBounds(600, 100, 600, 400);//设置大小
        jframe.setVisible(true);//显示窗体
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束进程

        //创建面板
        panel=new Panel();
        panel.setBackground(Color.white);//设置背景颜色
        panel.setLayout(null);//取消默认布局
        jframe.add(panel);

        //创建标签
        label_title=new Label("多线程实现阶乘计算");
        label_1=new Label("计算过程：");
        label_2=new Label("读取结果：");
//        label_3=new Label("计算进度：");
        label_title.setBounds(jframe.size().width/2-75, 10, 200, 50);
        label_1.setBounds(30, 100, 60, 20);
        label_2.setBounds(30, 160, 60, 20);
//        label_3.setBounds(30, 220, 60, 20);
        label_title.setFont(new Font("宋体", 1, 16));//设置字体
        panel.add(label_title);
        panel.add(label_1);
        panel.add(label_2);
//        panel.add(label_3);

        //创建文本域
        textArea=new TextArea();
        textArea.setBounds(100, 80, 360, 60);
        textArea.setEditable(false);//不可编辑
        panel.add(textArea);

        //创建单行文本框
        textField=new TextField("0");
        textField.setBounds(textArea.getX(), 160, textArea.size().width, 20);
        textField.setEditable(false);//不可编辑
        panel.add(textField);

        //创建按钮
        btn=new Button("开始计算");
        btn.setBounds(jframe.size().width/2-35, 270, 70, 30);
        panel.add(btn);
        btn.addActionListener(this);//添加监听器

        //创建进度条
        jpb=new JProgressBar();
        jpb.setBounds(textArea.getX(), textField.getY()+textField.size().height+20, textField.size().width, 20);
        jpb.setMaximum(12);//设置最大值
        panel.add(jpb);
    }

    /**
     * 开始计算按钮 的绑定事件
     * 重写 接收操作事件的侦听器接口
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //调用阶乘和计算线程
        new Thread(new FactorialSumThread("阶乘和计算线程")).start();
//        FactorialSumThread fst = new FactorialSumThread("阶乘和计算线程");
//        Thread Tfst = new Thread(fst);

        //调用读取线程
        new Thread(new ReadFactorialSumThread("读取线程", this)).start();
//        ReadFactorialSumThread rfst = new ReadFactorialSumThread("读取线程");
//        Thread Trfst = new Thread(rfst);
    }
}
