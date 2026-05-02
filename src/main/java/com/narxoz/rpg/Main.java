package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.guild.GuildHall;
import com.narxoz.rpg.guild.Healer;
import com.narxoz.rpg.guild.Loremaster;
import com.narxoz.rpg.guild.Quartermaster;
import com.narxoz.rpg.guild.Scout;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero warrior = new Hero("Aldar", 130, 45, 210);
        Hero mage = new Hero("Mira", 80, 150, 95);
        List<Hero> heroes = Arrays.asList(warrior, mage);

        QuestLog questLog = new QuestLog();
        questLog.add(new Quest("Clear the Spider Mine", QuestPriority.NORMAL, 120, "Iron Hills"));
        questLog.add(new Quest("Escort the Moon Caravan", QuestPriority.LOW, 80, "Silver Road"));
        questLog.add(new Quest("Break the Bone Shrine Curse", QuestPriority.HIGH, 260, "Old Marsh"));
        questLog.add(new Quest("Defend the Burning Gate", QuestPriority.URGENT, 400, "East Wall"));
        questLog.add(new Quest("Recover the Lost Banner", QuestPriority.NORMAL, 160, "Storm Field"));

        GuildHall guildHall = new GuildHall();

        Quartermaster quartermaster = new Quartermaster("Borin", guildHall);
        Scout scout = new Scout("Nyra", guildHall);
        Healer healer = new Healer("Selene", guildHall);
        Captain captain = new Captain("Darius", guildHall);
        Loremaster loremaster = new Loremaster("Ilyas", guildHall);

        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(
                heroes,
                questLog,
                quartermaster,
                scout,
                healer,
                captain,
                loremaster
        );

        System.out.println("\n=== Final result ===");
        System.out.println(result);
    }
}
