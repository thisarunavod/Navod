import java.util.*;
class User{
	String userName ;
	String passWord ;		
}
class Supplier{
	String id ;
	String name ;
}
class SupplierCollection {
	Supplier[] supList = new Supplier[0];
	
	public void grow() {
		// your code to grow the supList array by 1
		Supplier[] temp = new Supplier[supList.length+1];
		for (int i = 0; i < supList.length ; i++){
			temp[i] = supList[i];
		}
		supList = temp ;
		
	}
	
	public boolean addSupplier(Supplier supplier) {
		
		for (int i = 0; i < supList.length; i++){
			if(supplier.id.equals(supList[i].id)){return false;}
		}
		
		grow();
		//then add supplier object for the supList last index
		supList[supList.length -1] = supplier;
		return true ;
	}
	public boolean updateSupplier(String x){
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < supList.length; i++){
			if(x.equals(supList[i].id)){
				System.out.printf("|     Suplier New Name is      :  "+ supList[i].name +"                              |%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|     Enter the New Name            :       ");
				supList[i].name = input.next();
				return true;	
			}
		}
		return false ;	
	}
	
	public void remove(int n){
		Supplier[] temp = new Supplier[supList.length-1];
		for (int i = 0; i < temp.length ; i++){
			if(i >= n ){ temp[i] = supList[i+1];}
			else{ temp[i] = supList[i]; }
		}
		supList = temp ;
		if(supList.length == 0){ toop.flag2 = false; toop.clearConsole(); toop.WelcomePage(); }
	}
	
	public boolean deleteSupplier(String x){
		
		for (int i = 0; i < supList.length; i++){
			if(x.equals(supList[i].id)){ remove(i); return true;}     
		}
		return false;
		
	}
	
	public void viewSupplier(){
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | %-10s | %-10s| %-15s|                    |%n","  SUP No","  SUP ID","   SUP NAME");
		System.out.printf("|     -------------------------------------------                    |%n");	
		for (int i = 0; i < supList.length; i++){
			System.out.printf("|     | %-10d | %-10s| %-15s|                    |%n",(i+1),supList[i].id,supList[i].name);
			System.out.printf("|     -------------------------------------------                    |%n");	
		}
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
	
	}
	
	public boolean searchsupplier(String x){
		for (int i = 0; i < supList.length; i++){
			if(x.equals(supList[i].id)){
				System.out.printf("|     -------------------------------------------                    |%n");
				System.out.printf("|     | %-10d | %-10s| %-15s|                    |%n",(i+1),supList[i].id,supList[i].name);
				System.out.printf("|     -------------------------------------------                    |%n");
				System.out.printf("|                                                                    |%n");	
				return true ;
			}
		}
		return false ;
	}                                       
}
class ItemCategory{
	String name ; 
}
class ItemCategoryCollection {
	ItemCategory [] itemCategoryList = new ItemCategory[0];
	public void grow(){
		
		ItemCategory[] temp = new ItemCategory[itemCategoryList.length+1];
		for (int i = 0; i < itemCategoryList.length ; i++){
			temp[i] = itemCategoryList[i];
		}
		itemCategoryList = temp ;
		
	}
	public boolean addItemcategory(ItemCategory itemCategory){
		
		grow();
		itemCategoryList[itemCategoryList.length - 1] = itemCategory;
		return true ;
	}
	//public boolean deleteItemcategory(){}
	//public boolean updateItemcategory(){}
}
class toop{
	public static Scanner input = new Scanner(System.in);
	public static Random r = new Random();
	public static boolean flag1 = true;
	public static boolean flag2 = false;
	public static User user = new User();	
	public static User [] userDetails = new User[1];
	private static SupplierCollection supCollection = new SupplierCollection();
	private static ItemCategoryCollection catCollection = new ItemCategoryCollection(); 
	public static void main(String args[]){
		LogingPage();
	}
	
