package uz.pdp.distributor.response.pay;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public class PaynetPayAgentResponse extends BasePayAgentResponse{

    private boolean isSuccess;
    private TransactionError transactionError;


    public PaynetPayAgentResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public PaynetPayAgentResponse() {
    }

    public PaynetPayAgentResponse(boolean isSuccess, TransactionError transactionError) {
        this.isSuccess = isSuccess;
        this.transactionError = transactionError;
    }

    @Override
    protected BasePayAgentResponse success(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        return new PaynetPayAgentResponse(true, transactionError);
    }

    @Override
    protected BasePayAgentResponse error(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        return new PaynetPayAgentResponse(true, transactionError);
    }

    @Override
    public String toString() {
        return "PaynetPayAgentResponse{" +
                "isSuccess=" + isSuccess +
                ", transactionError=" + transactionError +
                '}';
    }
}
