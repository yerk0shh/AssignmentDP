package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.visitor.CurseDetector;
import com.narxoz.rpg.artifact.visitor.EnchantmentScanner;
import com.narxoz.rpg.artifact.visitor.GoldAppraiser;
import com.narxoz.rpg.artifact.visitor.WeightCalculator;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;

import java.util.List;

public class ChronomancerEngine {
    public VaultRunResult run(List<Hero> heroes, Inventory vaultInventory) {
        System.out.println("=== Chronomancer's Vault ===");

        System.out.println("\nHeroes entering the vault:");
        for (Hero hero : heroes) {
            System.out.println(hero.describeState());
        }

        System.out.println("\nVisitor demo: gold appraisal");
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        vaultInventory.accept(goldAppraiser);

        System.out.println("\nVisitor demo: enchantment scan");
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        vaultInventory.accept(enchantmentScanner);

        System.out.println("\nVisitor demo: curse detection");
        CurseDetector curseDetector = new CurseDetector();
        vaultInventory.accept(curseDetector);

        System.out.println("\nVisitor open/closed proof: weight calculation");
        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);

        Hero target = heroes.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println("\nMemento demo: saving hero before trap");
        System.out.println("Before save: " + target.describeState());
        caretaker.save(target.createMemento());
        System.out.println("Snapshots stored: " + caretaker.size());

        System.out.println("\nVault trap changes hero state");
        target.takeDamage(45);
        target.spendMana(30);
        target.spendGold(60);
        System.out.println("After trap: " + target.describeState());

        System.out.println("\nChronomancer rewinds hero from memento");
        target.restoreFromMemento(caretaker.undo());
        System.out.println("After rewind: " + target.describeState());
        System.out.println("Snapshots stored: " + caretaker.size());

        return new VaultRunResult(
                heroes.size(),
                vaultInventory.size(),
                goldAppraiser.getTotalValue(),
                curseDetector.getCursedCount(),
                weightCalculator.getTotalWeight()
        );
    }
}
