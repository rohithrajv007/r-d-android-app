#include <jni.h>
#include <string>

// This is the C++ function that Java will call
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_rndcameraapp_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}