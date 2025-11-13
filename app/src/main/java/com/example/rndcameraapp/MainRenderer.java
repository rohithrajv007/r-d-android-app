// Make sure this package name matches your project
package com.example.rndcameraapp;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// This class handles all the OpenGL drawing logic
public class MainRenderer implements GLSurfaceView.Renderer {

    // Called once when the surface is created.
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background clear color to blue.
        GLES20.glClearColor(0.0f, 0.0f, 1.0f, 1.0f); // Blue
    }

    // Called when the surface changes size (e.g., orientation change)
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    // Called to draw a new frame.
    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear the screen with the color we set in onSurfaceCreated()
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}