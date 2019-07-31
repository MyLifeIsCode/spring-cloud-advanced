package com.myself.config;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class GlobalRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object o) {
        List<Server> servers = iLoadBalancer.getAllServers();
        Random random = new Random();
        random.nextInt(servers.size());
        int i = random.nextInt(servers.size());
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.iLoadBalancer;
    }

}