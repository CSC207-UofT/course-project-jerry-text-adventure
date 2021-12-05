package usecase;

import entity.Pokemon;

public class BattleActionWhenAttacked implements BattleAction {
    private BattleManager battleManager;
    private Pokemon p1;
    private Pokemon p2;
    private boolean hasCounterattackP1;
    private boolean hasCounterattackP2;
    private IBattlePresenter presenter;

    public BattleActionWhenAttacked(BattleManager battleManager) {
        this.battleManager = battleManager;
        this.p1 = battleManager.getP1();
        this.p2 = battleManager.getP2();
        this.hasCounterattackP1 = battleManager.isHasCounterattackP1();
        this.hasCounterattackP2 = battleManager.isHasCounterattackP2();
        this.presenter = battleManager.getPresenter();
    }

    @Override
    public void attack() {
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP1);
        int damageByP1 = damageCalculator.calculate(p1.getAttackPoint(), p2.getDefencePoint());
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2);
        p2.setHitPoint(p2.getHitPoint() - damageByP1);
        battleManager.setHasCounterattackP1(false);
        battleManager.setHasCounterattackP2(false);
        presenter.printAttack(p1.getName(), p2.getName(), damageByP1);
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    @Override
    public void defense() {
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        damageCalculator.setHasDefense(true);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2);
        battleManager.setHasCounterattackP1(true);
        battleManager.setHasCounterattackP2(false);
        presenter.printDefense(p1.getName());
        presenter.printDefenseSucceed(p1.getName());
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    @Override
    public void heal() {
        DamageCalculator damageCalculator = new DamageCalculator();
        HealCalculator healCalculator = new HealCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        int healedPoint = healCalculator.calculate(p1.getMaxHitPoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2 + healedPoint);
        battleManager.setHasCounterattackP2(false);
        presenter.printHeal(p1.getName(), healedPoint);
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    @Override
    public boolean capture() {
        CaptureCalculator captureCalculator = new CaptureCalculator();
        boolean captured = captureCalculator.calculate(p2.getHitPoint(), p2.getMaxHitPoint());
        if (captured) {
            presenter.printCaptured(p2.getName());
        } else {
            DamageCalculator damageCalculator = new DamageCalculator();
            damageCalculator.setHasCounterattack(hasCounterattackP2);
            int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
            p1.setHitPoint(p1.getHitPoint() - damageByP2);
            presenter.printNotCaptured(p2.getName());
            presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
        }
        battleManager.setHasCounterattackP2(false);
        return captured;
    }
}