package uz.pdp.service;

import uz.pdp.model.agent.Agent;
import uz.pdp.service.base.BaseService;

public class AgentService implements BaseService {
    public static Agent[] agents;
    private static int index = 0;

    public AgentService(int size) {
        agents = new Agent[size];
    }

    public AgentService() {
    }

    public static Agent getAgent(String secretKey) {
        for (Agent agent : agents) {
            if (agent != null) {
                if (agent.getSecretKey().equals(secretKey)) {
                    return agent;
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o, Object objService) {
        agents[index++] = (Agent) o;

        return true;
    }

    @Override
    public Object getById(int id) {
        for (Agent agent : agents) {
            if (agent != null) {
                if (agent.getId() == id) {
                    return agent;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        int var1 = 0;
        for (Agent agent : agents) {
            if (agent != null) {
                if (agent.getId() == id) {
                    agent.setInActive(true);
                    agents[var1] = agent;
                    return true;
                }
            }
            var1++;
        }
        return false;
    }
}
