package com.narxoz.rpg.facade;

import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.enemy.Enemy;

public class DungeonFacade {

    private PreparationService preparationService;
    private BattleService battleService;
    private RewardService rewardService;

    public DungeonFacade() {
        preparationService = new PreparationService();
        battleService = new BattleService();
        rewardService = new RewardService();
    }

    public AdventureResult runDungeon(Hero hero, Enemy enemy) {

        preparationService.prepareHero(hero);

        boolean heroWon = battleService.startBattle(hero, enemy);

        return rewardService.grantRewards(hero, heroWon);
    }
}
