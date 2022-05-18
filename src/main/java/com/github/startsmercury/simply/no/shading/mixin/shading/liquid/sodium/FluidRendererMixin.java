package com.github.startsmercury.simply.no.shading.mixin.shading.liquid.sodium;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingClientMod;

import me.jellysquid.mods.sodium.client.render.pipeline.FluidRenderer;

@Mixin(FluidRenderer.class)
public class FluidRendererMixin {
	@ModifyVariable(method = "calculateQuadColors(Lme/jellysquid/mods/sodium/client/model/quad/ModelQuadView;Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/core/BlockPos;Lme/jellysquid/mods/sodium/client/model/light/LightPipeline;Lnet/minecraft/core/Direction;FLme/jellysquid/mods/sodium/client/model/quad/blender/ColorSampler;Lnet/minecraft/world/level/material/FluidState;)V",
	                at = @At("HEAD"), argsOnly = true)
	private final float changeShade(final float brightness) {
		return SimplyNoShadingClientMod.getInstance().config.liquidShading.wouldShade() ? brightness : 1.0F;
	}
}
