# Android OpenCV/OpenGL R&D Intern Assessment

This project is a technical assessment to build an Android application that captures the camera feed, processes it in real-time using OpenCV in C++, and renders the output using OpenGL ES.

## 🚧 Project Status (In Progress)

We are currently in the middle of development.

* [✅] **Phase 1: Camera Feed Integration:** Basic camera setup and display on a `TextureView` (now replaced).
* [✅] **Phase 2: JNI Bridge:** Successful connection between Java and C++ confirmed with a "Hello World" toast message.
* [✅] **Phase 3: OpenGL ES Setup:** `GLSurfaceView` and `MainRenderer` classes are configured, displaying a solid blue test screen.
* [✅] **Phase 4: OpenCV C++ Integration:** The OpenCV 4.12 library is fully imported, linked via CMake, and tested. The app now displays a "OpenCV version: 4.12.0" toast, confirming the C++ code can call OpenCV functions.
* [❌] **Phase 5: Full Pipeline:** The next step is to connect all pieces: Camera Feed $\rightarrow$ JNI $\rightarrow$ OpenCV C++ Processing $\rightarrow$ OpenGL ES Texture Rendering.
* [❌] **Phase 6: Web Viewer (TypeScript):** Not yet started.

## ✨ Features Implemented (So Far)

### Android App
* **NDK/JNI Bridge:** A stable JNI bridge is established between `MainActivity.java` and `native-lib.cpp`.
* **OpenGL ES 2.0 Renderer:** The app uses a `GLSurfaceView` and a custom `MainRenderer` class to create an OpenGL drawing environment.
* **OpenCV C++ Integration:** The project has successfully imported and linked the OpenCV 4.12 Android SDK.
* **C++ Test Function:** The `stringFromJNI()` native function calls `cv::getVersionString()` from the OpenCV library and successfully returns the version string to the Java layer to be displayed in a Toast.

## 🏛️ Architecture Explanation

* **View:** The `MainActivity` displays a `GLSurfaceView` which handles the screen rendering.
* **Renderer:** A `MainRenderer.java` class implements the `GLSurfaceView.Renderer` interface to manage OpenGL `onSurfaceCreated`, `onSurfaceChanged`, and `onDrawFrame` events.
* **JNI (Java Native Interface):** `MainActivity.java` loads a native library (`native-lib`). It calls a native function `stringFromJNI()`.
* **C++:** The `native-lib.cpp` file contains the native function, which is linked to the OpenCV libraries via CMake. This is where the C++ processing will happen.

## 🛠️ Setup Instructions

This project requires a specific NDK and OpenCV setup to build.

1.  **NDK (Native Development Kit):**
    * This project is configured to use NDK version **`27.0.12077973`**.
    * You must install this exact version via the Android Studio **SDK Manager** $\rightarrow$ **SDK Tools** $\rightarrow$ **NDK (Side by side)**.

2.  **OpenCV (OpenCV 4.12 Android SDK):**
    * Download the **OpenCV 4.12 Android SDK** from the [OpenCV Releases Page](https://opencv.org/releases/).
    * In Android Studio, import the unzipped `sdk` folder via **File** $\rightarrow$ **New** $\rightarrow$ **Import Module...**.
    * **Rename the module to `sdk`** during import (or refactor it to `sdk` afterward).
    * Open the new `sdk/build.gradle` file and change its `compileSdk` and `targetSdk` to match the `app` module's (e.g., `36`).
    * This project's Gradle files are already configured to link this `sdk` module and build only for ARM architectures (`arm64-v8a`, `armeabi-v7a`).

## 📸 Screenshots

*(Placeholder: A screenshot of the final working app will be added here.)*

Current output is a solid blue screen with a toast message: **"OpenCV version: 4.12.0"**.
