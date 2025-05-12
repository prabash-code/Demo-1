
import java.util.*;
class Burger{
	private String orderId;
	private String customerId;
	private String customerName;
	private int orderStatus;
	private int orderQty;
	private int orderValue; 
	
	
	public void setOrderValue(int orderValue){
		this.orderValue=orderValue;
	}
	
	public void setOrderStatus(int orderStatus){
		this.orderStatus=orderStatus;
	}
	
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	public void setQuantity(int orderQty){
		this.orderQty=orderQty;
	}
	
	public String getOrderId(){
		return orderId;
	}
	public String getcustomerId(){
		return customerId;
	}
	public String getcustomerName(){
		return customerName;
	}
	public int getOrderStatus(){
		return orderStatus;
	}
	public String getId(){
		return orderId;
	}
	public int getOrderQty(){
		return orderQty;
	}
	public int getOrderValue(){
		return orderValue;
		
	}
	 Burger(){
		
	}
	Burger(String orderId,String customerId,String customerName,int orderStatus,int orderQty,int orderValue){
		this.orderId=orderId;
		this. customerId=customerId;
		this.customerName=customerName;
		this.orderStatus=orderStatus;
		this.orderQty=orderQty;
		this.orderValue=orderValue;
	}
}

class Demo {

    final static int BURGERPRICE = 500;

    // Order Array
  // public static String[] orderIdArray = { "B0001", "B0002", "B0003", "B0004", "B0005", "B0006", "B0007", "B0008", "B0009", "B0010", "B0011", "B0012", "B0013", "B0014", "B0015" };
    // Customer Arrays
  /*  public static String[] orderCustomerArray = { "0701111111", "0777777777", "0342222222", "0777777777", "0386677676", "0715455465", "0709353956", "0724565562", "0715455465", "0342222222", "0342233223", "0755080123", "0715994936", "0715994940", "0745994967" };
    public static String[] customerNameArray = { "Amali", "Shehan", "Kasun", "Shehan", "Chathura", "Ruwan", "Rishmi", "Gihan", "Ruwan", "Dilshan", "Hasindu", "Eshan", "Ravindu", "Harshana", "Pasindu", };
    public static int[] orderStatusArray = { 2, 1, 2, 2, 1, 1, 0, 2, 1, 1, 2, 2, 1, 0, 2 };
    public static int[] orderQTYArray = { 1, 2, 4, 2, 1, 1, 3, 6, 5, 2, 7, 3, 2, 2, 1 };
    public static double[] orderValueArray = { 500, 1000, 2000, 1000, 500, 500, 1500, 3000, 2500, 1000, 3500, 1500, 1000, 1000, 500 };*/

