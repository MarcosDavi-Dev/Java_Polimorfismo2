package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import entities.enums.ProductType;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		
		
		for(int i=1; i<=n; i++){
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used, imported (0/1/2): ");
			int productType = sc.nextInt();
			
			ProductType type = ProductType.valueOf(productType);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (type == ProductType.COMMON){
				list.add(new Product(name, price));
			} else if (type == ProductType.USED){
				System.out.print("Data de fabricação(DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			} else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
		}
		
		System.out.println();
		System.out.println("Price tags: ");
		for(Product prod : list){
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
