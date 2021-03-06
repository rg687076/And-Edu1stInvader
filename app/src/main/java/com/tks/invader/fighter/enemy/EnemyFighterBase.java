package com.tks.invader.fighter.enemy;

import com.tks.invader.R;
import com.tks.invader.bullet.BulletBase;
import com.tks.invader.fighter.FighterBase;
import com.tks.invader.scene.GameSceneBase;

public abstract class EnemyFighterBase extends FighterBase {

    /**
        * 生成されてからのフレームを記録する。
        */
    protected int frameCount = 0;

    public EnemyFighterBase(GameSceneBase scene) {
        super(scene);
    }

    /**
     * フレーム数のカウンタを0に戻す。
     */
    protected void resetFrameCount() {
        frameCount = 0;
    }

    @Override
    public void onDamage(BulletBase bullet) {
        super.onDamage(bullet);

        // ダメージを受けた結果、撃墜されたら、撃墜音を鳴らす
        if (isDead()) {
            scene.playSE(R.raw.dead);
        }
    }

    @Override
    public void update() {
        ++frameCount;
    }

    @Override
    public void draw() {
        // 撃墜されている場合は描画を行わない
        if (isDead()) {
            return;
        }
        super.draw();
    }
}