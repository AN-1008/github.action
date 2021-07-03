/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * HelpCommand类是用于执行用户输入的Helpo命令的类
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

public class HelpCommand extends Command {
    /**
     * 命令单词.
     */
    private CommandWords commandWords;

    /**
     * 初始化命令HelpCommand.
     *
     * @param words
     */
    public HelpCommand(final CommandWords words) {
        commandWords = words;
    }

    /**
     * 执行help指令，在终端打印游戏帮助信息.
     *
     * @param game
     * @return 输出游戏中用户可以输入的命令列表.
     */
    public boolean execute(final Game game) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
