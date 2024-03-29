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
package com.keto.jangamelo.Rajawali.animation;

import com.keto.jangamelo.Rajawali.math.MathUtil;
import com.keto.jangamelo.Rajawali.math.vector.Vector3;
import com.keto.jangamelo.Rajawali.math.vector.Vector3.Axis;

public class RotateAroundAnimation3D extends Animation3D {
	protected Vector3 mCenter;
	protected double mDistance;
	protected Axis mAxis;
	
	public RotateAroundAnimation3D(Vector3 center, Axis axis, double distance) {
		super();
		mCenter = center;
		mDistance = distance;
		mAxis = axis;
	}
	
	@Override
	protected void applyTransformation() {
		double radians = 360f * mInterpolatedTime * MathUtil.PRE_PI_DIV_180;
		
		double cosVal = Math.cos(radians) * mDistance;
		double sinVal = Math.sin(radians) * mDistance;
		
		if(mAxis == Axis.Z) {
			mTransformable3D.setX(mCenter.x + cosVal);
			mTransformable3D.setY(mCenter.y + sinVal);
		} else if(mAxis == Axis.Y) {
			mTransformable3D.setX(mCenter.x + cosVal);
			mTransformable3D.setZ(mCenter.z + sinVal);
		} else if(mAxis == Axis.X) {
			mTransformable3D.setY(mCenter.x + cosVal);
			mTransformable3D.setZ(mCenter.z + sinVal);
		}
	}
}