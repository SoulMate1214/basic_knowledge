package cn.xy.service.implement;

import cn.xy.model.Hero;
import cn.xy.service.HeroService;

public class HeroServiceImpl implements HeroService {

    @Override
    public void HpAndMpChange(Hero hero, int number, String remark) throws Exception {
        if (remark.equals("HP")) {
            hero.setHp(hero.getHp() + number);
        } else if (remark.equals("MP")) {
            hero.setMp(hero.getMp() + number);
        } else {
            throw new Exception("remark参数异常，应为'HP'或'MP'");
        }
    }

    @Override
    public void MoveSpeedAndAttackPowerChange(Hero hero, short number, String remark) throws Exception {
        if (remark.equals("AP")) {
            hero.setAttackPower((short) (hero.getAttackPower() + number));
        } else if (remark.equals("MS")) {
            hero.setMoveSpeed((short) (hero.getMoveSpeed() + number));
        } else {
            throw new Exception("remark参数异常，应为'AP'或'MS'");
        }
    }
}
