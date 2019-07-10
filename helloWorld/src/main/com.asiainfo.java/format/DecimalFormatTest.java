package format;

import java.text.DecimalFormat;

/**
 * @description: 数据格式化
 * @author: qml
 * @create: 2019-07-08 16:22
 */
public class DecimalFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double d = 1231423.3823;
		System.out.println("格式化前：" + d);
		DecimalFormat f = new DecimalFormat();
		f.applyPattern("#.##");
		System.out.println("applyPattern{#.##} 格式化后：" + f.format(d));
		f.applyPattern("0000000000.000000");
		System.out.println("applyPattern{0000000000.000000} 格式化后：" + f.format(d));
		f.applyPattern("-#,###.###");
		System.out.println("applyPattern{##,###.##} 格式化后：" + f.format(d));
		f.applyPattern("0.00KG");
		System.out.println("applyPattern{0.00KG} 格式化后：" + f.format(d));
		f.applyPattern("#000.00KG");
		System.out.println("applyPattern{#000.00KG} 格式化后：" + f.format(d));
		f.applyPattern("0.00%");
		System.out.println("applyPattern{0.00%} 格式化后：" + f.format(d));
		//E后面的是指数的格式 前面是底数的格式
		f.applyPattern("#.##E000");
		System.out.println("applyPattern{#.##E000} 格式化后：" + f.format(d));
		// /u2030 表示乘以1000并表示成 ‰，放在最后
		f.applyPattern("0.00/u2030");
		System.out.println("applyPattern{0.00/u2030%} 格式化后：" + f.format(d));
	}
}
