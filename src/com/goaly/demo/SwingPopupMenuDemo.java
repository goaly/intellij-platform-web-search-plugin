/**
 * Copyright (C), 2023-2033
 */
package com.goaly.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * Swing弹出菜单测试
 *
 * @author: lys
 * @date: 2023/5/27 18:05
 */
public class SwingPopupMenuDemo {

    public static void main(String[] args) {
//        buildPopupMenuWithItem();
        buildPopupMenuWithAction();
    }

    /**
     * 用MenuItem创建弹出菜单
     */
    private static void buildPopupMenuWithItem() {

        JFrame frame = new JFrame();
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenu menu = new JMenu("网页搜索");

        JMenuItem menuItem1 = new JMenuItem("必应搜索");
        JMenuItem menuItem2 = new JMenuItem("百度搜索");
        JMenuItem menuItem3 = new JMenuItem("搜狗搜索");

        ActionListener actionListener = e -> System.out.println(e.getActionCommand());

        menuItem1.addActionListener(actionListener);
        menuItem2.addActionListener(actionListener);
        menuItem3.addActionListener(actionListener);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        popupMenu.add(menu);
        contentPane.setComponentPopupMenu(popupMenu);
        frame.setSize(300, 200);
        frame.setLocation(500, 500);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    /**
     * 用Action创建弹出菜单
     */
    private static void buildPopupMenuWithAction() {

        JFrame frame = new JFrame();
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenu menu = new JMenu("网页搜索");

        WebSearchAction action1 = new WebSearchAction("必应搜索");
        WebSearchAction action2 = new WebSearchAction("百度搜索");
        WebSearchAction action3 = new WebSearchAction("搜狗搜索");
        menu.add(action1);
        menu.add(action2);
        menu.add(action3);

        popupMenu.add(menu);
        contentPane.setComponentPopupMenu(popupMenu);
        frame.setSize(300, 200);
        frame.setLocation(500, 500);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    /**
     * 自定义网页搜索Action
     */
    static class WebSearchAction extends AbstractAction {

        public WebSearchAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

}