package com.pression.compressed_chemistry.mixin;

import com.smashingmods.chemlib.api.Chemical;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Chemical.class)
public interface ChemicalColorMixin {

    /**
     * @author Big Barza
     * @reason The original implementation does a bitwise OR to "clamp" values, which can heavily distort the intended colors.
     * For example, gold turns green-ish since 0x40 is added to the green and blue components.
     */
    @Overwrite(remap = false)
    default int clampMinColorValue(int pColor, int minValue){
        int red = pColor >> 16 & 0xFF;
        int green = pColor >> 8 & 0xFF;
        int blue = pColor & 0xFF;
        red = Math.max(red, minValue);
        green = Math.max(green, minValue);
        blue = Math.max(blue, minValue);
        return red << 16 | green << 8 | blue;
    }
}
