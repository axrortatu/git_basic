package uz.pdp.distributor;

import uz.pdp.distributor.response.check.BaseCheckAgentResponse;
import uz.pdp.distributor.response.check.DefaultCheckAgentResponse;
import uz.pdp.distributor.response.check.PaynetCheckAgentResponse;
import uz.pdp.distributor.receive.BaseCheckReceiveDto;
import uz.pdp.distributor.receive.DefaultCheckReceiveDto;
import uz.pdp.model.agent.Agent;
import uz.pdp.model.gateway.Gateway;
import uz.pdp.model.gateway.GatewayMerchant;
import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.model.transaction.Transaction;
import uz.pdp.model.transaction.TransactionError;
import uz.pdp.model.transaction.TransactionState;
import uz.pdp.service.AgentService;
import uz.pdp.service.GatewayMerchantService;
import uz.pdp.service.GatewayService;
import uz.pdp.service.MerchantService;

import java.math.BigDecimal;

public class CheckDistributor extends BaseDistributor{

    public BaseCheckAgentResponse check(
            BaseCheckReceiveDto baseCheckReceiveDto,
            MerchantService merchantService,
            GatewayMerchantService gatewayMerchantService,
            GatewayService gatewayService
    ){
        DefaultCheckReceiveDto checkReceiveDto = baseCheckReceiveDto.convert();

        TransactionError transactionError = null;
        Agent agent = AgentService.getAgent(checkReceiveDto.getSecretKey());
        if (agent == null){
            transactionError = TransactionError.AGENT_NOT_FOUND;
        }
        if (transactionError == null) {
            if (!checkReceiveDto.isFull()){
                transactionError = TransactionError.UN_VALID_PARAMETER;
            }
            Transaction transaction = new Transaction(TransactionState.CREATED.getStateId());
            transaction.setTransactionAccount(checkReceiveDto.getTransactionAccount());
            transaction.setTransactionAmount(checkReceiveDto.getTransactionAmount());
            transaction.setTransactionAmountInCurrency(getAmountInCurrency(checkReceiveDto.getTransactionAmount(),agent));
            transaction.setMerchantId(checkReceiveDto.getMerchantId());
            transactions[index++] = transaction;

            if (transactionError == null) {
                // o'zimizni merchantimizni topib oldik
                Merchant merchant = (Merchant) merchantService.getById(checkReceiveDto.getMerchantId());
                // o'zimizni merchantimiz orqali gatewayMerchantni topib oldik
                GatewayMerchant gatewayMerchant = gatewayMerchantService.getGatewayMerchant(merchant.getGatewayMerchantId());
                // gatewayMerchantmiz orqali gatewayni topib oldik
                Gateway gateway = (Gateway) gatewayService.getById(gatewayMerchant.getGatewayId());

                if (gateway.isBeeline()) {
                    if (fake() > 6) {
                        transactionError = TransactionError.CHECK_IS_NOT_SUCCESS;
                        transaction.setStateId(TransactionState.CHECK_ERROR.getStateId());
                    } else {
                        transactionError = TransactionError.SUCCESS;
                        transaction.setStateId(TransactionState.CHECK.getStateId());
                    }
                } else if (gateway.isUcell()) {
                    if (fake() > 6) {
                        transactionError = TransactionError.CHECK_IS_NOT_SUCCESS;
                        transaction.setStateId(TransactionState.CHECK_ERROR.getStateId());
                    } else {
                        transactionError = TransactionError.SUCCESS;
                        transaction.setStateId(TransactionState.CHECK.getStateId());
                    }
                } else if (gateway.isPaynet()) {
                    if (fake() > 6) {
                        transactionError = TransactionError.CHECK_IS_NOT_SUCCESS;
                        transaction.setStateId(TransactionState.CHECK_ERROR.getStateId());
                    } else {
                        transactionError = TransactionError.SUCCESS;
                        transaction.setStateId(TransactionState.CHECK.getStateId());
                    }
                }

                BaseCheckAgentResponse responseClass = null;
                if (agent.isPaynet()) {
                    responseClass = new PaynetCheckAgentResponse();
                } else {
                    responseClass = new DefaultCheckAgentResponse();
                }

                return responseClass.response(transaction, merchant, transactionError);
            }
        }
        return null;
    }

    private BigDecimal getAmountInCurrency( BigDecimal transactionAmount, Agent agent){
        return transactionAmount.subtract(
                transactionAmount.multiply(BigDecimal.valueOf(agent.getCommission()))
        );
    }


}