    // Order status
    public static final int CANCEL = 0;
    public static final int PREPARING = 1;
    public static final int DELIVERED = 2;
   
  
    public static Burger []burgerArray = new Burger[]{
										new Burger( "B0001", "0701111111","Amali",2,1,500),
										new Burger( "B0002", "0777777777","Shehan",1,2,1000),											
										new Burger( "B0003","0342222222","Kasun",2,4,2000),
										new Burger( "B0004", "0777777777","Shehan",2,2,1000),
										new Burger( "B0005", "0386677676","Chathura",1,1,500),
										new Burger( "B0006", "0715455465","Ruwan",1,1,500),
										new Burger( "B0007","0709353956" ,"Rishmi",0,3,1500),
										new Burger( "B0008", "0724565562","Gihan",2,6,3000),
										new Burger( "B0009",  "0715455465","Ruwan",1,5,2500),
										new Burger( "B0010",  "0342222222","Dilshan",1,2,1000),
										new Burger( "B0011", "0342233223","Hasindu",2,7,3500),
										new Burger( "B0012",  "0755080123","Eshan",2,3,1500),
										new Burger( "B0013", "0715994936","Ravindu",1,2,1000),
										new Burger( "B0014",  "0715994940","Harshana",0,2,1000),
										new Burger( "B0015",  "0745994967","Pasindu",2,1,500)
									};
								
										
    // console clear
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    // validation Customer ID
    public static boolean validationcustomerId(String customerId) {
        if (customerId.length() == 10) {
            if (customerId.startsWith("0")) {
                try {
                    int i = Integer.parseInt(customerId);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    // generate order Id
    public static String generateOrderId() {
		/*if (orderIdArray.length==0){
			return "B0001";
		}
        String lastOrderId = orderIdArray[orderIdArray.length - 1];
        int x = Integer.parseInt(lastOrderId.substring(1)); //1
        int temp = ++x; 
        int count = 0; 
        while (temp != 0) {
            count++;
            temp /= 10; //temp = temp/10;
        }
        switch (count) {
            case 1:
                return "B000" + x;
            case 2:
                return "B00" + x;
            case 3:
                return "B0" + x;
            default:
                return "B" + x;
        }*/
        if(burgerArray.length==0){
			return "B0001";
		}
		Burger lastid = burgerArray[burgerArray.length - 1];
		String lastOrderId=lastid.getId();
		int number = Integer.parseInt(lastOrderId.split("B")[1]); //1
		number++;//2
		return String.format("B%04d",number); //printf("",) //B0002
    }

    // placeOrder
    public static void placeOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPLACE ORDER\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n\n");
        System.out.print("ORDER ID - ");
        String orderId = generateOrderId();
        System.out.println(orderId + "\n================\n\n");

        L1: do { 
            System.out.print("Enter Customer ID (phone no.): ");
            String customerId = input.next();
            if (customerId.charAt(0)!='0' || customerId.length()!=10){
				continue L1;
			}
            boolean isExistCustomer = false;
            String customerName = "";
            for (int i = 0; i < burgerArray.length; i++) {
                if (customerId.equals(burgerArray[i].getcustomerId())) {
                    isExistCustomer = true;
                    System.out.println("Enter Customer Name: " + burgerArray[i].getcustomerName());
                    customerName = burgerArray[i].getcustomerName();
                    break;
                }
            }
            if (!isExistCustomer) {
                System.out.print("\nEnter Customer Name: ");
                customerName = input.next();
            }
            System.out.print("Enter Burger Quantity - ");
            int qty = input.nextInt();
            if (qty > 0) {
                int billValue = qty * BURGERPRICE;
                System.out.printf("Total value - %d", billValue);
                System.out.println();
                L3: do {
                    System.out.print("\tAre you confirm order - ");
                    String option = input.next().toUpperCase();
                    if (option.equalsIgnoreCase("Y")) { 
						Burger burger1=new Burger(orderId,customerId,customerName,0,qty,billValue);
                       Burger []tempburger=new Burger[burgerArray.length+1]; 
                       for(int i=0;i<burgerArray.length;i++){
						   tempburger[i]=burgerArray[i];
					   }
                       burgerArray=tempburger;
                       burgerArray[burgerArray.length-1]=burger1;                       
                        System.out.println("\n\tYour order is enter to the system successfully...");
                        break L1;
                    } else if (option.equalsIgnoreCase("N")) {
                        System.out.println("\n\tYour order is not enter the system...");
                        clearConsole();
                        return;
                    } else {
                        System.out.println("\tInvalid option..input again...");
                        break L1;
                    }
                } while (true);
            }
           
        } while (true);
        L4: do {
            System.out.println();
            System.out.print("Do you want to place another order (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                placeOrder();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L4;
            }
        } while (true);

    }

    // Search best customer
    public static boolean searchCustomerisDuplicate(String []customerNotDuplicateArray,String burgerArray[].getcustomerName()){
		for(int i=0;i<cus tomerNotDuplicateArray.length;i++){
			if(burgerArray[i].getcustomerName().equals(customerNotDuplicateArray[i])){
				return true;
			}
			return false;		
		}
	}    
    public static void searchBestCustomer() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tBEST Customer\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n");
               String[] customerNotDuplicateArray = new String[0];

        for (int i = 0; i < burgerArray.length; i++) {
			if(!searchCustomerisDuplicate( customerNotDuplicateArray,burgerArray[i].getcustomerName())){
				int[] tempNameArray=new int[customerNotDuplicateArray.length+1];
				for(int j=0;j<customerNotDupplicateArray.length;j++){
					tempNameArray[j]=customerNotDuplicateArray[j];
					
					
				}
				tempNameArray[tempNameArray.length-1]=burgerArray[i].getcustomerName();
				burgerArray=tempNameArray;
			}
			
		}
        // sort
        for (int i = 1; i < sortCustomerIdArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (customerTotalBuyingArray[j] < customerTotalBuyingArray[i]) {
                    String temp = sortCustomerIdArray[j];
                    sortCustomerIdArray[j] = sortCustomerIdArray[i];
                   
                    sortCustomerIdArray[i] = temp;
                    temp = sortCustomerName[j];
                   
                    sortCustomerName[j] = sortCustomerName[i];
                    sortCustomerName[i] = temp;
                    double tempd = customerTotalBuyingArray[j];
                   
                    customerTotalBuyingArray[j] = customerTotalBuyingArray[i];
                    customerTotalBuyingArray[i] = tempd;
                }
            }
        }
        System.out.println("\n----------------------------------------");
        String line1 = String.format("%-14s%-15s%8s", " CustomerID", "Name", "Total");
        System.out.println(line1);
        System.out.println("----------------------------------------");
        for (int i = 0; i < sortCustomerIdArray.length; i++) {

            String line = String.format("%1s%-14s%-15s%8.2f", " ", sortCustomerIdArray[i], sortCustomerName[i], customerTotalBuyingArray[i]);
            System.out.println(line);
            System.out.println("----------------------------------------");

        }
        L: do {
            Scanner input = new Scanner(System.in);
            System.out.print("\n\tDo you want to go back to main menu? (Y/N)> ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("Y")) {
                clearConsole();
                homePage();
            } else if (exitOption.equalsIgnoreCase("N")) {
                clearConsole();
                searchBestCustomer();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L;
            }
        } while (true);

    }

    // search order
    public static void searchOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tSEARCH ORDER DETAILS\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        L1: do {
            System.out.print("Enter order Id - ");
            String orderId = input.next();
            System.out.println();
            for (int i = 0; i < burgerArray.length; i++) {
                if (orderId.equals(burgerArray[i].getOrderId())) {
                    // int j=search(orderCustomerArray[i]);
                    String status = "";
                    switch (burgerArray[i].getOrderStatus()) {
                        case CANCEL:
                            status = "Cancel";
                            break;
                        case PREPARING:
                            status = "Preparing";
                            break;
                        case DELIVERED:
                            status = "Delivered";
                            break;
                    }
                    System.out.println("---------------------------------------------------------------------------");
                    String line1 = String.format("%-10s%-14s%-12s%-10s%-14s%-10s", " OrderID", " CustomerID", " Name",
                            "Quantity", "  OrderValue", "  OrderStatus");
                    System.out.print(line1);
                    System.out.println(" |");
                    System.out.println("---------------------------------------------------------------------------");
                    //String line = String.format("-10s%-14s%-15s%-10d%-14d%-10s", burgerArray[i].getOrderId(), burgerArray[i].getcustomerId(), burgerArray[i].getcustomerName(),burgerArray[i].getOrderQty(),burgerArray[i].getOrderValue(),burgerArray[i].getOrderStatus());
                   System.out.print(burgerArray[i].getOrderId()+"\t " +burgerArray[i].getcustomerId()+"\t"+ burgerArray[i].getcustomerName()+"\t\t"+burgerArray[i].getOrderQty()+"\t\t"+burgerArray[i].getOrderValue()+"\t"+burgerArray[i].getOrderStatus());
                    System.out.println("|");
                    System.out.println("---------------------------------------------------------------------------");
                    break L1;
                }
            }
            L2: do {
                System.out.print("\n\nInvalid Order ID. Do you want to enter again? (Y/N)>");
                String option = input.next();
                if (option.equalsIgnoreCase("Y")) {
                    clearConsole();
                    searchOrder();
                } else if (option.equalsIgnoreCase("N")) {
                    clearConsole();
                    return;
                } else {
                    System.out.println("\tInvalid option..input again...");
                    continue L2;
                }
            } while (true);
        } while (true);
        L3: do {
            System.out.println();
            System.out.print("Do you want to search another order details (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                searchOrder();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L3;
            }
        } while (true);
    }

