package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.List;

public class RaidGroup implements CombatNode {

    private List<CombatNode> groups = new ArrayList<>();

    public void add(CombatNode node){
        groups.add(node);
    }

    @Override
    public int getAttackPower() {

        int total = 0;

        for(CombatNode node : groups){
            if(node.isAlive()){
                total += node.getAttackPower();
            }
        }

        return total;
    }

    @Override
    public void takeDamage(int amount) {

        int alive = 0;

        for(CombatNode node : groups){
            if(node.isAlive()){
                alive++;
            }
        }

        if(alive == 0) return;

        int splitDamage = amount / alive;

        for(CombatNode node : groups){
            if(node.isAlive()){
                node.takeDamage(splitDamage);
            }
        }
    }

    @Override
    public boolean isAlive() {

        for(CombatNode node : groups){
            if(node.isAlive()){
                return true;
            }
        }

        return false;
    }

    @Override
    public void printTree(String indent) {

        System.out.println(indent + "RaidGroup:");

        for(CombatNode node : groups){
            node.printTree(indent + "  ");
        }
    }
}