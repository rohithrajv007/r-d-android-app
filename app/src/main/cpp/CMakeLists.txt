# Sets the minimum version of CMake required
cmake_minimum_required(VERSION 3.18.1)

# Declares a project
project("rndcameraapp")

# Adds our C++ code as a shared library
# 'native-lib' is the name we'll use in Java
add_library(
        native-lib
        SHARED
        native-lib.cpp) # This is our C++ source file

# Finds the Android logging library (optional but good practice)
find_library(
        log-lib
        log)

# Links the logging library to our library
target_link_libraries(
        native-lib
        ${log-lib})