package Javahomework2.cn.epam.javahometask2;


import java.util.List;

import Javahomework2.cn.epam.javahometask2.Flower;;

public class Utils {

	public static void findFlowers(String searchValue, List<Flower> list) {
		for (Flower flower : list) {
			if(searchValue.equals(flower.getName())){
				System.out.print(flower.searchinfo());
				
			}
		}
	}
	
	
}