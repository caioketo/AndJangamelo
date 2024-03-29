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
package com.keto.jangamelo.Rajawali.materials.shaders.fragments.texture;

import java.util.List;

import com.keto.jangamelo.Rajawali.materials.shaders.IShaderFragment;
import com.keto.jangamelo.Rajawali.materials.textures.ATexture;
import com.keto.jangamelo.Rajawali.materials.textures.ATexture.TextureType;


public class EnvironmentMapFragmentShaderFragment extends ATextureFragmentShaderFragment implements IShaderFragment {
	public final static String SHADER_ID = "ENVIRONMENT_MAP_TEXTURE_FRAGMENT";
	
	public EnvironmentMapFragmentShaderFragment(List<ATexture> textures)
	{
		super(textures);
	}
	
	@Override
	public void initialize()
	{
		super.initialize();
	}
	
	@Override
	public void main() {
		super.main();
		RVec4 color = (RVec4) getGlobal(DefaultShaderVar.G_COLOR);
		RVec4 cmColor = new RVec4("cmColor");
		RVec3 eyeDir = (RVec3) getGlobal(DefaultShaderVar.V_EYE_DIR);
		RVec3 normal = (RVec3) getGlobal(DefaultShaderVar.V_NORMAL);
		
		RVec3 reflected = new RVec3("reflected");
		reflected.assign(reflect(eyeDir.xyz(), normal));
		
		int cubeMapCount = 0, sphereMapCount = 0;
		
		for(int i=0; i<mTextures.size(); i++)
		{
			if(mTextures.get(i).getTextureType() == TextureType.SPHERE_MAP)
			{
				reflected.z().assignAdd(1.0f);
				RFloat m = new RFloat("m");
				m.assign(inversesqrt(dot(reflected, reflected)));
				m.assignMultiply(-.5f);
				cmColor.assign(texture2D(muTextures[sphereMapCount++], 
						reflected.xy().multiply(m).add(castVec2(.5f))));
			}
			else if(mTextures.get(i).getTextureType() == TextureType.CUBE_MAP)
			{
				cmColor.assign(textureCube(muCubeTextures[cubeMapCount++], reflected));
			}
			
			cmColor.assignMultiply(muInfluence[i]);
			color.assignAdd(cmColor);
		}
	}
	
	public String getShaderId() {
		return SHADER_ID;
	}
}
