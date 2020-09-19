# Лабораторная работа №1.
### Разбор пула констант в байт коде.

###### Spring Boot приложение, декомпозирующее .class файлы (байт код) и извлекающее из них подробную информацию о пуле констант. 

### Реализованы следующие константы:
* UTF8 = 0x1;
* INTEGER = 0x3;
* FLOAT = 0x4;
* LONG = 0x5;
* DOUBLE = 0x6;
* CLASS = 0x7;
* STRING = 0x8;
* FIELD_REFERENCE = 0x9;
* METHOD_REFERENCE = 0xA;
* INTERFACE_METHOD_REFERENCE = 0xB;
* NAME_AND_TYPE = 0xC;
* METHOD_HANDLE = 0xF;
* METHOD_TYPE = 0x10;
* DYNAMIC = 0x11;
* INVOKE_DYNAMIC = 0x12;
* MODULE = 0x13;
* PACKAGE = 0x14;

### Пример декомпозиции (версия байт кода - 52.0)
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_1%20(Constant%20Pool%20Hand%20Revealing)/screenshots/Hello%20World%20Class%20Analysis.png?raw=true "версия 52.0")

### Пример декомпозиции (версия байт кода - 58.0
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_1%20(Constant%20Pool%20Hand%20Revealing)/screenshots/Constant%20Class%20Analysis.png?raw=true "версия 58.0")

# Task #1.
### Byte code constant pool hand revealing.

###### Spring Boot application which disassembles .class files (byte code) and retrieves detailed constant pool information. 

### Disassembling example (byte code version - 52.0)
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_1%20(Constant%20Pool%20Hand%20Revealing)/screenshots/Hello%20World%20Class%20Analysis.png?raw=true "52.0 version")

### Disassembling example (byte code version - 58.0)
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_1%20(Constant%20Pool%20Hand%20Revealing)/screenshots/Constant%20Class%20Analysis.png?raw=true "58.0 version")
