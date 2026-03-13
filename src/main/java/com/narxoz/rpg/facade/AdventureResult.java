package com.narxoz.rpg.facade;

public class AdventureResult {

    private boolean heroWon;
    private int gold;

    public AdventureResult(boolean heroWon, int gold) {
        this.heroWon = heroWon;
        this.gold = gold;
    }

    public boolean isHeroWon() {
        return heroWon;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        return "Adventure Result -> Hero Won: " + heroWon + ", Gold Earned: " + gold;
    }
}
