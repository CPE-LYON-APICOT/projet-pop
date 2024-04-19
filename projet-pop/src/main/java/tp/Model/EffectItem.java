package tp.Model;

import tp.ATRIER.SpecialEffects;

public abstract class EffectItem extends Item {

    public EffectItem(Integer x, Integer y) {
        super(x, y);
    }

    public SpecialEffects getEffect() {
        return SpecialEffects.EFFET1;
    }

}

// Enum, switch avec la variable qui contient l'effet souhaité : Appel du
// décorateur
