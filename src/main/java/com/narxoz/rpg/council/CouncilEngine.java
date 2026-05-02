package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.guild.Healer;
import com.narxoz.rpg.guild.Loremaster;
import com.narxoz.rpg.guild.Quartermaster;
import com.narxoz.rpg.guild.Scout;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.List;

public class CouncilEngine {
    public CouncilRunResult runCouncil(
            List<Hero> heroes,
            QuestLog questLog,
            Quartermaster quartermaster,
            Scout scout,
            Healer healer,
            Captain captain,
            Loremaster loremaster
    ) {
        System.out.println("=== The Adventurers' Guild: War Council ===");

        System.out.println("\nHeroes at the table:");
        for (Hero hero : heroes) {
            System.out.println(hero.describeState());
        }

        System.out.println("\nIterator demo: arrival order");
        printQuests(questLog.ordered());

        System.out.println("\nIterator demo: reverse order");
        printQuests(questLog.reverse());

        System.out.println("\nIterator demo: high priority and above");
        int urgentOrHigh = printQuests(questLog.priorityAtLeast(QuestPriority.HIGH));

        System.out.println("\nIterator open/closed proof: reward sorted");
        printQuests(questLog.rewardSorted());

        System.out.println("\nMediator demo: guild messages");
        captain.issueOrder("Prepare marching plan for the next campaign.");
        scout.reportRecon("Northern road is blocked; eastern pass is safer.");
        quartermaster.requestSupplies("Pack rope, lantern oil, and anti-venom.");
        healer.prepareHealing("Reserve mana tonics for wounded heroes.");
        loremaster.shareHistory("The old ruins were sealed after a failed ritual.");
        loremaster.warnCurse("Carry silver charms near cursed contracts.");
        captain.declareUrgent("Emergency contracts move to the top of the board.");

        return new CouncilRunResult(heroes.size(), questLog.size(), urgentOrHigh, 7);
    }

    private int printQuests(QuestIterator iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            Quest quest = iterator.next();
            System.out.println("Quest: " + quest);
            count++;
        }
        return count;
    }
}
