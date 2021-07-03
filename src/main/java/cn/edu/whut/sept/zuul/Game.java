/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * <p>
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * <p>
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏.
 *
 * @author Team wggg
 * @version 2021.7.2
 */

package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.HashSet;

//public enum weight{
//    3,13,50,100,200;
//}

public class Game {
    /**
     * 定义命令解析器.
     */
    private Parser parser;
    /**
     * 定义房间.
     */
    private Room currentRoom;
    /**
     * 定义历史房间记录.
     */
    private ArrayList<Room> historyRooms;
    /**
     * 定义所有房间集合.
     */
    private ArrayList<Room> rooms;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game() {
        rooms = new ArrayList<Room>();
        parser = new Parser();
        historyRooms = new ArrayList<Room>();
        createRooms();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms() {
        // create the goods
        Goods water = new Goods(3, "Water is used for drinking.");
        Goods platform = new Goods(200, "A platform is a platform above the "
                + "ground on which the speaker or lecturer stands to speak.");
        Goods wine = new Goods(13, "Wine is a kind of alcoholic beverage "
                + "fermented with starch or sugar in grains and fruits.");
        Goods equipment = new Goods(100, "Equipment refers to the "
                + "instruments and tools needed for experiments.");
        Goods desk = new Goods(100, "Desk refers to the daily life"
                + ", work and social activities for the convenience of work with the table.");
        Goods chair = new Goods(50, "Chair refers to all kinds of chairs "
                + "for convenience in daily work and social activities.");
        // create the rooms

        //Room outside, theater, pub, lab, office, magicRoom;
        Room outside = new Room("outside the main entrance of the university");
        Room theater = new Room("in a lecture theater");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the computing admin office");
        Room magicRoom = new Room("in the magic room, you will be "
                + "transported to a random room");

        //initialise goods
        HashSet<Goods> goods = new HashSet<Goods>();
        goods.add(water);
        goods.add(platform);
        theater.setGoods(goods);
        goods = new HashSet<Goods>();
        goods.add(wine);
        pub.setGoods(goods);
        goods = new HashSet<Goods>();
        goods.add(equipment);
        lab.setGoods(goods);
        goods = new HashSet<Goods>();
        goods.add(desk);
        goods.add(chair);
        office.setGoods(goods);

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", magicRoom);
        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        magicRoom.setMagic(true);
        rooms.add(outside);
        rooms.add(theater);
        rooms.add(pub);
        rooms.add(lab);
        rooms.add(office);
        currentRoom = outside;  // start game outside
    }

    /**
     * 游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if (command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 获取所有房间.
     *
     * @return 返回所有房间集合.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * 设置所有房间.
     *
     * @param paramRooms
     */
    public void setRooms(final ArrayList<Room> paramRooms) {
        this.rooms = paramRooms;
    }

    /**
     * @return 返回当前房间.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 设置当前房间.
     *
     * @param room
     */
    public void setCurrentRoom(final Room room) {
        this.currentRoom = room;
    }

    /**
     * 获得历史房间记录.
     *
     * @return 历史房间
     */
    public ArrayList<Room> getHistoryRooms() {
        return historyRooms;
    }
}
