package uz.pdp.distributor;

import uz.pdp.model.transaction.Transaction;

public abstract class BaseDistributor {

    protected static Transaction[] transactions = new Transaction[1000];
    protected static int index = 0;

    protected Transaction getTransaction(long id){
        for (Transaction transaction : transactions) {
            if (transaction != null){
                if (transaction.getId() == id){
                    return transaction;
                }
            }
        }
        return null;
    }

    protected int fake() {
        return (int) (Math.random() * 10);
    }

    public static void print(){
        for (Transaction transaction : transactions) {
            if (transaction != null){
                System.out.println(transaction.getId()
                        + "\t|\t" + transaction.getTransactionAccount()
                        + "\t|\t" + transaction.getTransactionAmount()
                        + "\t|\t" + transaction.getTransactionAmountInCurrency()
                        + "\t|\t" + transaction.getStateId()
                        + "\t|\t" + transaction.getMerchantId()
                        );
            }
        }
    }



}
