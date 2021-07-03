/**
 * 该类是“World-of-Zuul”应用程序的一部分.
 * 《World of Zuul》是一款简单的文本冒险游戏.用户可以在一些房间组成的迷宫中探险.
 * <p>
 * 这个Room类代表游戏场景中的一个位置.它是通过出口和其他房间相连.
 * 出口有东、西、南、北四个方向，房间会存储每个方向的相邻的房间，如果这个方向上没有房间则为null.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public class Room {
    /**
     * 房间描述.
     */
    private String description;
    /**
     * 是否为传送房间.
     */
    private boolean isMagic;
    /**
     * 定义方向和房间出口.
     */
    private HashMap<String, Room> exits;

    /**
     * 定义物品集合.
     */
    private HashSet<Goods> goods;

    /**
     * 创建房间并初始化房间的描述和房间的出口，初始化时它是没有出口的.
     *
     * @param paramDescription 对房间的描述.
     */
    public Room(final String paramDescription) {
        this.description = paramDescription;
        exits = new HashMap<>();
        goods = new HashSet<Goods>();
        isMagic = false;
    }

    /**
     * 返回是否为传送房间.
     *
     * @return 返回是否为传送房间.
     */
    public boolean isMagic() {
        return isMagic;
    }

    /**
     * 设置是否为传送房间.
     *
     * @param magic
     */
    public void setMagic(final boolean magic) {
        isMagic = magic;
    }

    /**
     * 获得物品集合.
     *
     * @return 物品的集合.
     */
    public HashSet<Goods> getGoods() {
        return goods;
    }

    /**
     * 设置物品集合.
     *
     * @param paramGoods
     */
    public void setGoods(final HashSet<Goods> paramGoods) {
        this.goods = paramGoods;
    }

    /**
     * 设置房间的出口.
     *
     * @param direction 可以前进的方向.
     * @param neighbor  这个方向出口的房间.
     */
    public void setExit(final String direction, final Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * 以字符串形式返回对房间简短的描述.
     *
     * @return 对房间简短的描述.
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * 以字符串形式返回对房间较长的描述.
     *
     * @return 对房间较长的描述，包括位置信息和出口信息.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 以字符串形式返回房间的所有出口.
     *
     * @return 房间所有方向上的出口.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 返回给定方向上的出口房间.
     *
     * @param direction 方向.
     * @return 这个方向上的出口房间.
     */
    public Room getExit(final String direction) {
        return exits.get(direction);
    }
}


