import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadFrame implements ActionListener {//创建面板
    JFrame jframe;//创建窗体
    Panel panel;//创建面板
    Label label_title;//创建标签
    Label label_1;
    Label label_2;
    Label label_3;
    TextField textFile;//创建文本框
    TextArea textArea;//创建文本域
    Button btn;//创建按钮
    JProgressBar jpb;//创建进度条


    ThreadFrame(){
//创建窗体
        jframe=new JFrame("线程");//设置窗体名称
        jframe.setBounds(600, 100, 400, 400);//设置大小
        jframe.setVisible(true);//设置课件
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束进程

//创建面板
        panel=new Panel();
        panel.setBackground(Color.white);//设置背景颜色
        panel.setLayout(null);//取消默认布局
        jframe.add(panel);

//创建标签
        label_title=new Label("多线程实验");
        label_1=new Label("计算线程：");
        label_2=new Label("计算进度：");
        label_3=new Label("计算读取：");
        label_title.setBounds(jframe.size().width/2-50, 10, 100, 50);
        label_1.setBounds(30, 100, 60, 20);
        label_2.setBounds(30, 160, 60, 20);
        label_3.setBounds(30, 220, 60, 20);
        label_title.setFont(new Font("宋体", 1, 16));//设置字体
        panel.add(label_title);
        panel.add(label_1);
        panel.add(label_2);
        panel.add(label_3);

//创建文本域
        textArea=new TextArea();
        textArea.setBounds(100, 80, 200, 60);
        textArea.setEditable(false);//不可编辑
        panel.add(textArea);

//创建单行文本框
        textFile=new TextField("0");
        textFile.setBounds(textArea.getX(), 220, textArea.size().width, 20);
        textFile.setEditable(false);//不可编辑
        panel.add(textFile);

//创建按钮
        btn=new Button("开始计算");
        btn.setBounds(jframe.size().width/2-35, 270, 70, 30);
        panel.add(btn);
        btn.addActionListener(this);//添加监听器

//创建进度条
        jpb=new JProgressBar();
        jpb.setBounds(textArea.getX(), textArea.getY()+textArea.size().height+10, textArea.size().width, 40);
        jpb.setMaximum(30);//设置最大值
        panel.add(jpb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//按钮点击事件
// TODO Auto-generated method stub
//调用计算线程
        ComputeThread ct=new ComputeThread();
        Thread tc=new Thread(ct);
//调用读取线程
        ReadThread rt=new ReadThread(this);
        Thread tr=new Thread(rt);
//开始线程
        tc.start();
        tr.start();
    }
}