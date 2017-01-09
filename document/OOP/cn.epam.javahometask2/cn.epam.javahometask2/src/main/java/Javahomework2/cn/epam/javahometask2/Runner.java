package Javahomework2.cn.epam.javahometask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Javahomework2.cn.epam.javahometask2.Bouquet;
import Javahomework2.cn.epam.javahometask2.Flower;



public class Runner {

	public static void main(String[] args) {
		boolean repeat = true;
		
		Bouquet flowerbasket = new Bouquet ("Businessflowerbasket");

						
		List<Flower> list = new ArrayList<Flower>();
		
		while(repeat) {
			System.out.println("1.Add flowers to flowerbasket");
			System.out.println("2.Find flower");
			System.out.println("3.Show list");
			System.out.println("4.Show bouquet information");
			System.out.println("0.Exit");
			
			Scanner scanner = new Scanner (System.in);
			int action = scanner.nextInt();
			
			switch(action){
			case 0: 
				repeat = false;
				System.out.println("Completed!");
				break;
				
			case 1:
				System.out.println("Type the flower name:");
				String flowername = new Scanner(System.in).nextLine();
				System.out.println("Type the flower price:");
				int flowerprice = Integer.parseInt(new Scanner(System.in).nextLine());
				System.out.println("Type the flower quantity:");
				try{
					int flowerquantity = Integer.parseInt(new Scanner(System.in).nextLine());
					list.add(new Flower(flowername, flowerprice, flowerquantity,flowerbasket));
				} 
				catch(NumberFormatException e) {
					System.out.println("Please enter an number for quantity!");
					//break;
					System.out.println("Type the flower quantity:");
					int flowerquantity = Integer.parseInt(new Scanner(System.in).nextLine());
					list.add(new Flower(flowername, flowerprice, flowerquantity,flowerbasket));
				}

				break;								
				
			case 2:
				System.out.println("Type a name to search");
				String name = new Scanner(System.in).nextLine();
				Utils.findFlowers(name, list);
				break;
								
										
			case 3:
				for(Flower flower : list){
					System.out.println("Flower name: " + flower.getName());
					
				}
							
				break;
				
			case 4:
				for(Flower flower : list){
					flowerbasket.totalprice += flower.addFlowersToBouquet();
					System.out.println(flower.getinfo() + "added to " + flowerbasket.name);

				}
				
				System.out.println(flowerbasket.name + " total price is " +flowerbasket.totalprice);

				
				break;
				
							
			default: 
				System.out.println("Incorrect value! Please, try again!");
				break;
			
			}
			
			
		}

	}

}

