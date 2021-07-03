/**
 * 该类是“World-of-Zuul”应用程序的一部分.
 * 《World of Zuul》是一款简单的文本冒险游戏.用户可以在一些房间组成的迷宫中探险.
 * <p>
 * 此类保存物品信息，包括物品重量和物品描述.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

public class Goods {
    /**
     * 物品重量.
     */
    private double weight;
    /**
     * 物品描述.
     */
    private String description;

    /**
     * 物品构造函数.
     *
     * @param paramWeight      物品重量
     * @param paramDescription 物品描述
     */
    public Goods(final double paramWeight, final String paramDescription) {
        this.weight = paramWeight;
        this.description = paramDescription;
    }

    /**
     * 获得物品描述.
     *
     * @return 返回物品描述.
     */
    public String getDescription() {
        return description;
    }
}
