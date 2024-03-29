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
package com.keto.jangamelo.Rajawali.postprocessing.passes;

import com.keto.jangamelo.Rajawali.Camera;
import com.keto.jangamelo.Rajawali.postprocessing.APass;
import com.keto.jangamelo.Rajawali.primitives.ScreenQuad;
import com.keto.jangamelo.Rajawali.renderer.RajawaliRenderer;
import com.keto.jangamelo.Rajawali.renderer.RenderTarget;
import com.keto.jangamelo.Rajawali.scene.RajawaliScene;
import android.graphics.Color;
import android.opengl.GLES20;

/**
 * A render pass used for primarily rendering a scene to a framebuffer target.
 * @author Andrew Jo (andrewjo@gmail.com)
 * @author dennis.ippel
 */
public class RenderPass extends APass {
	protected RajawaliScene mScene;
	protected Camera mCamera;
	protected Camera mOldCamera;
	protected int mClearColor;
	protected int mOldClearColor;
	
	/**
	 * Instantiates a new RenderPass object.
	 * @param scene RajawaliScene instance to render for this pass
	 * @param clearColor Color of the background to clear before rendering the scene
	 */
	public RenderPass(RajawaliScene scene, Camera camera, int clearColor) {
		mPassType = PassType.RENDER;
		mScene = scene;
		mCamera = camera;
		mClearColor = clearColor;
		mOldClearColor = 0x00000000;
		
		mEnabled = true;
		mClear = true;
		mNeedsSwap = false;
	}
	
	public void render(RajawaliScene scene, RajawaliRenderer renderer, ScreenQuad screenQuad, RenderTarget writeBuffer, RenderTarget readBuffer, double deltaTime) {
		// Set the background color with that of current render pass.
		if (mClearColor != 0x00000000) {
			mOldClearColor = renderer.getCurrentScene().getBackgroundColor();
			GLES20.glClearColor(Color.red(mClearColor)/255f, Color.green(mClearColor)/255f, Color.blue(mClearColor)/255f, Color.alpha(mClearColor)/255f);
		}
		
		// Render the current scene.
		mOldCamera = mScene.getCamera();
		mScene.switchCamera(mCamera);
		mScene.render(deltaTime, readBuffer);
		mScene.switchCamera(mOldCamera);
		
		// Restore the old background color.
		if (mClearColor != 0x00000000) {
			GLES20.glClearColor(Color.red(mOldClearColor)/255f, Color.green(mOldClearColor)/255f, Color.blue(mOldClearColor)/255f, Color.alpha(mOldClearColor)/255f);
		}
	}
}
