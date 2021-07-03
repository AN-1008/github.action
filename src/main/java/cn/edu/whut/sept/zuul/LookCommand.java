/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * LookCommand类是用于执行用户输入的Go命令的类.
 * 接收用户输入，查看房间内物品信息.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

import java.util.HashSet;
import java.util.Iterator;

public class LookCommand extends Command {
    /**
     * 执行look指令，在终端打印游戏物品信息.
     *
     * @param game
     * @return 输出游戏中用户可以输入的命令列表.
     */
    @Override
    public boolean execute(final Game game) {
        Room currentRoom = game.getCurrentRoom();
        HashSet<Goods> goods = currentRoom.getGoods();
        Iterator<Goods> it = goods.iterator();
        if (goods.size() == 0 || goods == null) {
            System.out.println("There is nothing.");
        } else {
            System.out.println("There has some goods as bellow.");
            for (Goods good : goods) {
                System.out.println(good.getDescription());
            }
        }
        return false;
    }
}
