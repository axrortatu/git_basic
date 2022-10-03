package uz.pdp.distributor.response.check;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public abstract class BaseCheckAgentResponse {

    public BaseCheckAgentResponse response(Transaction transaction, Merchant merchant, TransactionError transactionError){
        if (transactionError.name().equals(TransactionError.SUCCESS.name())){
            return success(transaction,merchant,transactionError);
        }else {
            return error(transaction,merchant,transactionError);
        }
    }

    protected abstract BaseCheckAgentResponse success(Transaction transaction, Merchant merchant,TransactionError transactionError);
    protected abstract BaseCheckAgentResponse error(Transaction transaction, Merchant merchant, TransactionError transactionError);
}