    // search Customer
    public static void searchCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tSEARCH CUSTOMER DETAILS\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        L1: do {
            System.out.print("Enter customer Id - ");
            String customerId = input.next();
            System.out.println("\n");
            for (int i = 0; i <burgerArray.length; i++) {
                if (customerId.equals(burgerArray[i].getcustomerId())) {
                    System.out.println("CustomerID - " + burgerArray[i].getcustomerId());
                    System.out.println("Name       - " + burgerArray[i].getcustomerName());
                    System.out.println("\nCustomer Order Details");
                    System.out.println("========================\n");
                    System.out.println("----------------------------------------------");
                    String line = String.format("%-12s%-18s%-14s", " Order_ID", "Order_Quantity", "Total_Value  ");
                    System.out.println(line);
                    System.out.println("----------------------------------------------");
                    for (int j = 0; j < burgerArray.length; j++) {
                        if (burgerArray[j].getcustomerId().equals(customerId)) {
                           // String line2 = String.format("%1s%-12s%-18d%-14.2f", " ", burgerArray[j].getOrderId(), burgerArray[j].getOrderQty(), burgerArray[j].getOrderValue());
                            System.out.println( burgerArray[j].getOrderId()+"\t "+ burgerArray[j].getOrderQty()+"\t "+burgerArray[j].getOrderValue());
                        }
                    }
                    System.out.println("----------------------------------------------");
                    break L1;
                }

            }
            L2: do {
                System.out.print("\n\nInvalid Customer ID. Do you want to enter again? (Y/N)>");
                String option = input.next();
                if (option.equalsIgnoreCase("Y")) {
                    clearConsole();
                    searchCustomer();
                } else if (option.equalsIgnoreCase("N")) {
                    clearConsole();
                    return;
                } else {
                    System.out.println("\tInvalid option..input again...");
                    continue L2;
                }
            } while (true);
        } while (true);
        L3: do {
            System.out.println();
            System.out.print("Do you want to search another customer details (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                searchCustomer();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L3;
            }
        } while (true);
    }

    // View Order list
    public static void viewOrders() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tVIEW ORDER LIST\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n");
        System.out.println("[1] Delivered Order");
        System.out.println("[2] Preparing Order");
        System.out.println("[3] Cancel Order");

        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
        switch (option) {
            case 1:
                clearConsole();
                deliverOrder();
                break;
            case 2:
                clearConsole();
                preparingOrder();
                break;
            case 3:
                clearConsole();
                cancelOrder();
                break;
        }
    }

    // Delivered Order
    public static void deliverOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tDELIVERED ORDER\t\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\n--------------------------------------------------------------");
        String line1 = String.format("%-10s%-15s%-13s%-10s%12s", " OrderID", " CustomerID", " Name", "Quantity",
                "  OrderValue");
        System.out.println(line1);
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getOrderStatus() == DELIVERED) {
                // int j=search(orderCustomerArray[i]);
                //String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", burgerArray[i].getOrderId(),burgerArray[i].getcustomerId(),
                       //burgerArray[i].getcustomerName(), burgerArray[i].getOrderQty(), burgerArray[i].getOrderValue());
                System.out.println(burgerArray[i].getOrderId()+"\t " +burgerArray[i].getcustomerId()+"\t"+ burgerArray[i].getcustomerName()+"\t\t"+burgerArray[i].getOrderQty()+"\t\t"+burgerArray[i].getOrderValue());
                System.out.println("--------------------------------------------------------------");
            }
        }
        L1: do {
            System.out.print("\nDo you want to go to home page (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                homePage();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                deliverOrder();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L1;
            }
        } while (true);
    }

    // Preparing Order
    public static void preparingOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPREPARING ORDER\t\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\n--------------------------------------------------------------");
        String line1 = String.format("%-10s%-15s%-13s%-10s%12s", " OrderID", " CustomerID", " Name", "Quantity",
                "  OrderValue");
        System.out.println(line1);
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getOrderStatus() == PREPARING) {
                // int j=search(orderCustomerArray[i]);
               // String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", burgerArray[i].getOrderId(),burgerArray[i].getcustomerId(),
                 //      burgerArray[i].getcustomerName(), burgerArray[i].getOrderQty(), burgerArray[i].getOrderValue());
                System.out.println(burgerArray[i].getOrderId()+"\t " +burgerArray[i].getcustomerId()+"\t"+ burgerArray[i].getcustomerName()+"\t\t"+burgerArray[i].getOrderQty()+"\t\t"+burgerArray[i].getOrderValue());
                System.out.println("--------------------------------------------------------------");
            }
        }
        L1: do {
            System.out.print("\nDo you want to go to home page (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                homePage();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                preparingOrder();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L1;
            }
        } while (true);
    }

    // Cancel Order
    public static void cancelOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tCANCEL ORDER\t\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\n--------------------------------------------------------------");
        String line1 = String.format("%-10s%-15s%-13s%-10s%12s", " OrderID", " CustomerID", " Name", "Quantity",
                "  OrderValue");
        System.out.println(line1);
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i <burgerArray.length; i++) {
            if (burgerArray[i].getOrderStatus() == CANCEL) {
                // int j=search(orderCustomerArray[i]);
               // String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", burgerArray[i].getOrderId(), burgerArray[i].getcustomerId(),
                 //       burgerArray[i].getcustomerName(), burgerArray[i].getOrderQty(), burgerArray[i].getOrderValue());
                System.out.println(burgerArray[i].getOrderId()+"\t " +burgerArray[i].getcustomerId()+"\t"+ burgerArray[i].getcustomerName()+"\t\t"+burgerArray[i].getOrderQty()+"\t\t"+burgerArray[i].getOrderValue());
                System.out.println("--------------------------------------------------------------");
            }
        }
        L1: do {
            System.out.print("\nDo you want to go to home page (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                homePage();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                cancelOrder();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L1;
            }
        } while (true);
    }

    // Update order details
    public static void updateOrderDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tUPDATE ORDER DETAILS\t\t\t\t|");
        System.out.println("--------------------------------------------------------------------------------\n");
        L1: do {
            System.out.print("Enter order Id - ");
            String orderId = input.next();
            System.out.println();
            for (int i = 0; i < burgerArray.length; i++) {
                if (orderId.equals(burgerArray[i].getOrderId())) {
                    // int j=search(orderCustomerArray[i]);
                    String status = "";
                    switch (burgerArray[i].getOrderStatus()) {
                        case 0:
                            status = "Cancel";
                            break;
                        case 1:
                            status = "Preparing";
                            break;
                        case 2:
                            status = "Delivered";
                            break;
                    }
                    if (status == "Cancel") {
                        System.out.println("This Order is already cancelled...You can not update this order...");
                    } else if (status == "Delivered") {
                        System.out.println("This Order is already delivered...You can not update this order...");
                    } else {
                        System.out.println("OrderID    - " + burgerArray[i].getOrderId());
                        System.out.println("CustomerID - " + burgerArray[i].getcustomerId());
                        System.out.println("Name       - " + burgerArray[i].getcustomerName());
                        System.out.println("Quantity   - " + burgerArray[i].getOrderQty());
                        System.out.printf("OrderValue  - "+burgerArray[i].getOrderValue());
                        System.out.println("\nOrderStatus- " +status);

                        System.out.println("\nWhat do you want to update ? ");
                        System.out.println("\t(01) Quantity ");
                        System.out.println("\t(02) Status ");
                        System.out.print("\nEnter your option - ");
                        int option = input.nextInt();
                        switch (option) {
                            case 1:
                                clearConsole();
                                System.out.println("\nQuantity Update");
                                System.out.println("================\n");
                                System.out.println("OrderID    - " +burgerArray[i].getOrderId() );
                                System.out.println("CustomerID - " + burgerArray[i].getcustomerId());
                                System.out.println("Name       - " +burgerArray[i].getcustomerName());
                                System.out.print("\nEnter your quantity update value - ");
                                int qty = input.nextInt();
                               burgerArray[i].setQuantity(qty); 
                               int total=qty * BURGERPRICE;
                                burgerArray[i].setOrderValue(total);
                                System.out.println("\n\tupdate order quantity success fully...");
                                System.out.println("\nnew order quantity - " +burgerArray[i].getOrderQty());
                                System.out.println("new order value - "+total  );
                                break;
                            case 2:
                                clearConsole();
                                System.out.println("\nStatus Update");
                                System.out.println("==============\n");
                                System.out.println("OrderID    - " +burgerArray[i].getOrderId());
                                System.out.println("CustomerID - " +burgerArray[i].getcustomerId());
                                System.out.println("Name       - " +burgerArray[i].getcustomerName());
                                System.out.println("\n\t(0)Cancel");
                                System.out.println("\t(1)Preparing");
                                System.out.println("\t(2)Delivered");
                                System.out.print("\nEnter new order status - ");
                                int s = input.nextInt();
                               burgerArray[i].setOrderStatus(s);
                                switch (burgerArray[i].getOrderStatus()) {
                                    case 0:
                                        status = "Cancel";
                                        break;
                                    case 1:
                                        status = "Preparing";
                                        break;
                                    case 2:
                                        status = "Delivered";
                                        break;
                                }
                                System.out.println("\n\tUpdate order status successfully...");
                                System.out.println("\nnew order status - " + status);
                                break;
                        }
                    }
                    break L1;
                }
            }
            L3: do {
                System.out.print("\n\nInvalid Order ID. Do you want to enter again? (Y/N)>");
                String option = input.next();
                if (option.equalsIgnoreCase("Y")) {
                    System.out.println("\n");
                    continue L1;
                } else if (option.equalsIgnoreCase("N")) {
                    clearConsole();
                    return;
                } else {
                    System.out.println("\tInvalid option..input again...");
                    continue L3;
                }
            } while (true);
        } while (true);
        L3: do {
            System.out.println();
            System.out.print("Do you want to update another order details (Y/N): ");
            String option = input.next();
            if (option.equalsIgnoreCase("Y")) {
                clearConsole();
                updateOrderDetails();
            } else if (option.equalsIgnoreCase("N")) {
                clearConsole();
                homePage();
            } else {
                System.out.println("\tInvalid option..input again...");
                continue L3;
            }
        } while (true);
    }

    // exit
    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
    }

    // home page
    public static void homePage() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tiHungry Burger\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n");
        System.out.println("[1] Place Order\t\t\t[2] Search Best Customer");
        System.out.println("[3] Search Order\t\t[4] Search Customer");
        System.out.println("[5] View Orders\t\t\t[6] Update Order Details");
        System.out.println("[7] Exit");

        Scanner input = new Scanner(System.in);
        do {

            System.out.print("\nEnter an option to continue > ");
            char option = input.next().charAt(0);

            switch (option) {
                case '1':
                    clearConsole();
                    placeOrder();
                    break;
                case '2':
                    clearConsole();
                   // searchBestCustomer();
                    break;
                case '3':
                    clearConsole();
                    searchOrder();
                    break;
                case '4':
                    clearConsole();
                    searchCustomer();
                    break;
                case '5':
                    clearConsole();
                    viewOrders();
                    break;
                case '6':
                    clearConsole();
                    updateOrderDetails();
                    break;
                case '7':
                    exit();
                    break;
            }
        } while (true);
    }

    public static void main(String args[]) {
        homePage();
    }

}

  
