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

import java.util.ArrayList;

public class BackCommand extends Command {
    /**
     * 执行命令.
     *
     * @param game
     * @return 成功返回false.
     */
    @Override
    public boolean execute(final Game game) {
        ArrayList<Room> historyRoom = game.getHistoryRooms();
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
        if (historyRoom == null || historyRoom.size() < num || num <= 0) {
            System.out.println("You haven't been to any room or the historical "
                    + "rooms is not longer than what you want to back.");
        } else {
            Room currentRoom = historyRoom.get(historyRoom.size() - num);
            game.setCurrentRoom(currentRoom);
            System.out.println("You have returned to the last room.");
            System.out.println(currentRoom.getLongDescription());
        }
        return false;
    }
}
