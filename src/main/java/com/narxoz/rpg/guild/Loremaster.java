package com.narxoz.rpg.guild;

import java.util.List;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public List<String> topics() {
        return List.of("history", "curse", "recon");
    }

    public void shareHistory(String payload) {
        getMediator().dispatch("history", this, payload);
    }

    public void warnCurse(String payload) {
        getMediator().dispatch("curse", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("Loremaster " + getName() + " interprets " + topic + " from " + from.getName() + ": " + payload);
    }
}
