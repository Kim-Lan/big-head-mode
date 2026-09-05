package com.kimlan.bigheadmode;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "big-head-mode")
@Config(name = "big-head-mode", wrapperName = "BigHeadModeConfig")
public class BigHeadModeConfigModel {
    @RangeConstraint(min = 1.0F, max = 10.0F)
    public float headScale = 2.0F;
}
