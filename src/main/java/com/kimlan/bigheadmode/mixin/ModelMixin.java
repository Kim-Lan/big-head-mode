package com.kimlan.bigheadmode.mixin;

import static com.kimlan.bigheadmode.BigHeadMode.CONFIG;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.player.PlayerModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Model.class)
abstract class ModelMixin<S> {
	@Inject(method = "renderToBuffer", at = @At("HEAD"))
	private  void injectRenderToBuffer(PoseStack poseStack, VertexConsumer buffer, int lightCoords, int overlayCoords, int color, CallbackInfo ci) {
		if (((Object) this) instanceof PlayerModel) {
			poseStack.pushPose();
			float headScale = CONFIG.headScale();
			poseStack.scale(headScale, headScale, headScale);
			((PlayerModel) (Object) this).getHead().render(poseStack, buffer, lightCoords, overlayCoords);
			poseStack.popPose();
		}
	}
}