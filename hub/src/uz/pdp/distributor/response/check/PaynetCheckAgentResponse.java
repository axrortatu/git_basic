package uz.pdp.distributor.response.check;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public class PaynetCheckAgentResponse extends BaseCheckAgentResponse {
    private long transactionId;
    private boolean isSuccess;

    public PaynetCheckAgentResponse(long transactionId, boolean isSuccess) {
        this.transactionId = transactionId;
        this.isSuccess = isSuccess;
    }

    public PaynetCheckAgentResponse() {
    }

    @Override
    protected BaseCheckAgentResponse success(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        PaynetCheckAgentResponse response = new PaynetCheckAgentResponse(
                transaction.getId(),
                true
        );
        return response;
    }

    @Override
    protected BaseCheckAgentResponse error(Transaction transaction, Merchant merchant,TransactionError transactionError) {
        PaynetCheckAgentResponse response = new PaynetCheckAgentResponse(
                transaction.getId(),
                false
        );
        return response;
    }

    @Override
    public String toString() {
        return "PaynetAgentResponse{" +
                "transactionId=" + transactionId +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
