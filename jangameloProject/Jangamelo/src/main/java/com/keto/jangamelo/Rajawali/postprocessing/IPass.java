package com.keto.jangamelo.Rajawali.postprocessing;

import com.keto.jangamelo.Rajawali.materials.Material;
import com.keto.jangamelo.Rajawali.primitives.ScreenQuad;
import com.keto.jangamelo.Rajawali.renderer.RajawaliRenderer;
import com.keto.jangamelo.Rajawali.renderer.RenderTarget;
import com.keto.jangamelo.Rajawali.scene.RajawaliScene;


public interface IPass extends IPostProcessingComponent {
	public static enum PassType {
		RENDER, EFFECT, MASK, CLEAR
	};
	
	boolean isClear();
	boolean needsSwap();
	void render(RajawaliScene scene, RajawaliRenderer renderer, ScreenQuad screenQuad, RenderTarget writeTarget, RenderTarget readTarget, double deltaTime);
	PassType getPassType();
	IPostProcessingEffect getParent();
	void setMaterial(Material material);
}
