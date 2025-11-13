// Make sure this package name matches your project
package com.example.rndcameraapp;

import android.opengl.GLSurfaceView; // For our new view
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Load the native library
    static {
        System.loadLibrary("native-lib");
    }

    // Declare the native function
    public native String stringFromJNI();

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glSurfaceView = findViewById(R.id.glSurfaceView);

        // Set up the OpenGL ES 2.0 context
        glSurfaceView.setEGLContextClientVersion(2);

        // Create and set our new renderer
        MainRenderer renderer = new MainRenderer();
        glSurfaceView.setRenderer(renderer);

        // Set the render mode to only draw when there's a change
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        // Call the JNI function to show the "Hello from C++" toast
        String hello = stringFromJNI();
        Toast.makeText(this, hello, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause(); // Pause the OpenGL rendering when app is paused
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume(); // Resume the OpenGL rendering when app resumes
    }
}