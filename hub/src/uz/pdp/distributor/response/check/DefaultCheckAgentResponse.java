package uz.pdp.distributor.response.check;

import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;

public class DefaultCheckAgentResponse extends BaseCheckAgentResponse {

    private long merchantId;
    private int status;

    public DefaultCheckAgentResponse() {
    }

    public DefaultCheckAgentResponse(long merchantId, int status) {
        this.merchantId = merchantId;
        this.status = status;
    }

    @Override
    protected BaseCheckAgentResponse success(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        DefaultCheckAgentResponse response = new DefaultCheckAgentResponse(
                merchant.getId(),
                0
        );
        return response;
    }

    @Override
    protected BaseCheckAgentResponse error(Transaction transaction, Merchant merchant, TransactionError transactionError) {
        int statusCode = 0;
        switch (transactionError){
            case CHECK_IS_NOT_SUCCESS -> statusCode = -200;
            case UN_VALID_PARAMETER -> statusCode = -100;
        }
        DefaultCheckAgentResponse response = new DefaultCheckAgentResponse(
                merchant.getId(),
                statusCode
        );
        return response;
    }

    @Override
    public String toString() {
        return "DefaultAgentResponse{" +
                "merchantId=" + merchantId +
                ", status=" + status +
                '}';
    }
}
