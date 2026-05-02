package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {
    private final Map<String, List<GuildMember>> subscribers = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        for (String topic : member.topics()) {
            subscribers.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
        }
        System.out.println("GuildHall registered " + member.getName() + " for " + member.topics());
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        System.out.println("GuildHall routes topic '" + topic + "' from " + from.getName() + ": " + payload);

        List<GuildMember> members = subscribers.getOrDefault(topic, List.of());
        for (GuildMember member : members) {
            if (member != from) {
                member.receive(topic, from, payload);
            }
        }
    }
}
