package com.narxoz.rpg.guild;

import java.util.List;

public class Quartermaster extends GuildMember {
    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public List<String> topics() {
        return List.of("supplies", "march", "urgent");
    }

    public void requestSupplies(String payload) {
        getMediator().dispatch("supplies", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("Quartermaster " + getName() + " prepares gear after " + from.getName() + ": " + payload);
    }
}
