/**
 * 该类是“World-of-Zuul”的主程序.
 * 《World of Zuul》是一款简单的文本冒险游戏.用户可以在一些房间组成的迷宫中探险.
 * <p>
 * 这个类是程序的入口.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

class Main {
    /**
     * 主程序入口.
     *
     * @param args
     */
    public static void main(final String[] args) {
        Game game = new Game();
        game.play();
    }

    private void utilities() {
        throw new IllegalStateException("Utility class");
    }
}
