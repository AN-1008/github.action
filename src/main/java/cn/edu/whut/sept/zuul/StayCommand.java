/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * BackCommand类是用于执行用户输入的back命令的类
 * 接收用户输入，返回用户上一次房间.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

public class StayCommand extends Command {
    /**
     * 设定进程睡眠时间.
     */
    static final int THREAD_SLEEP_TIME = 1000;
    /**
     * 执行stay命令.
     *
     * @param game
     * @return 成功返回false.
     */
    @Override
    public boolean execute(final Game game) {
        String secondCommand = getSecondWord();
        int num = 0;
        if (secondCommand == null) {
            num = 1;
        } else {
            try {
                num = Integer.parseInt(secondCommand);
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
                return false;
            }
        }
        try {
            Thread.sleep(num * THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("You have stayed for " + num + " seconds");
        return false;
    }
}
