import java.util.*;

class Example {
    public static void selectionCase1() {
        clearConsole();
        System.out.println("[1]Rent Tax");
        System.out.println("[2]Bank Interest Tax");
        System.out.println("[3]Divident Tax");
        System.out.println("[4]Exit");
        System.out.println("");
    }

    public static double ssclTaxCount(double value) {

        double saleTax = (value * (2.5 / 100));
        double valueOfGoods = (value + saleTax) * 15 / 100;
        double totalTax = valueOfGoods + saleTax;

        return totalTax;
    }

    public static void incomeTaxCount(double salary) {

        double sal1, sal2, sal3, sal4, sal5, sal6;
        if (salary < 1200000) {

            System.out.println("You don't have to pay Income Tax...");
        } else if (salary >= 1200000 && salary <= 1700000) {
            sal1 = (salary - 1200000) * 0.06;
            System.out.println("You  have to pay Income Tax :" + sal1);
        } else if (salary <= 2200000) {
            sal2 = ((salary - 1700000) * 0.12) + (500000 * 0.06);
            System.out.println("You  have to pay Income Tax :" + sal2);
        } else if (salary <= 2700000) {
            sal3 = ((salary - 2200000) * 0.18) + (500000 * 0.12) + (500000 * 0.06);
            System.out.println("You  have to pay Income Tax :" + sal3);
        } else if (salary <= 3200000) {
            sal4 = ((salary - 2700000) * 0.24) + (500000 * 0.18) + (500000 * 0.12) + (500000 * 0.06);
            System.out.println("You  have to pay Income Tax :" + sal4);
        } else if (salary <= 3700000) {
            sal5 = ((salary - 3200000) * 0.30) + (500000 * 0.24) + (500000 * 0.18) + (500000 * 0.12) + (500000 * 0.06);
            System.out.println("You  have to pay Income Tax :" + sal5);
        } else if (salary > 3700000) {
            sal6 = ((salary - 3700000) * 0.36) + (500000 * 0.30) + (500000 * 0.24) + (500000 * 0.18) + (500000 * 0.12) + (500000 * 0.06);
            System.out.println("You  have to pay Income Tax :" + sal6);
        }

    }

    public static void calSsclTax() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        L3:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                SOCIAL SECURITY CONTRIBUTION LEVY(SSCL)TAX                  |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Enter value of good or service:");
            double value = input.nextInt();
            double totalTax = ssclTaxCount(value);

