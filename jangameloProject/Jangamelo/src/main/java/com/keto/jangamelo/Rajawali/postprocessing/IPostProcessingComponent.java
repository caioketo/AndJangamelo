package com.keto.jangamelo.Rajawali.postprocessing;


public interface IPostProcessingComponent {
	public static enum PostProcessingComponentType {
		PASS, EFFECT
	};
	
	boolean isEnabled();
	PostProcessingComponentType getType();
}
