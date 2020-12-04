# Лабораторная работа №6
### JNI-мост

###### Приложение, выводящее информацию о процессоре, используя нативную функцию, реализованную на языке C++

### Последовательность действий:
1. Переходим в директорию Java приложения.
2. Открываем терминал в текущей директории.
3. Декларируем нативную функцию в JNIApplication.java.
4. Выполняем команду: javac -h bin/ src/main/java/ru/nsu/g/beryanov/JNIApplication.java.
5. Копируем файл bin/ru_nsu_g_beryanov_CPUInfo.h в директорию C++ приложения.
6. Создаём имплементацию нашей нативной функции на языке C++ в файле CPUInfo.cpp.
7. Переходим в директорию C++ приложения.
8. Выполняем команду: g++ -I"/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home/include" -I"/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home/include/darwin" -dynamiclib -o cpuinfo.dylib CPUInfo.cpp.
9. Копируем cpuinfo.dylib в ранее созданную директорию bin/ Java приложения.
10. Переходим в директорию src/main/java.
11. Выполняем команду: java -Djava.library.path=../../ ru/nsu/g/beryanov/JNIApplication.
12. Получаем информацию: Intel(R) Core(TM) i5-5250U CPU @ 1.60GHz 2C 4T.

# Task #5
### JNI-bridge

###### Application that shows CPU info using native function implemented in C++ 


### Actions:
1. Go to Java application home directory.
2. Open terminal in this directory.
3. Declare native function in JNIApplication.java.
4. Proceed with command: javac -h bin/ src/main/java/ru/nsu/g/beryanov/JNIApplication.java.
5. Copy bin/ru_nsu_g_beryanov_CPUInfo.h file into C++ application home directory.
6. Implement the C++ native function in CPUInfo.cpp.
7. Go to C++ application home directory.
8. Proceed with command: g++ -I"/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home/include" -I"/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home/include/darwin" -dynamiclib -o cpuinfo.dylib CPUInfo.cpp.
9. Copy cpuinfo.dylib into the already existing directory /bin in Java application home directory.
10. Go to src/main/java.
11. Proceed with command: java -Djava.library.path=../../ ru/nsu/g/beryanov/JNIApplication.
12. Get info: Intel(R) Core(TM) i5-5250U CPU @ 1.60GHz 2C 4T.

