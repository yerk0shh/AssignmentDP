package com.narxoz.rpg.guild;

import java.util.List;

public class Scout extends GuildMember {
    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public List<String> topics() {
        return List.of("recon", "march", "urgent", "history");
    }

    public void reportRecon(String payload) {
        getMediator().dispatch("recon", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("Scout " + getName() + " updates route from " + from.getName() + ": " + payload);
    }
}
