package com.keto.jangamelo.Rajawali.postprocessing;

import android.opengl.GLES20;

import com.keto.jangamelo.R;
import com.keto.jangamelo.Rajawali.materials.Material;
import com.keto.jangamelo.Rajawali.materials.shaders.FragmentShader;
import com.keto.jangamelo.Rajawali.materials.shaders.VertexShader;
import com.keto.jangamelo.Rajawali.util.RawShaderLoader;


public class CopyEffect extends Material {
	public CopyEffect()
	{
		super();
		mCustomVertexShader = new MinimalVertexShader();
		mCustomFragmentShader = new CopyFragmentShader();
	}
	
	public void setOpacity(float opacity)
	{
		((CopyFragmentShader)mCustomFragmentShader).setOpacity(opacity);
	}
	
	private class MinimalVertexShader extends VertexShader
	{
		public MinimalVertexShader() {
			super();
			initialize();
		}
		
		@Override
		public void initialize()
		{
			mShaderString = RawShaderLoader.fetch(R.raw.minimal_vertex_shader);
		}
	}
	
	private class CopyFragmentShader extends FragmentShader
	{
		private int muOpacityHandle;
		private float mOpacity;
		
		public CopyFragmentShader() {
			super();
			initialize();
		}
		
		@Override
		public void initialize()
		{
			mShaderString = RawShaderLoader.fetch(R.raw.copy_fragment_shader);
		}
		
		@Override
		public void setLocations(final int programHandle)
		{
			super.setLocations(programHandle);
			muOpacityHandle = getUniformLocation(programHandle, "uOpacity");
		}
		
		@Override
		public void applyParams()
		{
			super.applyParams();
			GLES20.glUniform1f(muOpacityHandle, mOpacity);
		}
		
		public void setOpacity(float opacity)
		{
			mOpacity = opacity;
		}
	}
}
