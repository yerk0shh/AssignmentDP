package com.narxoz.rpg.enemy;

public class BasicEnemy extends AbstractEnemy {

    @Override
    public Enemy clone() {
        BasicEnemy copy = new BasicEnemy();

        copy.name = this.name;
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        for (var ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }
        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }
}