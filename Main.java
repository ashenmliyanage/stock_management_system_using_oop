import java.util.*;
class Bar{
	public static String[] bar = {"LOGIN", "WELCOME TO IJSE STOCK MANAGEMENT SYSTEM", "CREDENTIAL MANAGE", "SUPPLIER MANAGE", "ADD SUPPLIER", "UPDATE SUPPLIER","DELETE SUPPLIER"," VIEW SUPPLIER","SEARCH SUPPLIER","STOCK MANAGE","MANAGE ITEM CATEGORIES","ADD NEW CATEGORY","DELETE ITEM CATEGORY","UPDATE CATEGORY", "ADD ITEM","SUPPLIER WISE","VIEW ITEM","VIEW CATEGORY","RANKING"};

}
class Uname{
	public static String [] uName = {"1","1"};
}
class Supplier{
	String id;
	String name;
}
class Category{
	String name;
}
class item{
	String iCode;
	String sId;
	String cat;
	String dis;
	String price;
	String qty;
}
class Main{
	public static Scanner input = new Scanner(System.in);

	public static Supplier[] supplier =new Supplier[0];
	public static Category[] category = new Category[0];
	public static item[] itemCode = new item[0];
	public static int[]min = new int[0];
	public static void main(String args[]){

		login();
		homePage();
	}
	public static void tBar(String bar){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %46s"+"%46s %n",bar,"|" );
		System.out.println("+--------------------------------------------------------------------------------------------+\n\n");
	}
	public static void login(){
		tBar(Bar.bar[0]);
		boolean flag = false;
		while (flag != true) {
			System.out.print("User Name : ");
			String x = input.next();

			if (x.equals(Uname.uName[0])) {
				while (flag != true){
					System.out.print("Password : ");
					String pass = input.next();

					if (pass.equals(Uname.uName[1])) {
						flag = true;
					}
					else{
						System.out.println("password incorrect.please try again");
					}
				}
			}
			else{
				System.out.println("Username incorrect.please try again");
			}
		}
	}
	public static void homePage(){
		tBar(Bar.bar[1]);
		System.out.print("[1] Change the Credentials ");
		System.out.printf("%26s [2] Supplier Manage \n","");
		System.out.print("[3] Stock Manage");
		System.out.printf("%37s [4] log out\n","");
		System.out.println("[5] Exit the System");


		System.out.print("Enter an option to continue > ");
		int option = input.nextInt();

		if (option == 1) {
			ChangeTheCredentials();
		}
		if(option == 4){
			login();
			homePage();
		}
		if (option == 2) {
			supplierManage();
		}
		if (option == 3) {
			stockManage();
		}
		if (option == 5){
			System.exit(0);
		}
	}
	public static void ChangeTheCredentials(){
		tBar(Bar.bar[2]);
		boolean flag = false;

		while(flag != true){
			System.out.print("Please enter the user name to verify it's you : ");
			String name = input.next();

			if (name.equals(Uname.uName[0])) {
				System.out.println("Hey "+Uname.uName[0]);
				while (flag != true){
					System.out.print("Enter your current password : ");
					String pass = input.next();

					if (pass.equals(Uname.uName[1])) {
						System.out.print("Enter your new password : ");
						Uname.uName[1] = input.next();
						flag = true;
					}
					else{
						System.out.println("incorrect password. try again");
					}
				}
			}
			else {
				System.out.println("Invalid User name. try again");
			}
		}
		System.out.print("Password change is successful !. Do you want to go home page (Y/N) : ");
		char replay = input.next().charAt(0);

		if(replay == 'Y' || replay == 'y'){
			homePage();
		}
		else{
			System.exit(0);
		}

	}
	public static void supplierManage(){
		tBar(Bar.bar[3]);
		System.out.print("[1] Add Supplier ");
		System.out.printf("%26s [2] Update Supplier \n","");
		System.out.print("[3] Delete Supplier");
		System.out.printf("%24s [4] View Supplier\n","");
		System.out.print("[5] Search Supplier");
		System.out.printf("%24s [6] Home\n","");

		System.out.print("Enter the option to continue : ");
		int option = input.nextInt();

		if (option == 1) {
			addSupplier();
		}
		if (option == 2) {
			updateSupplier();
		}
		if (option == 3) {
			deleteSupplier();
		}
		if (option == 4) {
			viewSupplier();
		}
		if (option == 5) {
			searchSupplier();
		}
		if (option == 6){
			homePage();
		}
	}
	public static void addSupplier(){
		tBar(Bar.bar[4]);
		supplier = grow(supplier);
		int count = 0;
		while (true){
			System.out.print("Supplier Id \t: ");
			String x = input.next();
			count = check(x,supplier);
			if ( count == 0) {
				Supplier cus = new Supplier();
				cus.id = x;
				System.out.print("Supplier name\t: ");
				String name  = input.next();
				cus.name = name;
				supplier[supplier.length-1] = cus;
				break;
			}
			else {
				System.out.println("Already used.try again");
			}
		}
		System.out.print("added successfully. Do you want to add another supplier (Y/N) : ");
		char option = input.next().charAt(0);

		if (option == 'Y' || option == 'y') {
			addSupplier();
		}
		else{
			supplierManage();
		}
	}
	public static void updateSupplier(){
		tBar(Bar.bar[5]);
		boolean flag = false;
		while (flag != true){
			System.out.print("Supplier ID : ");
			String id = input.next();

			for (int i = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i].id)) {
					System.out.println("Supplier name : "+supplier[i].name);
					System.out.print("Enter the new supplier name : ");
					supplier[i].name = input.next();
					flag = true;
				}
			}
			if (flag != true) {
				System.out.println("can't find supplier.try again");
			}
		}
		System.out.print("Update is Successful. Do you want to update another supplier(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y'|| option == 'y') {
			updateSupplier();
		}
		if (option == 'N' || option == 'n') {
			supplierManage();
		}
	}

	public static void deleteSupplier(){
		tBar(Bar.bar[6]);
		boolean flag = false;
		while (flag != true){
			System.out.print("Supplier Id : ");
			String id = input.next();
			for (int i = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i].id)) {
					flag = true;
					supplier = growLess(supplier,i);
				}
			}
			if (flag != true) {
				System.out.println("Can't find supplier Id.Try again.");
			}
		}
		System.out.print("deleted successful. Do you want to delete another(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			deleteSupplier();
		}
		else {
			supplierManage();
		}

	}
	public static void viewSupplier(){
		tBar(Bar.bar[7]);
		System.out.println("+--------+--------+----------------+----------------+----------------+");
		System.out.printf("| %18s"+"%16s"+"%16s"+"%18s","name","|","Id","|" );
		System.out.println("\n+--------+--------+----------------+----------------+----------------+");
		for (int i = 0; i < supplier.length; i++) {

				System.out.printf("|%19s", supplier[i].name);
				System.out.printf("%16s" + "%17s " + "%16s" + "\n", "|", supplier[i].id, "|");
			}
		System.out.println("+--------+--------+----------------+----------------+----------------+");
		System.out.print("Do you want to go supplier manage page(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			supplierManage();
		}
		if (option == 'N'|| option == 'n') {
			System.exit(0);
		}
	}
	public static void searchSupplier(){
		tBar(Bar.bar[8]);
		boolean flag = false;
		while (flag != true){
			System.out.print("Supplier Id : ");
			String id = input.next();
			for (int i = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i].id)) {
					System.out.println("Name : "+supplier[i].name);
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("can't find supplier. try again.");
			}
		}
		System.out.print("search is successful. do you want to another find(Y/N): ");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			searchSupplier();
		}
		else {
			supplierManage();
		}
	}
	public static void stockManage(){
		tBar(Bar.bar[9]);
		System.out.print("[1] Manage item categories ");
		System.out.printf("%24s [2] Add item \n","");
		System.out.print("[3] Get item supplier wise");
		System.out.printf("%25s [4] View Items\n","");
		System.out.print("[5] Rank item per unit price ");
		System.out.printf("%22s [6] Home\n","");
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();

		if (option == 1) {
			manageItem();
		}
		if (option == 2) {
			addItem();
		}
		if (option == 3) {
			supplierWise();
		}
		if (option == 4){
			viewCatagory();
		}
		if (option == 5) {
			min();
		}
		if (option == 6) {
			homePage();
		}
	}
	public static void manageItem(){
		tBar(Bar.bar[10]);
		System.out.print("[1] Add new item category ");
		System.out.printf("%24s [2] Delete item category \n","");
		System.out.print("[3] Update item category");
		System.out.printf("%26s [4] Stock management\n","");
		System.out.print("\nEnter an option to continue > ");
		int option =  input.nextInt();

		if (option == 1) {
			addCategory();
		}
		if (option == 2) {
			deleteCategory();
		}
		if (option == 3) {
			updateCategory();
		}
		if (option == 4) {
			stockManage();
		}
	}
	public static void addCategory(){
		tBar(Bar.bar[11]);
		category = growCat(category);
		boolean flag = false;
		int count = 0;
		while(flag != true){
			System.out.print("Enter the new item category : ");
			String cat = input.next();
			count=checkCat(cat,category);
			if(count == 0){
				Category C = new Category();
				C.name = cat;
				category[category.length-1] = C;
				flag = true;
			}
			else{
				System.out.println("Already used.Try again");
			}
		}
		System.out.print("Added successfully!. Do you want to add another category(Y/N) : ");
		char option = input.next().charAt(0);

		if (option == 'Y' || option == 'y') {
			addCategory();
		}
		else {
			stockManage();
		}
	}
	public static void deleteCategory(){
		tBar(Bar.bar[12]);
		boolean flag = false;
		while (flag != true){
			System.out.print("Enter Category for delete : ");
			String delete = input.next();
			for (int i = 0; i < category.length; i++) {
				if (delete.equals(category[i].name)) {
					flag = true;
					category = growLessCat(category,i);
				}
			}
			if (flag != true) {
				System.out.println("Can't find category.Try again.");
			}
		}
		System.out.print("deleted successful. Do you want to delete another(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			deleteCategory();
		}
		else {
			stockManage();
		}
	}
	public static void updateCategory(){
		tBar(Bar.bar[13]);
		boolean flag = false;
		while (flag != true){
			System.out.print("Enter category : ");
			String id = input.next();
			for (int i = 0; i < category.length; i++) {
				if (id.equals(category[i].name)) {
					System.out.print("Enter the new category name : ");
					String name = input.next();
					category[i].name = name;
					flag = true;
				}
			}
			if (flag != true) {
				System.out.println("can't find category.try again");
			}
		}
		System.out.print("Update is Successful. Do you want to update another category(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y'|| option == 'y') {
			updateCategory();
		}
		if (option == 'N'|| option == 'n') {
			stockManage();
		}
	}
	public static void addItem(){
		tBar(Bar.bar[14]);
		if (category.length == 0) {
			System.out.println("OOPS! It seem that you don't have any item category in the system.");
			System.out.print("Do you want to add new item category(Y/N) : ");
			char option = input.next().charAt(0);

			if (option == 'Y'|| option == 'y') {
				addCategory();
			}
			if (option == 'N'|| option == 'n') {
				manageItem();
			}
		}
		if (supplier.length == 0) {
			System.out.println("OOPS! It seem that you don't have any supplier in the system.");
			System.out.print("Do you want to add new supplier(Y/N) : ");
			char option = input.next().charAt(0);

			if (option == 'Y'|| option == 'y') {
				addSupplier();
			}
			if (option == 'N'|| option == 'n') {
				manageItem();
			}
		}
		itemCode = growItem(itemCode);
		item items = new item();
		min = intGrow(min);
		boolean flag = false;
		while (flag != true) {
			System.out.print("Enter Item code : ");
			String x = input.next();
			int count = 0;
			for (int i = 0; i <itemCode.length; i++) {
				if (itemCode[i]!= null && x.equals(itemCode[i].iCode)){
					count++;
				}
			}
			if (count == 0) {
				System.out.println();
				items.iCode = x;
				flag = true;
			} else {
				System.out.println(count);
				System.out.println("Already added.Try again.");
			}
		}
		System.out.println("Supplier List : ");
		System.out.println("+-------------------+--------------------------+--------------------------+");
		System.out.println("|        #          |        SUPPLIER ID       |       SUPPLIER NAME      |");
		System.out.println("+-------------------+--------------------------+--------------------------+");
		for (int i = 0; i < supplier.length; i++){
				System.out.printf("|%10S         |%16S          |%18S        |\n",(i+1),supplier[i].id,supplier[i].name);
		}
		System.out.println("+-------------------+--------------------------+--------------------------+");
		System.out.print("Enter supplier number : ");
		int number = input.nextInt();
		items.sId = supplier[number-1].id;
		System.out.println("+-------------------+--------------------------+");
		System.out.println("|        #          |        CATEGORY NAME     |");
		System.out.println("+-------------------+--------------------------+");
		for (int i = 0; i < category.length; i++){
			for (int j = 0; j < 1; j++){
				System.out.printf("|%10S         |%16S          |\n",(i+1),category[i].name);
			}
		}
		System.out.println("+-------------------+--------------------------+");
		System.out.print("Enter category number : ");

		int Number = input.nextInt();
		items.cat = category[Number-1].name;

		System.out.print("Description : ");
		items.dis = input.next();
		System.out.print("Unite price : ");
		int price = input.nextInt();
		items.price =""+price;
		min[min.length-1] = price;
		System.out.print("Qty on hand : ");
		items.qty = input.next();

		itemCode[itemCode.length-1] = items;

		System.out.print("Do you want add new item(Y/N) : ");
		char option = input.next().charAt(0);

		if (option == 'Y'|| option == 'y') {
			addItem();
		}
		else {
			stockManage();
		}
	}
	public static void supplierWise(){
		tBar(Bar.bar[15]);
		boolean flag1 = false;
		boolean flag = false;
		int count = 0;
		String id = " ";

		while(flag1 != true){
			System.out.print("Enter supplier id : ");
			String tempId = input.next();
			for (int i = 0; i <itemCode.length; i++) {
				if (itemCode[i]!= null && tempId.equals(supplier[i].id)){
					count++;
				}
			}
			if(count == 0){
				System.out.println("Not found.try again");
			}
			else{
				for (int i = 0; i < itemCode.length; i++) {
					if (tempId.equals(itemCode[i].sId)) {
						System.out.println("Name : "+supplier[i].name);
						flag = true;
						id = tempId;
						break;
					}

				}
				if(flag == false){
					System.out.println("no items for supplier");
				}
				flag1 = true;
			}
		}

		if (flag == true) {
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
			//System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
			System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n","SID","CODE","DESC","PRICE","QTY","CAT");
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
			for (int i = 0; i < itemCode.length; i++) {
				if (id.equals(itemCode[i].sId)) {
					System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",itemCode[i].sId,itemCode[i].iCode,itemCode[i].dis,itemCode[i].price,itemCode[i].qty,itemCode[i].cat);
				}
			}
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		}
		System.out.print("Search success. Do you want search again(Y/N) : ");
		char option = input.next().charAt(0);

		if (option == 'Y'|| option == 'y') {
			supplierWise();
		}
		else {
			stockManage();
		}
	}
	public static void viewCatagory(){
		tBar(Bar.bar[16]);
		String[][] view = new String[itemCode.length][1];
		for (int i = 0; i < category.length; i++) {
			boolean flag = true;
			for (int j = 0; j < itemCode.length; j++) {
				if (category[i].name.equals(itemCode[j].cat)) {
					if (flag == true) {
						System.out.println(category[i].name);
						System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
						System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |");
						System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
						flag = false;
					}
					for (int k = 0; k < 1 ; k++) {
						System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",itemCode[j].sId,itemCode[j].iCode,itemCode[j].dis,itemCode[j].price,itemCode[j].qty);
					}
					System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
				}
			}
		}
		System.out.print("Do you want to go stock manage page(Y/N) :");
		char option = input.next().charAt(0);

		if (option == 'Y' || option == 'y') {
			stockManage();
		}
		else{
			System.exit(0);
		}
	}
	public static void min(){
		tBar("RANKING");
		for (int i = 0; i < min.length-1; i++){
			for (int j = 0; j < min.length-1; j++){
				if(min[j]>min[j+1]){
					int x=min[j];
					min[j]=min[j+1];
					min[j+1]=x;
				}
			}
		}
		String[] temp = new String[min.length];
		for (int i = 0; i < min.length; i++) {
			temp[i] =""+min[i];
		}

		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		//System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
		System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n","SID","CODE","DESC","PRICE","QTY","CAT");
		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		for (int i = 0; i < min.length; i++) {
			for (int j = 0; j < itemCode.length; j++) {
				if (temp[i].equals(itemCode[j].price)) {
					System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",itemCode[j].sId,itemCode[j].iCode,itemCode[j].dis,itemCode[j].price,itemCode[j].qty,itemCode[j].cat);
				}
			}
		}
		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		System.out.print("Do you want to go to stock manage page(Y/N) : ");
		char option = input.next().charAt(0);
		if (option == 'Y'){
			stockManage();
		}
		else {
			return;
		}
	}
	public static item[] growItem(item[] supplier) {

		item[] temp = new item[supplier.length + 1];
		for (int i = 0; i < supplier.length; i++) {
			temp[i] = supplier[i];
		}
		return temp;
	}
	public static Category[] growCat(Category[] supplier) {

		Category[] temp = new Category[supplier.length + 1];
		for (int i = 0; i < supplier.length; i++) {
			temp[i] = supplier[i];
		}
		return temp;
	}
	public static Supplier[] grow(Supplier[] supplier) {

		Supplier[] temp = new Supplier[supplier.length + 1];
		for (int i = 0; i < supplier.length; i++) {
			temp[i] = supplier[i];
		}
		return temp;
	}
	public static Supplier[] growLess(Supplier supplier[],int index) {
		Supplier[]temp = new Supplier[supplier.length - 1];
		int k = 0;
		for (int i = 0; i < supplier.length; i++) {
			if(i == index) continue;
				temp[k] = supplier[i];

		}
		return temp;
	}
	public static Category[] growLessCat(Category supplier[],int index) {
		Category[]temp = new Category[supplier.length - 1];
		int k = 0;
		for (int i = 0; i < supplier.length; i++) {
			if(i == index) continue;
			temp[k] = supplier[i];

		}
		return temp;
	}
	public static int checkCat(String x, Category category[]){;
		int count = 0;
		for (int i = 0; i <category.length; i++) {
			if (category[i]!= null && x.equals(category[i].name)){
				count++;
			}
		}
		return count;
	}
	public static int check(String x, Supplier itemcode[]){;
		int count = 0;
		for (int i = 0; i <itemcode.length; i++) {
			if (supplier[i]!= null && x.equals(itemcode[i].id)){
				count++;
			}
		}
		return count;
	}
	public static int[] intGrow(int[] a) {
		int[] temp = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		return temp;
	}
	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Windows 10")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

