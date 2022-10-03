package uz.pdp.distributor.response.pay;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public class DefaultPayAgentResponse extends BasePayAgentResponse{
    private int status;
    private TransactionError transactionError;

    public DefaultPayAgentResponse(int status, TransactionError transactionError) {
        this.status = status;
        this.transactionError = transactionError;
    }

    public DefaultPayAgentResponse() {
    }

    @Override
    protected BasePayAgentResponse success(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        return new DefaultPayAgentResponse(0,transactionError);
    }

    @Override
    protected BasePayAgentResponse error(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        int statusCode = -1;
        switch (transactionError){
            case TRANSACTION_NOT_FOUND -> statusCode = -10;
            case CHECK_IS_NOT_SUCCESS -> statusCode = -200;
        }
        return new DefaultPayAgentResponse(statusCode,transactionError);
    }

    @Override
    public String toString() {
        return "DefaultPayAgentResponse{" +
                "status=" + status +
                ", transactionError=" + transactionError +
                '}';
    }
}
