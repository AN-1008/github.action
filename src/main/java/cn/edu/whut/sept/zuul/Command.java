/**
 * 该类是“World-of-Zuul”应用程序的一部分.
 * 《World of Zuul》是一款简单的文本冒险游戏.用户可以在一些房间组成的迷宫中探险.
 * <p>
 * 此类保存用户输入的命令的信息.该命令通常是由两个字符串组成.
 * 在使用之前需要保证用户输入的命令已经被识别为有效的命令单词.否则如果用户输入的为无效命令，则命令单词为null.
 * 如果用户输入的命令仅有一个字符串构成，则它的第二个单词为null.
 *
 * @author Team wggg
 * @version 2021.7.2
 */
package cn.edu.whut.sept.zuul;

public abstract class Command {
    /**
     * 命令的第一个单词.
     */
    private String commandWord;

    /**
     * 命令的第二个单词.
     */
    private String secondWord;

    /**
     * 默认构造器创建一个命令对象.
     */
    public Command() {
        secondWord = null;
    }

    /**
     * 返回命令的第一个单词.如果这个命令不能被识别，那么就会返回一个空指针.
     *
     * @return 命令单词.
     */
    public String getCommandWord() {
        return commandWord;
    }

    /**
     * @return 命令的第二个单词.如果没有第二个单词，那么就会返回一个空指针.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * 设置secondWord变量值.
     *
     * @param secondword
     */
    public void setSecondWord(final String secondword) {
        this.secondWord = secondword;
    }

    /**
     * @return 如果命令有第二个单词，则返回true，否则返回false.
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }

    /**
     * 执行用户输入命令.
     *
     * @param game
     * @return 如果执行成功，则返回true，否则返回false.
     */
    public abstract boolean execute(Game game);
}