            System.out.println("");
            System.out.println("You have to pay SSCL Tax:" + totalTax);
            L4:
            do {
                clearConsole();
                System.out.print("Do you to calculate another Payable Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);
    }

    public static void calIncomeTax() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        L3:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                              INCOME TAX                                    |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Enter your employee income for year : ");
            double salary = input.nextDouble();
            incomeTaxCount(salary);

            L4:
            do {
                System.out.print("Do you to calculate another Payable Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);
    }

    public static void calPayableTax() {
        Scanner input = new Scanner(System.in);
        L3:
        do {
            clearConsole();
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                              PAYABLE TAX                                   |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");


            System.out.print("Enter your employee payment for year : ");
            double salary = input.nextDouble();
            System.out.println(" ");
            double salx, saly, salz, salt, salu, salv;
            if (salary > 308333) {
                salx = (((salary - 308333) * 0.36) + 37500);

                System.out.println("You have to pay payable Tax per year:" + salx);

            } else if (salary > 266667) {
                saly = (((salary - 266667) * 0.30) + 25000);

                System.out.println("You have to pay paybale Tax per year:" + saly);
            } else if (salary > 225000) {
                salz = (((salary - 225000) * 0.24) + 15000);

                System.out.println("You have to pay payable Tax per year:" + salz);
            } else if (salary > 183333) {
                salt = (((salary - 183333) * 0.18) + 7500);

                System.out.println("You have to pay payable Tax per year:" + salt);
            } else if (salary > 141667) {
                salu = (((salary - 141667) * 0.12) + 2500);

                System.out.println("You have to pay payable Tax per year:" + salu);

            } else if (salary > 100000) {
                salv = ((salary - 100000) * 0.06);

                System.out.println("You have to pay payable Tax per year:" + salv);
            } else {
                System.out.println("You don't have to pay payable Tax...");
            }

            L4:
            do {
                System.out.print("Do you to calculate another Payable Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);

    }

    public static void calRentTax() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        L3:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                             RENT TAX                                       |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Enter your rent         :");
            int rent = input.nextInt();
            if (rent < 0) {
                System.out.println("Invaild input........");
            } else if (rent >= 100000) {
                rent = (rent * 10 / 100);
                System.out.println("You have to pay Rent Tax:" + rent);
            } else if (rent < 100000 && rent > 0) {
                System.out.println("You dont have to pay rent tax...");
            }
            System.out.println("");

            System.out.println("");
            System.out.println("");
            L4:
            do {
                System.out.print("Do you to calculate another Rent Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);
    }
public static int calInterestTax(int interest) {
	clearConsole();
	if (interest < 0) {
                System.out.println("Invaild input........");
            } else {
                interest = (interest * 5 / 100);
			}return interest;
}
    public static void calBankInterestTax() {
        
        Scanner input = new Scanner(System.in);
        L3:
        do {clearConsole();
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                         BANK INTERSET TAX                                  |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Enter your bank interest for year         :");
            int interest = input.nextInt();
             interest=calInterestTax(interest);
                System.out.println("You have to pay Bank Interset Tax    :" + interest);
            
            System.out.println("");
            System.out.println("");
            L4:
            do {
                System.out.print("Do you to calculate another Bank Interest Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);

    }
	 public static int caldividentTax(int devident){
		 if (devident < 0) {
                System.out.println("Invaild input........");
            } else if (devident >= 100000) {
                devident = (devident * 14 / 100);
                System.out.println("You have to pay Rent Tax:" + devident);
            } else if (devident < 100000 && devident > 0) {
                System.out.println("You dont have to pay devident tax...");
            }
				return devident;
		 
	 }
    public static void caldivident() {
        Scanner input = new Scanner(System.in);
        L3:
        do {
            clearConsole();
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                             DEVIDENT TAX                                   |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Enter your total devident for year        :");
            int devident = input.nextInt();
            devident=caldividentTax(devident);
            System.out.println("\n");
            L4:
            do {
                System.out.print("Do you to calculate another Devident Tax(Y/N):");
                String calAgain = input.next();
                char op = calAgain.charAt(0);
                if (op == 'Y' || op == 'y') {
                    continue L3;
                } else if (op == 'N' || op == 'n') {
                    break L3;
                } else {
                    System.out.println("invalid input... ");
                    continue L4;
                }
            } while (true);
        } while (true);


    }

    public static void homepage() {
        System.out.println("\t[1]Withholding Tax");
        System.out.println("\t[2]Payable Tax");
        System.out.println("\t[3]Income Tax");
        System.out.println("\t[4]Social Security Contribution Levy(SSCL)Tax");
        System.out.println("\t[5]leasing Payment");
        System.out.println("\t[6]Exit");
        System.out.println("\n");

    }

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

        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println(" 	                                        _  _______  _________ _______      ");
        System.out.println("                                               | \\/       \\|         |       \\    ");
        System.out.println("                                               \\$ |  $$$$$$| $$$$$$$$\\$$$$$$$$    ");
        System.out.println("                                               |  | $$     | $$__       | $$       ");
        System.out.println("                                               |$$| $$     | $$  \\      | $$       ");
        System.out.println("                                               |$$| $$   __| $$$$$      | $$       ");
        System.out.println("                                               |$$| $$__/  | $$_____    | $$       ");
        System.out.println("                                               |$$ \\ $$   $| $$     \\   | $$       ");
        System.out.println("                                               \\$$  \\$$$$$$ \\$$$$$$$$    \\$$       ");
        System.out.println("");

        System.out.println("      _______              _     _     ____             _          ____    _     _   _                  _________    ____    _____     ");
        System.out.println("     |__   __|     /\\     \\ \\  / /    / ___|    /\\     | |        / ___|  | |   | | | |           /\\   |___   ___|  / __ \\  |  __ \\   ");
        System.out.println("        | |       /  \\     \\ \\/ /    | |       /  \\    | |       | |      | |   | | | |          /  \\      | |     | |  | | | |__) |   ");
        System.out.println("        | |      / /\\ \\     >  <     | |      / /\\ \\   | |       | |      | |   | | | |         / /\\ \\     | |     | |  | | |  _  /    ");
        System.out.println("        | |     / ____ \\   / .  \\    | |___  / ____ \\  | |____   | |___   | |___| | | |____    / ____ \\    | |     | |__| | | | \\ \\  ");
        System.out.println("        |_|    /_/    \\_\\ /_/  \\_\\    \\____|/_/    \\_\\ |______|   \\____|   \\_____/  |______|  /_/    \\_\\   |_|      \\____/  |_|  \\_\\ ");
        System.out.println("");
        System.out.println("==================================================================================================================================================");

        L1:
        do {
            clearConsole();
            homepage();
            System.out.print("Enter an option to continue->");
            int opt = input.nextInt();


            switch (opt) {
                case 1:
                    L2:
                    do {

                        selectionCase1();

                        System.out.print("Enter an option to continue->");
                        int option = input.nextInt();


                        switch (option) {

                            case 1:
                                calRentTax();
                                break;
                            case 2:
                                calBankInterestTax();
                                break;
                            case 3:
                                caldivident();

                                break;
                            case 4:

                                break L2;
                            default:
                                System.out.println("Invalid answer/input answer again.... ");
                                continue L2;
                        }


                    } while (true);

                case 2:
                    calPayableTax();
                    break;
                case 3:
                    calIncomeTax();
                    break;
                case 4:
                    calSsclTax();
                    break;
                case 5:
                    clearConsole();
                    L3:
                    do {
                        System.out.println("+----------------------------------------------------------------------------+");
                        System.out.println("|                              LEASING PAYMENT                               |");
                        System.out.println("+----------------------------------------------------------------------------+");
                        System.out.println("");
                        System.out.println("[1]Calculate Monthly Installment");
                        System.out.println("[2]Search Leasing Category");
                        System.out.println("[3]Find Leasing Amount");
                        System.out.println("[4]Exit");
                        System.out.print("Enter an option to continue->");
                        int select = input.nextInt();
                        switch (select) {
                            case 1:

                                L4:
                                do {
                                    clearConsole();
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("|                    Calculate Leasing Payment                               |");
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("");
                                    System.out.print("Enter lease amount: ");
                                    double leaseAmount = input.nextDouble();
                                    System.out.print("Enter annual interest rate:");
                                    double leaseRate = input.nextDouble();
                                    System.out.print("Enter number of year:");
                                    double years = input.nextDouble();

                                    double monthIns = ((leaseAmount * leaseRate) / 12) / ((1 - (1 / (Math.pow((1 + (leaseRate / 12)), (years * 12))))));


                                    if (years <= 5) {
                                        System.out.print("Your monthly installment:" + monthIns);


                                    } else {
                                        System.out.println("Invalid number of year...Enter the correct value again...");
                                        continue L4;
                                    }

                                    System.out.println("");
                                    L6:
                                    do {
                                        System.out.print("Do you to calculate another Monthly Installment (Y/N):");
                                        String calAgain = input.next();
                                        char op = calAgain.charAt(0);
                                        if (op == 'Y' || op == 'y') {
                                            continue L4;
                                        } else if (op == 'N' || op == 'n') {
                                            break L3;
                                        } else {
                                            System.out.println("invalid input... ");
                                            continue L6;
                                        }
                                    } while (true);
                                } while (true);

                            case 2:

                                L4:
                                do {
                                    clearConsole();
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("|                    Searching Leasing Category                              |");
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("");
                                    System.out.print("Enter lease amount: ");
                                    int leaseAmout = input.nextInt();
                                    System.out.print("Enter annual interest rate:");
                                    int leaseRate = input.nextInt();
                                    System.out.println("Your monthly installment for 3 year leasing plan: ");
                                    System.out.println("Your monthly installment for 4 year leasing plan: ");
                                    System.out.println("Your monthly installment for 5 year leasing plan: ");
                                    System.out.println("");
                                    System.out.println("");
                                    L5:
                                    do {
                                        System.out.print("Do you search another lesing category(Y/N):");
                                        String calAgain = input.next();
                                        char op = calAgain.charAt(0);
                                        if (op == 'Y' || op == 'y') {
                                            continue L4;
                                        } else if (op == 'N' || op == 'n') {
                                            break L4;
                                        } else {
                                            System.out.println("invalid input... ");
                                            continue L5;
                                        }
                                    } while (true);


                                } while (true);

                                break;
                            case 3:
                                L4:
                                do {
                                    clearConsole();
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("|                          Find Leasing Amount                               |");
                                    System.out.println("+----------------------------------------------------------------------------+");
                                    System.out.println("");
                                    System.out.print("Enter monthly lease payment amount you can afford	 : ");
                                    double monthlyIns = input.nextDouble();
                                    System.out.print("Enter number of year:");
                                    double n = input.nextDouble();
                                    System.out.print("Enter annual interest rate:");
                                    double r = input.nextDouble();
                                    double loanAmount = monthlyIns * (1 - (1 / Math.pow(1 + (r / 12), (n * 12)))) / (r / 12);


                                    System.out.println("You can get Lease amount:" + loanAmount);

                                    L5:
                                    do {
                                        System.out.print("Do you search another lesing amount(Y/N):");
                                        String calAgain = input.next();
                                        char op = calAgain.charAt(0);
                                        if (op == 'Y' || op == 'y') {
                                            continue L4;
                                        } else if (op == 'N' || op == 'n') {
                                            break L4;
                                        } else {
                                            System.out.println("invalid input... ");
                                            continue L5;
                                        }
                                    } while (true);
                                } while (true);
                                break;
                            case 4:
                                break L3;

                            default:
                                System.out.println("invalid input...try again..");
                                continue L3;


                        }


                    } while (true);


                case 6:
                    break L1;


                default:
                    System.out.println("Wrong selection / input answer again....");
                    continue L1;


            }

        } while (true);


    }
}
