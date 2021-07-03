/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * GoCommand类是用于执行用户输入的Go命令的类
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.Random;

public class GoCommand extends Command {

    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     *
     * @param game
     * @return 返回是否执行成功，成功返回true，错误返回false.
     */
    public boolean execute(final Game game) {
        if (!hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
            return false;
        } else if (nextRoom.isMagic()) {
            Random random = new Random();
            ArrayList<Room> rooms = game.getRooms();
            int roomNum = random.nextInt(rooms.size());
            nextRoom = rooms.get(roomNum);
            System.out.println("you come into a magic room and you are "
                    + "transported to a random room.");
        }
        System.out.println(nextRoom.getLongDescription());
        game.setCurrentRoom(nextRoom);
        game.getHistoryRooms().add(currentRoom);
        return false;
    }
}
