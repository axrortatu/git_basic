package uz.pdp.distributor.response.pay;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public abstract class BasePayAgentResponse {

    public BasePayAgentResponse response(Transaction transaction, Merchant merchant, TransactionError transactionError){
        if (transactionError.name().equals(TransactionError.SUCCESS.name())){
            return success(transaction,merchant,transactionError);
        }else {
            return error(transaction,merchant,transactionError);
        }
    }

    protected abstract BasePayAgentResponse success(Transaction transaction, Merchant merchant,TransactionError transactionError);
    protected abstract BasePayAgentResponse error(Transaction transaction, Merchant merchant, TransactionError transactionError);
}
