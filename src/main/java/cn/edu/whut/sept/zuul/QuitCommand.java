/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * QuitCommand类是用于执行用户输入的Quit命令的类
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏.
 *
 * @author Team wggg
 * @version 2021.7.2
 */

package cn.edu.whut.sept.zuul;

public class QuitCommand extends Command {
    /**
     * 执行Quit指令，用户退出游戏。如果用户在命令中输入了其他参数，则进一步询问用户是否真的退出.
     *
     * @param game 游戏
     * @return 返回是否退出.
     */
    public boolean execute(final Game game) {
        if (hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
