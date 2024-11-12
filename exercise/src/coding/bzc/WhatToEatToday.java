package coding.bzc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WhatToEatToday extends JFrame {
    
    private JLabel label;
    private JButton button;

    public WhatToEatToday() {
        // 设置窗口标题
        setTitle("今天吃什么");
        // 设置窗口大小
        setSize(400, 200);
        // 设置关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置布局
        setLayout(new FlowLayout());

        // 创建标签
        label = new JLabel("");
        label.setFont(new Font("Serif", Font.PLAIN, 20));

        // 创建按钮
        button = new JButton("今天吃什么？");
        button.setFont(new Font("Serif", Font.PLAIN, 18));

        // 添加按钮的事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] menu = {"饺子","黄焖鸡","烧鹅","旧酸菜鱼","黄焖鸡","烧鹅","饺子","新酸菜鱼"};

                Random random = new Random();
                int count = random.nextInt(menu.length);
                label.setText(menu[count]);
            }
        });

        // 添加组件到窗口
        add(label);
        add(button);
    }

    public static void main(String[] args) {
        // 创建窗口实例
        WhatToEatToday frame = new WhatToEatToday();
        // 显示窗口
        frame.setVisible(true);
    }
}
