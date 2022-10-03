package uz.pdp;

import uz.pdp.distributor.CheckDistributor;
import uz.pdp.distributor.PayDistributor;
import uz.pdp.distributor.receive.DefaultCheckReceiveDto;
import uz.pdp.distributor.receive.DefaultPayReceiveDto;
import uz.pdp.distributor.receive.PaynetCheckReceiveDto;
import uz.pdp.model.agent.Agent;
import uz.pdp.model.agent.AgentMerchant;
import uz.pdp.model.gateway.Gateway;
import uz.pdp.model.gateway.GatewayMerchant;
import uz.pdp.model.mercahnt.Merchant;
import uz.pdp.service.*;

import java.util.Scanner;

public class Main implements Constants {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    static AgentService agentService = new AgentService(10);
    static GatewayService gatewayService = new GatewayService(10);
    static AgentMerchantService agentMerchantService = new AgentMerchantService(10);
    static GatewayMerchantService gatewayMerchantService = new GatewayMerchantService(10);
    static MerchantService merchantService = new MerchantService(10);
    static CheckDistributor checkDistributor = new CheckDistributor();

    public static void main(String[] args) {
        int var = 10;
        while(var != 0){
            System.out.println(AGENT + " " + MERCHANT + " " + AGENT_MERCHANT + " " + GATEWAY + " " + GATEWAY_MERCHANT + " " + CHECK_TRANSACTION + " " + PAY_TRANSACTION + " " + LIST_TRANSACTION);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    agent();
                }
                case 2 ->{
                    merchant();
                }
                case 3 ->{
                    agentMerchant();
                }
                case 4 ->{
                    gateway();
                }
                case 5 ->{
                     gatewayMerchant();
                }
                case 6 ->{
                    System.out.println("enter num:");
                    checkTransaction(scannerInt.nextInt());
                }
                case 7 ->{
                    payTransaction();
                }
                case 8 ->{
                    PayDistributor.print();
                }
            }
        }

    }

    public static void agent(){
        int var = 10;
        while(var != 0){
            System.out.println(ADD_AGENT + " " + LIST_AGENT + " " + DELETE_AGENT);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    Agent agent = new Agent();
                    System.out.println("enter secret key");
                    agent.setSecretKey(scannerStr.nextLine());
                    System.out.println("enter name");
                    agent.setName(scannerStr.nextLine());
                    System.out.println("enter comission");
                    agent.setCommission(new Scanner(System.in).nextDouble());
                    agentService.add(agent,agentService);
                }
                case 2 ->{
                    for (Agent aget: AgentService.agents) {
                        if (aget != null){
                            System.out.println(aget);
                        }
                    }
                }
            }
        }
    }

    public static void merchant(){
        int var = 10;
        while(var != 0){
            System.out.println(ADD_MERCHANT + " " + LIST_MERCHANT + " " + DELETE_MERCHANT);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    Merchant merchant = new Merchant();
                    System.out.println("enter name");
                    merchant.setName(scannerStr.nextLine());
                    System.out.println("enter min sum");
                    merchant.setMinAmount(new Scanner(System.in).nextBigDecimal());
                    System.out.println("enter max sum");
                    merchant.setMaxAmount(new Scanner(System.in).nextBigDecimal());
                    System.out.println("gateway merchant id");
                    merchant.setGatewayMerchantId(scannerInt.nextInt());
                    merchantService.add(merchant,merchantService);
                }
                case 2 ->{
                    for (Merchant aget: MerchantService.merchants) {
                        if (aget != null){
                            System.out.println(aget.toString());
                        }
                    }
                }
            }
        }
    }

    public static void agentMerchant(){
        int var = 10;
        while(var != 0){
            System.out.println(ADD_AGENT_MERCHANT + " " + LIST_AGENT_MERCHANT + " " + DELETE_AGENT_MERCHANT);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    AgentMerchant agentMerchant = new AgentMerchant();
                    System.out.println("enter name");
                    agentMerchant.setName(scannerStr.nextLine());

                    System.out.println("agent id");
                    agentMerchant.setAgentId(scannerInt.nextInt());

                    System.out.println("merchant id");
                    agentMerchant.setMerchantId(scannerInt.nextInt());

                    agentMerchantService.add(agentMerchant,agentMerchantService);
                }
                case 2 ->{
                    for (AgentMerchant agentMerchant: AgentMerchantService.agentMerchants) {
                        if (agentMerchant != null){
                            System.out.println(agentMerchant.toString());
                        }
                    }
                }
            }
        }
    }

    public static void gateway(){
        int var = 10;
        while(var != 0){
            System.out.println(ADD_GATEWAY + " " + LIST_GATEWAY + " " + DELETE_GATEWAY);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    Gateway gateway = new Gateway();
                    System.out.println("enter name");
                    gateway.setName(scannerStr.nextLine());
                    gatewayService.add(gateway,gatewayService);
                }
                case 2 ->{
                    for (Gateway agentMerchant: GatewayService.gateways) {
                        if (agentMerchant != null){
                            System.out.println(agentMerchant.toString());
                        }
                    }
                }
            }
        }
    }

    public static void gatewayMerchant(){
        int var = 10;
        while(var != 0){
            System.out.println(ADD_GATEWAY_MERCHANT + " " + LIST_GATEWAY_MERCHANT + " " + DELETE_GATEWAY_MERCHANT);
            var = scannerInt.nextInt();
            switch (var){
                case 1 ->{
                    GatewayMerchant gatewayMerchant = new GatewayMerchant();
                    System.out.println("enter name");
                    gatewayMerchant.setName(scannerStr.nextLine());
                    System.out.println("gateway id");
                    gatewayMerchant.setGatewayId(scannerInt.nextInt());
                    gatewayMerchantService.add(gatewayMerchant,gatewayService);
                }
                case 2 ->{
                    for (GatewayMerchant gatewayMerchant: GatewayMerchantService.gatewayMerchants) {
                        if (gatewayMerchant != null){
                            System.out.println(gatewayMerchant);
                        }
                    }
                }
            }
        }
    }

    public static void checkTransaction(int i){
        if (i == 1){
            DefaultCheckReceiveDto defaultCheckReceiveDto
                    = new DefaultCheckReceiveDto();

            System.out.println("secret key");
            defaultCheckReceiveDto.setSecretKey(scannerStr.nextLine());

            System.out.println("merchant id ozimizniki");
            defaultCheckReceiveDto.setMerchantId(scannerInt.nextInt());

            System.out.println("account");
            defaultCheckReceiveDto.setTransactionAccount(scannerStr.nextLine());

            System.out.println("amount");
            defaultCheckReceiveDto.setTransactionAmount(new Scanner(System.in).nextBigDecimal());
            System.out.println(checkDistributor.check(defaultCheckReceiveDto, merchantService, gatewayMerchantService, gatewayService));
        }else {
            PaynetCheckReceiveDto paynetCheckReceiveDto
                    = new PaynetCheckReceiveDto();

            System.out.println("name");
            paynetCheckReceiveDto.setName(scannerStr.nextLine());

            System.out.println("sum");
            paynetCheckReceiveDto.setPaynetSum(new Scanner(System.in).nextBigDecimal());

            System.out.println("account");
            paynetCheckReceiveDto.setTransactionAccount(scannerStr.nextLine());

            System.out.println("token");
            paynetCheckReceiveDto.setToken(scannerStr.nextLine());

            System.out.println("merchant id ozimizniki");
            paynetCheckReceiveDto.setPaynetAgentMerchantId(scannerInt.nextInt());

            System.out.println(checkDistributor.check(paynetCheckReceiveDto, merchantService, gatewayMerchantService, gatewayService));
        }
    }

    public static void payTransaction(){
        DefaultPayReceiveDto defaultPayReceiveDto
                = new DefaultPayReceiveDto();

        System.out.println("secret key");
        defaultPayReceiveDto.setAgent(scannerStr.nextLine());

        System.out.println("transaction id: ");
        defaultPayReceiveDto.setTransactionId(scannerInt.nextLong());

        System.out.println(new PayDistributor().pay(
                defaultPayReceiveDto,
                merchantService,
                gatewayMerchantService,
                gatewayService,
                agentService
        ));
    }

}
