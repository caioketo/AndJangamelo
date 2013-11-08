package com.keto.jangamelo;

import android.content.Context;

import com.keto.jangamelo.Rajawali.lights.DirectionalLight;
import com.keto.jangamelo.Rajawali.materials.Material;
import com.keto.jangamelo.Rajawali.materials.textures.ATexture;
import com.keto.jangamelo.Rajawali.materials.textures.Texture;
import com.keto.jangamelo.Rajawali.primitives.Sphere;
import com.keto.jangamelo.Rajawali.renderer.RajawaliRenderer;

import javax.microedition.khronos.opengles.GL10;


public class GLRenderer extends RajawaliRenderer {

    private DirectionalLight mLight;
    private Sphere mSphere;

    public GLRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    public void initScene() {
        mLight = new DirectionalLight(1f, 0.2f, -1.0f); // set the direction
        mLight.setColor(1.0f, 1.0f, 1.0f);
        mLight.setPower(2);
        try {
            Material material = new Material();
            material.addTexture(new Texture("teste", R.drawable.earthtruecolor_nasa_big));
            mSphere = new Sphere(1, 24, 24);
            mSphere.setMaterial(material);
            getCurrentScene().addLight(mLight);
            addChild(mSphere); //Queue an addition task for mSphere
            getCurrentCamera().setZ(4.2f);
        } catch (ATexture.TextureException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        super.onDrawFrame(glUnused);
        mSphere.setRotY(mSphere.getRotY() + 1);
    }
}