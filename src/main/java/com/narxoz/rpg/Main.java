package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.add(new Weapon("Hourglass Blade", 32, 120, 6.5, 18));
        inventory.add(new Potion("Dawn Potion", 8, 35, 0.7, 45));
        inventory.add(new Scroll("Shadow Recall Scroll", 28, 90, 0.2, "Shadow Recall"));
        inventory.add(new Ring("Ring of Greed", 22, 150, 0.1, "Greed and gold sense"));
        inventory.add(new Armor("Chrono Plate", 18, 110, 18.0, 25));

        Hero knight = new Hero("Aldar", 120, 80, 200);
        Hero mage = new Hero("Mira", 75, 140, 90);

        knight.addArtifact(new Potion("Personal Minor Potion", 3, 10, 0.3, 15));
        mage.addArtifact(new Scroll("Spark Note", 5, 20, 0.1, "Spark"));

        List<Hero> heroes = Arrays.asList(knight, mage);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.run(heroes, inventory);

        System.out.println("\n=== Final result ===");
        System.out.println(result);
    }
}
