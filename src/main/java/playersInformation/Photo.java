package Config;

import javax.swing.*;

/**
 * 
 * 设定界面图片类
 * 
 * */

public class Photo {
	
	/**
	 *  玩家一选定图片
	 */
	public static ImageIcon PLAYER_01_SELECTED = new ImageIcon("src\\images\\config\\playerChoose\\selected_01.png");
	/**
	 *  玩家二选定图片
	 */
	public static ImageIcon PLAYER_02_SELECTED = new ImageIcon("src\\images\\config\\playerChoose\\selected_02.png");
	/**
	 *  左按钮
	 */
	public static ImageIcon[] BUTTON_LEFT = {
		new ImageIcon("src\\images\\config\\左按钮\\normal.png"),
		new ImageIcon("src\\images\\config\\左按钮\\disabled.png"),
		new ImageIcon("src\\images\\config\\左按钮\\mouseOver.png"),
		new ImageIcon("src\\images\\config\\左按钮\\pressed.png")
	};
	/**
	 *  右按钮
	 */
	public static ImageIcon[] BUTTON_RIGHT = {
		new ImageIcon("src\\images\\config\\右按钮\\normal.png"),
		new ImageIcon("src\\images\\config\\右按钮\\disabled.png"),
		new ImageIcon("src\\images\\config\\右按钮\\mouseOver.png"),
		new ImageIcon("src\\images\\config\\右按钮\\pressed.png")
	};
	/**
	 * 可选人物图片
	 * */
	public static ImageIcon[] PLAYER_CHOOSE = {
		new ImageIcon("src\\images\\player\\0\\head_h5.png"),
		new ImageIcon("src\\images\\player\\1\\head_h5.png"),
		new ImageIcon("src\\images\\player\\2\\head_h5.png"),
		new ImageIcon("src\\images\\player\\3\\head_h5.png")
	};
}
