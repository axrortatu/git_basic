package uz.pdp.distributor;

import uz.pdp.distributor.response.pay.BasePayAgentResponse;
import uz.pdp.distributor.response.pay.DefaultPayAgentResponse;
import uz.pdp.distributor.response.pay.PaynetPayAgentResponse;
import uz.pdp.distributor.receive.DefaultPayReceiveDto;
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

public class PayDistributor extends BaseDistributor{

    public BasePayAgentResponse pay(
            DefaultPayReceiveDto defaultPayCheckReceiveDto,
            MerchantService merchantService,
            GatewayMerchantService gatewayMerchantService,
            GatewayService gatewayService,
            AgentService agentService
    ){

        BasePayAgentResponse basePayAgentResponse = null;

        Transaction transaction = getTransaction(defaultPayCheckReceiveDto.getTransactionId());
        TransactionError transactionError = null;
        Agent agent = agentService.getAgent(defaultPayCheckReceiveDto.getAgent());

        if (transaction == null){
            transactionError = TransactionError.TRANSACTION_NOT_FOUND;
        }
        else if (transaction.getStateId() != TransactionState.CHECK.getStateId()){
            transactionError = TransactionError.CHECK_IS_NOT_SUCCESS;
        }

        Merchant merchant = null;
        if (transactionError == null){
            transaction.setStateId(TransactionState.PAYING.getStateId());

            merchant = (Merchant) merchantService.getById(transaction.getMerchantId());
            GatewayMerchant gatewayMerchant = (GatewayMerchant) gatewayMerchantService.getGatewayMerchant(merchant.getGatewayMerchantId());
            Gateway gateway = (Gateway) gatewayService.getById(gatewayMerchant.getGatewayId());

            if (gateway.isPaynet()){
                if (fake() > 4){
                    transactionError = TransactionError.PAY_IS_NOT_SUCCESS;
                    transaction.setStateId(TransactionState.PAY_ERROR.getStateId());
                }else {
                    transactionError = TransactionError.SUCCESS;
                    transaction.setStateId(TransactionState.SUCCESS.getStateId());
                }
            }
        }

        if (agent.isPaynet()){
            basePayAgentResponse = new PaynetPayAgentResponse();
        }else {
            basePayAgentResponse = new DefaultPayAgentResponse();
        }
        return basePayAgentResponse.response(transaction,merchant,transactionError);
    }
}
