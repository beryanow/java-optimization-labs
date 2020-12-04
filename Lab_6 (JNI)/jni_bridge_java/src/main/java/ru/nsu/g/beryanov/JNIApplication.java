package ru.nsu.g.beryanov;

class CPUInfo {
    native void show();
}

public class JNIApplication {
    static {
        System.load("/Users/beryanow/IdeaProjects/lab_6/cpuinfo.dylib");
    }
    public static void main(String[] args) {
        CPUInfo CPUInfo = new CPUInfo();
        CPUInfo.show();
    }
}
