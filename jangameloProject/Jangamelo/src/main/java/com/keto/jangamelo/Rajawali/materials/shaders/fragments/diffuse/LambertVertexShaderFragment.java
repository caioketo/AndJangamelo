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
package com.keto.jangamelo.Rajawali.materials.shaders.fragments.diffuse;

import com.keto.jangamelo.Rajawali.materials.shaders.AShader;
import com.keto.jangamelo.Rajawali.materials.shaders.IShaderFragment;


public class LambertVertexShaderFragment extends AShader implements IShaderFragment {
	public final static String SHADER_ID = "LAMBERT_VERTEX";

	public LambertVertexShaderFragment() {
		super(ShaderType.VERTEX_SHADER_FRAGMENT);
	}
	
	public String getShaderId() {
		return SHADER_ID;
	}

}
