/**
 * Copyright 2013 Dennis Ippel
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.keto.jangamelo.Rajawali.postprocessing;

import com.keto.jangamelo.Rajawali.materials.Material;
import com.keto.jangamelo.Rajawali.materials.MaterialManager;
import com.keto.jangamelo.Rajawali.primitives.ScreenQuad;
import com.keto.jangamelo.Rajawali.renderer.RajawaliRenderer;
import com.keto.jangamelo.Rajawali.renderer.RenderTarget;
import com.keto.jangamelo.Rajawali.scene.RajawaliScene;

/**
 * Defines a rendering pass which is needed for multiple rendering passes.
 * @author Andrew Jo
 * @author dennis.ippel
 */
public abstract class APass implements IPass {
	
	protected boolean mEnabled;
	protected boolean mClear;
	protected boolean mNeedsSwap;
	protected PassType mPassType;
	protected IPostProcessingEffect mParent;
	protected Material mMaterial;
	
	/**
	 * Returns whether this pass is to be rendered. If false, renderer skips this pass.
	 */
	public boolean isEnabled() {
		return mEnabled;
	}
	
	/**
	 * Returns whether the framebuffer should be cleared before rendering this pass.
	 */
	public boolean isClear() {
		return mClear;
	}
	
	/**
	 * Returns whether the write buffer and the read buffer needs to be swapped afterwards.
	 */
	public boolean needsSwap() {
		return mNeedsSwap;
	}
	
	public abstract void render(RajawaliScene scene, RajawaliRenderer renderer, ScreenQuad screenQuad, RenderTarget writeTarget, RenderTarget readTarget, double deltaTime);
	
	public PassType getPassType() {
		return mPassType;
	}
	
	public IPostProcessingEffect getParent() {
		return mParent;
	}
	
	public PostProcessingComponentType getType() {
		return PostProcessingComponentType.PASS;
	}
	
	public void setMaterial(Material material) {
		mMaterial = material;
		MaterialManager.getInstance().addMaterial(material);
	}
}
