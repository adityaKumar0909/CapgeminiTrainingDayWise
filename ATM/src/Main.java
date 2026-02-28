import java.util.*;

class Main{
    static class ATM{

        private long account;
        private long PIN;
        private double balance;
        boolean isProgramRunning;
        boolean isFirstTime = true;
        Scanner sc = new Scanner(System.in);

//        static HashMap<long,long>


        long getPIN(){
            return PIN;
        }
        double getBalance() {
            return balance;
        }

        void setPIN(long pin){
            PIN = pin;
        }
        boolean validatePass(long pass){
            return PIN == pass;
        }

        void startMenu(){
            System.out.println("Welcome to XYZ bank");
            System.out.println("Enter your card number to proceed");
            long accountNum = sc.nextLong();
            System.out.println("Enter your password");
            long pin = sc.nextLong();
            if(isFirstTime) {screen2();
            isFirstTime = false;}
            else{
                if(validatePass(pin)) screen2();
                else{
                    System.out.println("Wrong password !");
                    startMenu();
                }
            }


        }

        void screen2(){
            System.out.println("---------------------------");
            System.out.println("How can we help you today?");
            System.out.println("(1) Deposit");
            System.out.println("(2) Withdrawal");
            System.out.println("(3) Check Balance");
            System.out.println("(4) Change PIN");
            System.out.println("(5) Quick Withdrawal");
            System.out.println("(6) Quit ");

            System.out.println("---------------------------");
            System.out.println("Enter your option to continue ...");
            int option = sc.nextInt();
            switch(option){
                case 1: DepositMoney();
                    break;
                case 2: WithdrawMoney();
                    break;
                case 3: CheckBalance();
                    break;
                case 4 : ChangePassword();
                    break;
                case 5: QuickWithdrawl();
                    break;
                case 6: ;
                    break;
                default:{
                    System.out.println("invalid option !");
                    startMenu();
                }
            }
        }

        private void QuickWithdrawl() {
            int option;
            option = sc.nextInt();
            switch(option){
                case 1: {
                    if(balance>=1000){
                        balance-=1000;
                        System.out.println("1000 withdrawn successfully");
                    }
                    else{
                        System.out.println("insufficient balance");

                    }

                }
                break;
                case 2:{
                    if(balance>=2000){
                        balance-=2000;
                        System.out.println("1000 withdrawn successfully");
                    }
                    else{
                        System.out.println("insufficient balance");

                    }
                }
                break;
                case 3:
                {
                    if(balance>=500){
                        balance-=500;
                        System.out.println("1000 withdrawn successfully");
                    }
                    else{
                        System.out.println("insufficient balance");

                    }
                }
                break;
                default:{
                    System.out.println("invalid option");
                    screen2();
                }
            }
        }

        private void ChangePassword() {
            int newPass;
            newPass = sc.nextInt();
            PIN = newPass;
            System.out.println("Password changed!");
            screen2();

        }

        private void CheckBalance() {
            System.out.println("Current balance: "+getBalance());
            screen2();

        }
        private void setBalance(double x){
            balance = x;
        }

        private void WithdrawMoney() {
            double MoneytoBeWithdrawn;
            MoneytoBeWithdrawn = sc.nextDouble();
            if(MoneytoBeWithdrawn<=getBalance()){
                System.out.println("Insufficient Balance");
            }
            else{
                double newBalance = getBalance() - MoneytoBeWithdrawn;
                setBalance(newBalance);
                System.out.println("Money withdrawn successfully");

            }
            screen2();


        }

        private void DepositMoney() {
            double x;
            x=sc.nextDouble();
            if(x>0) {
                balance += x;
                System.out.println("Money deposited");
            }
            screen2();
        }


    }

    public static void main(String[] args){
        ATM a = new ATM();
        a.startMenu();
    }
}