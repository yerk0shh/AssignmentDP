package com.narxoz.rpg.guild;

import java.util.List;

public class Captain extends GuildMember {
    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public List<String> topics() {
        return List.of("recon", "supplies", "healing", "history", "curse");
    }

    public void issueOrder(String payload) {
        getMediator().dispatch("march", this, payload);
    }

    public void declareUrgent(String payload) {
        getMediator().dispatch("urgent", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("Captain " + getName() + " records " + topic + " from " + from.getName() + ": " + payload);
    }
}
