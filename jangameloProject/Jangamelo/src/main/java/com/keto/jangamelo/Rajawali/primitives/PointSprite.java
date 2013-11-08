package com.keto.jangamelo.Rajawali.primitives;

import com.keto.jangamelo.Rajawali.Camera;
import com.keto.jangamelo.Rajawali.math.Matrix4;
import com.keto.jangamelo.Rajawali.math.vector.Vector3.Axis;
import com.keto.jangamelo.Rajawali.util.ObjectColorPicker.ColorPickerInfo;


public class PointSprite extends Plane {
	public PointSprite(float width, float height) {
		super(width, height, 1, 1, Axis.Z);
	}
	
	@Override
	public void render(Camera camera, final Matrix4 vpMatrix, final Matrix4 projMatrix, final Matrix4 vMatrix, 
			final Matrix4 parentMatrix, ColorPickerInfo pickerInfo) {
		setLookAt(camera.getPosition());		
		super.render(camera, vpMatrix, projMatrix, vMatrix, parentMatrix, pickerInfo);
	}
}