	// Loging Page Creation
	public static void LogingPage(){
		
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                       LOGGING TO STOCK SYSTEM                      |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                                                                    |\n");
		System.out.print("|                                                                    |\n");
		if(flag1){
			user.userName = "1";
			user.passWord = "1";
			userDetails[0] = user;
		}
		System.out.printf("|                %-15s:","USERNAME");    
L1:		while(true){
			String un = input.next();
			if(un.equals(userDetails[0].userName)){ break L1; } 
			else{
				System.out.printf("%n|                %-15s                 |","Invalid Username!! Please try Again");
				System.out.printf("%n|                %-15s:","        ");continue L1;
			}		
		}
			
		System.out.printf("|                %-15s:","PASSWORD");
L2:		while(true){
			String pw = input.next();
			if(pw.equals(userDetails[0].passWord)){ clearConsole(); WelcomePage();break L2;}
			else{
				System.out.printf("%n|                %-15s                 |","Invalid Password!! Please try Again");
				System.out.printf("%n|                %-15s:","        ");continue L2;
			}
		}			
	}
	
	public static void WelcomePage(){
		
		int answer;		  				  
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|               WELCOME TO IJSE STOCK MANAGEMENT SYSTEM              |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 1 | %-35s |    	             |%n"," TO CHANGE CREDENTIALS");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 2 | %-35s |    	             |%n"," TO SUPLIER MANAGE");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 3 | %-35s |    	             |%n"," TO STOCK MANAGE");
		System.out.printf("|     -------------------------------------------                    |%n");  
		System.out.printf("|     | 4 | %-35s |    	             |%n"," TO LOGOUT");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 5 | %-35s |    	             |%n"," TO EXIT THE SYSTEM");	
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		
		
L1:		while(true){
			System.out.printf("|     GO (Please Input Number) : ");
			answer = input.nextInt();
			if(answer > 5 | answer < 0){System.out.printf("|     Invalid Number !!!  Enter the Correct numbers      %n"); continue L1;}
			else{break L1;}
		}	
		if(answer == 4){
			clearConsole();
			LogingPage();
		}
		if(answer == 5){clearConsole(); ExitSystem(); }	
		if(answer == 1){ clearConsole(); ChangeCredentials(); }
		if(answer == 2){ clearConsole(); SupplierManage(); }
		if(answer == 3){ clearConsole(); StockManage(); }
			
	}
	public static void ExitSystem(){System.exit(0);}
	public static void ChangeCredentials(){
		
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                        CHANGE CREDENTIALS                          |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		
		String answer1 ;
		String answer2 ;
L1:		while(true){
			System.out.printf("| 	Please Enter Your USERNAME         : ");   
			answer1 = input.next();
			if(answer1.equals(userDetails[0].userName)){System.out.printf("|                                                                    |%n"); break L1;}
			else{System.out.printf("| 	                 Invalid UserName!!!!                        |%n");}
		}
L2:		while(true){
			System.out.printf("| 	Please Enter Your Current PASSWORD : ");   
			answer2 = input.next();
			if(answer2.equals(userDetails[0].passWord)){System.out.printf("|                                                                    |%n");
				System.out.printf("| 	Please Enter Your New PASSWORD     : ");   	
				String nP = input.next();
				userDetails[0].passWord = nP;
				flag1 = false ;
				System.out.printf("|                                                                    |%n");
				System.out.printf("|        -------- Password Changed Succesfully -----------           |%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("| 	DO YOU NEED TO GO HOMEPAGE(y/n)    : ");
				char x =  input.next().charAt(0);
				if(x == 'y'){clearConsole(); WelcomePage(); break L2;}else{continue L2;}	
			}else{
				System.out.printf("| 	                 Invalid Password!!!!                        |%n");
			}	
		}	
	}
	public static void CreateFrameOnSuppliersSlide(String title){
		System.out.print("----------------------------------------------------------------------\n");       // Create Supplier management Slides Title frame on method
		System.out.printf("|%27s%-16s%25s|%n","",title,"");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
                                                                   
	}
	public static void SupplierManage(){
		// SUPPLIER MANAGEMENT SYSTEM Main menu
		int answer;
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                     SUPPLIER MANAGEMENT SYSTEM                     |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 1 | %-35s |    	             |%n"," TO ADD SUPPLIERS");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 2 | %-35s |    	             |%n"," TO UPDATE SUPLIERS");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 3 | %-35s |    	             |%n"," TO DELETE SUPLIERS");
		System.out.printf("|     -------------------------------------------                    |%n");  
		System.out.printf("|     | 4 | %-35s |    	             |%n"," TO VIEW SUPLIERS");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 5 | %-35s |    	             |%n"," TO SEARCH SUPLIERS");	
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 6 | %-35s |    	             |%n"," TO HOMEPAGE");	
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");

L1:		while(true){
			System.out.printf("|     GO (Please Input Number) : ");
			answer = input.nextInt();
			if(answer > 6 | answer < 0){System.out.printf("|     Invalid Number !!!  Enter the Correct numbers      %n"); continue L1;}
			else{break L1;}
		}
		if(answer == 6){ clearConsole(); WelcomePage();}
		if(answer == 1){ clearConsole(); AddSupliers();}
		if(answer == 2){
			if(flag2){
				clearConsole();
				UpdateSuppliers();
			}else{
				clearConsole();
				CreateFrameOnSuppliersSlide("UPDATE SUPPLIERS");
				System.out.printf("|    NOT Added Suppliers Details !! Please Add Suppliers Details     |%n");
				System.out.printf("|********************************************************************|%n");
				System.out.printf("|     %-40s :  ","Do You Need Add SUPPLIERS - ");
				char x = input.next().charAt(0);	
				if( x == 'y' || x == 'Y'){ clearConsole(); AddSupliers(); }else{ clearConsole(); SupplierManage(); }
			}
		}
		if(answer == 3){
			if(flag2){
				clearConsole();
				DeleteSuppliers();
			}else{
				clearConsole();
				CreateFrameOnSuppliersSlide("DELETE SUPPLIERS");
				System.out.printf("|    NOT Added Suppliers Details !! Please Add Suppliers Details     |%n");
				System.out.printf("|********************************************************************|%n");
				System.out.printf("|     %-40s :  ","Do You Need Add SUPPLIERS - ");
				char x = input.next().charAt(0);	
				if( x == 'y' || x == 'Y'){ clearConsole(); AddSupliers(); }else{ clearConsole(); SupplierManage(); }	
			}

		}		
		if(answer == 4){
			if(flag2){
				clearConsole();
				ViewSuppliers();
			}else{
				clearConsole();
				CreateFrameOnSuppliersSlide(" VIEW SUPPLIERS");
				System.out.printf("|    NOT Added Suppliers Details !! Please Add Suppliers Details     |%n");
				System.out.printf("|********************************************************************|%n");
				System.out.printf("|     %-40s :  ","Do You Need Add SUPPLIERS - ");
				char x = input.next().charAt(0);	
				if( x == 'y' || x == 'Y'){ clearConsole(); AddSupliers(); }else{ clearConsole(); SupplierManage(); }	
			}
		}
		if(answer == 5){
			if(flag2){
				clearConsole();
				SearchSuppliers();
			}else{
				clearConsole();
				CreateFrameOnSuppliersSlide(" VIEW SUPPLIERS");
				System.out.printf("|    NOT Added Suppliers Details !! Please Add Suppliers Details     |%n");
				System.out.printf("|********************************************************************|%n");
				System.out.printf("|     %-40s :  ","Do You Need Add SUPPLIERS - ");
				char x = input.next().charAt(0);	
				if( x == 'y' || x == 'Y'){ clearConsole(); AddSupliers(); }else{ clearConsole(); SupplierManage(); }	
			}
			
		}
	}
	// Add suppliers page
	public static void AddSupliers(){
		CreateFrameOnSuppliersSlide("ADD SUPPLIRES");

L1:		while(true){
			Supplier supplier = new Supplier();
			System.out.printf("|     Enter the Supplier ID         :   ");
			supplier.id = input.next();
			System.out.printf("|     Enter the Suppler  Name       :   ");
			supplier.name = input.next();
			
			if(supCollection.addSupplier(supplier)){
				flag2 = true;
				System.out.printf("|                                                                    |%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|                  Suplier Details Added Succesfully                 |%n");
				System.out.printf("|--------------------------------------------------------------------|%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|     Do You Need Add a Supplier : ");
				
				char x = input.next().charAt(0);
				if(x == 'y' || x == 'Y'){  clearConsole() ; CreateFrameOnSuppliersSlide("ADD SUPPLIRES"); continue L1; }
				else{ clearConsole(); SupplierManage(); }
			}else{ System.out.printf("|      This ID is Already use !! Please Set Uniq ID      %n"); continue L1;}
		}	
	}
	// Update Suppliers details Page
	public static void UpdateSuppliers(){
		CreateFrameOnSuppliersSlide("UPDATE SUPPLIERS");

L1:     while(true){
			System.out.printf("|     Enter the Supplier ID         :       ");
			String x = input.next();
			if(supCollection.updateSupplier(x)){
				System.out.printf("|________________________________________________                    |%n");
					System.out.printf("|******Suplier Details UPDATED SUCCESSFULLY *******|                 |%n");
					System.out.printf("|--------------------------------------------------------------------|%n");
					System.out.printf("|                                                                    |%n");
					char answer;
					System.out.printf("|     Do you need UPDATE More       :       ");
					answer = input.next().charAt(0);
					System.out.printf("|                                                                    |%n");
					if(answer == 'y'){ clearConsole(); CreateFrameOnSuppliersSlide("UPDATE SUPPLIERS"); continue L1 ;}
					else{ clearConsole(); SupplierManage(); break L1;}	
			}else{ System.out.printf("|           Invalid ID  !!!  Enter the Valid ID                      |%n"); continue L1;	}
		}			
	}
	// Delete Suppliers Details
	public static void DeleteSuppliers(){
		CreateFrameOnSuppliersSlide("DELETE SUPPLIERS");		
		
L1:     while(true){
			System.out.printf("|     Enter the Supplier ID         :       ");
			String x = input.next();
			if(supCollection.deleteSupplier(x)){
				System.out.printf("|     Do You need DELETE More       :        ");
				char answer;
				answer = input.next().charAt(0);
				if(answer == 'y' || answer == 'Y'){ clearConsole(); CreateFrameOnSuppliersSlide("DELETE SUPPLRES"); continue L1;}
				else{ clearConsole(); SupplierManage(); break L1; }
				
			}else{ System.out.printf("|           Invalid ID  !!!  Enter the Valid ID                      |%n");  continue L1; }	
		}
	}
	
	public static void ViewSuppliers(){
		CreateFrameOnSuppliersSlide(" VIEW SUPPLRES");
		supCollection.viewSupplier();
L1:		while(true){
			System.out.printf("|     GO to PREVIOUS PAGE (Press y) :        ");
			char x;
			x = input.next().charAt(0);
			if(x == 'y'){ clearConsole(); SupplierManage(); break L1;}
			else { continue L1; }
		} 			
	}
	public static void SearchSuppliers(){
		// Search Suppliers page
		CreateFrameOnSuppliersSlide("SEARCH SUPPLIRES");

L1:		while(true){
			System.out.printf("|     Enter the Supplier ID         :       ");
			String x = input.next();
			if(supCollection.searchsupplier(x)){
				System.out.printf("|     Do You need Search More       :        ");
				char answer;
				answer = input.next().charAt(0);
				System.out.printf("|                                                                    |%n");
				if(answer == 'y'){ clearConsole(); CreateFrameOnSuppliersSlide("SEARCH SUPPLIRES"); continue L1;}
				else{ clearConsole(); SupplierManage(); break L1; }		
					
			}else{ System.out.printf("|           Cant Find this ID !!!!   Enter the Valid ID              |%n"); continue L1; }
		}
	
	}
	public static void StockManage(){
		int answer;
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                           STOCK MANAGEMENT                         |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 1 | %-35s |    	             |%n"," TO MANAGE ITEM CATOGERY");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 2 | %-35s |    	             |%n"," TO ADD ITEM");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 3 | %-35s |    	             |%n"," TO GET ITEM SUPPLIER WISE");
		System.out.printf("|     -------------------------------------------                    |%n");  
		System.out.printf("|     | 4 | %-35s |    	             |%n"," TO VIEW ITEMS");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 5 | %-35s |    	             |%n"," TO RANK ITEMS per UNIT PRICE");	
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 6 | %-35s |    	             |%n"," TO HOMEPAGE");	
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
L1:		while(true){
			System.out.printf("|     GO (Please Input Number) : ");
			answer = input.nextInt();
			if(answer > 6 | answer < 0){System.out.printf("|     Invalid Number !!!  Enter the Correct numbers      %n"); continue L1;}
			else{break L1;}
		}
		if(answer == 6){
			clearConsole();
			WelcomePage();
		}
		if(answer == 1){
			clearConsole();
			ManageItemCatogery();
		}
	}
	public static void CreateFrameOnItemCategorySlide(String title){
		System.out.print("----------------------------------------------------------------------\n");    // Create Title frame for Item Category Management Slides
		System.out.printf("|%24s%-21s%23s|%n","",title,"");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		
	}
	public static void ManageItemCatogery(){
		int answer;
		System.out.print("----------------------------------------------------------------------\n");
		System.out.print("|                        ITEM CATEGORY MANAGEMENT                    |\n");
		System.out.print("----------------------------------------------------------------------\n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 1 | %-35s |    	             |%n"," TO Add NEW ITEM CATEGORY");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 2 | %-35s |    	             |%n"," TO DELETE ITEM CATEGORY");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|     | 3 | %-35s |    	             |%n"," TO UPDATE ITEM CATEGORY");
		System.out.printf("|     -------------------------------------------                    |%n");  
		System.out.printf("|     | 4 | %-35s |    	             |%n"," TO Previous PAGE");
		System.out.printf("|     -------------------------------------------                    |%n");
		System.out.printf("|                                                                    |%n");
		System.out.printf("|                                                                    |%n");
		
