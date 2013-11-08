package com.keto.jangamelo.Rajawali.postprocessing.passes;

import com.keto.jangamelo.R;


public class GreyScalePass extends EffectPass {
	public GreyScalePass()
	{
		super();
		createMaterial(R.raw.minimal_vertex_shader, R.raw.grey_scale_fragment_shader);
	}
}
