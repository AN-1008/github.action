/**
 * 该类是“World-of-Zuul”应用程序的一部分.
 * 《World of Zuul》是一款简单的文本冒险游戏.用户可以在一些房间组成的迷宫中探险.
 * <p>
 * 这个类用于存储游戏中所有可以被识别为有效命令的单词，用于在输入命令时对命令进行识别.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Iterator;

public class CommandWords {
    /**
     * 命令对应command对象.
     */
    private HashMap<String, Command> commands;

    /**
     * 初始化变量.
     */
    public CommandWords() {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("look", new LookCommand());
        commands.put("back", new BackCommand());
        commands.put("stay", new StayCommand());
    }

    /**
     * 返回用户输入命令对应命令对象.
     *
     * @param word
     * @return 返回用户输入命令对应命令对象.
     */
    public Command get(final String word) {
        return (Command) commands.get(word);
    }

    /**
     * 显示所有命令.
     */
    public void showAll() {
        for (Iterator i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }
}
