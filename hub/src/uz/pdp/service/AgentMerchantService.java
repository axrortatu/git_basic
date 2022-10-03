package uz.pdp.service;

import uz.pdp.model.agent.Agent;
import uz.pdp.model.agent.AgentMerchant;
import uz.pdp.service.base.BaseService;

public class AgentMerchantService implements BaseService {

    public static AgentMerchant[] agentMerchants;
    private static int index = 0;

    public AgentMerchantService(int size){
        agentMerchants = new AgentMerchant[size];
    }

    @Override
    public boolean add(Object o, Object objService) {
        AgentMerchant agentMerchant = (AgentMerchant) o;
        Agent agent = (Agent) new AgentService().getById(agentMerchant.getAgentId()); // agentni tekshiramiz
        if (agent == null) {
            return false;
        }

        agentMerchants[index ++] = agentMerchant;
        return true;
    }


    @Override
    public Object getById(final int agentId) {
        int cnt = 0;

        for (AgentMerchant agentMerchant: agentMerchants) {
            if (agentMerchant != null){
                if (agentMerchant.getAgentId() == agentId){
                    cnt ++;
                }
            }
        }
        final AgentMerchant[] agentMerchantList = new AgentMerchant[cnt];
        cnt = 0;
        for (AgentMerchant agentMerchant: agentMerchants) {
            if (agentMerchant != null){
                if (agentMerchant.getAgentId() == agentId){
                    agentMerchantList[cnt ++] = agentMerchant;
                }
            }
        }
        return agentMerchantList;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