L1:		while(true){
			System.out.printf("|     GO (Please Input Number) : ");
			answer = input.nextInt();
			if(answer > 4 | answer < 0){System.out.printf("|     Invalid Number !!!  Enter the Correct numbers      %n"); continue L1;}
			else{break L1;}
		}
		if(answer == 4){ clearConsole(); StockManage();}
		if(answer == 1){ clearConsole(); AddNewItemCategory();}
	
		
	}
	public static void AddNewItemCategory(){
		CreateFrameOnItemCategorySlide("Add NEW ITEM CATEGORY");
		
L1:		while(true){
	
			ItemCategory itemCategory = new ItemCategory();
			System.out.printf("|     Enter the Item category Name         :   ");
			itemCategory.name = input.next();
			
			if(catCollection.addItemcategory(itemCategory)){
				
				System.out.printf("|                                                                    |%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|                   Item category  Added Succesfully                 |%n");
				System.out.printf("|--------------------------------------------------------------------|%n");
				System.out.printf("|                                                                    |%n");
				System.out.printf("|     Do You Need Add a Item Category : ");
				char x = input.next().charAt(0);
				if(x == 'y' || x == 'Y' ){ clearConsole(); CreateFrameOnItemCategorySlide("Add NEW ITEM CATEGORY"); continue L1;}
				else{ clearConsole(); ManageItemCatogery(); break L1;}}
		}
	}
	
	// Clear consloe Method// 
	public final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
		} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
		} catch (final Exception e) {
		//handle the exception
		System.err.println(e.getMessage());
		}
	}
}



