package com.bsc.algorithm.data.generator;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * ����������
 * @author bsc
 *
 */
public class ArrayGenerator {

	/**
	 * �������size��С������
	 * @param arrayClass ����class������Integer[].class,int[].class,Character[].class,char[].class
	 * @param size �����С
	 * @param min ��Сֵ
	 * @param max ���ֵ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T random(Class<T> arrayClass, int size,int min,int max) {
		int diff = max - min + 1;
		Random random = new Random();
		Class<?> componentType = arrayClass.getComponentType();
		String componentName = componentType.getName();
		T array = (T) Array.newInstance(componentType, size);
		
		if("char".equals(componentName) || Character.class.getName().equals(componentName)) {
			for (int i = 0; i < size; i++) {
				Array.set(array, i, (char)(random.nextInt(diff) + min));
			}
		}else {
			for (int i = 0; i < size; i++) {
				Array.set(array, i, random.nextInt(diff) + min);
			}
		}
		return array;
	}
	
	/**
	 * ����ָ����������
	 * @param arrayClass ����class������Integer[].class,int[].class,Character[].class,char[].class
	 * @param size �����С
	 * @param start ���鿪ʼֵ
	 * @param increment ����Ԫ�ؼ�����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T seq(Class<T> arrayClass, int size,int start,int increment) {
		Class<?> componentType = arrayClass.getComponentType();
		String componentName = componentType.getName();
		T array = (T) Array.newInstance(componentType, size);
		
		if("char".equals(componentName) || Character.class.getName().equals(componentName)) {
			for (int i = 0; i < size; i++) {
				Array.set(array, i, (char)(start));
				start += increment;
			}
		}else {
			for (int i = 0; i < size; i++) {
				Array.set(array, i, start);
				start += increment;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] dataInt = ArrayGenerator.random(int[].class, 20,10,99);
		System.out.print("random:\t");
		for (int i = 0; i < dataInt.length; i++) {
			System.out.print(dataInt[i] + " ");
		}
		System.out.println();
		System.out.print("   seq:\t");
		dataInt = ArrayGenerator.seq(int[].class, 20,20,1);
		for (int i = 0; i < dataInt.length; i++) {
			System.out.print(dataInt[i] + " ");
		}
		System.out.println();
		System.out.print("random:\t");
		char[] dataChar = ArrayGenerator.random(char[].class, 26,65,90);
		for (int i = 0; i < dataChar.length; i++) {
			System.out.print(dataChar[i] + " ");
		}
		System.out.println();
		System.out.print("   seq:\t");
		dataChar = ArrayGenerator.seq(char[].class, 26,65,1);
		for (int i = 0; i < dataChar.length; i++) {
			System.out.print(dataChar[i] + " ");
		}
	}
}
