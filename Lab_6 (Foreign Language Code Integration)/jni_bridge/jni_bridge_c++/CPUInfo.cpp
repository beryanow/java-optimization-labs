#include <iostream>
#include "ru_nsu_g_beryanov_CPUInfo.h"
#include <cstdio>
#include <cstdint>
#include <sys/sysctl.h>

using namespace std;

JNIEXPORT void JNICALL Java_ru_nsu_g_beryanov_CPUInfo_show(JNIEnv *env, jobject thisObj) {
    char model_info[1024];
    size_t size = sizeof(model_info);
    if (sysctlbyname("machdep.cpu.brand_string", &model_info, &size, nullptr, 0) < 0) {
        perror("sysctl");
    }

    uint64_t core_count = 0;
    size = sizeof(core_count);
    if (sysctlbyname("machdep.cpu.core_count", &core_count, &size, nullptr, 0) < 0) {
        perror("sysctl");
    }

    uint64_t thread_count = 0;
    size = sizeof(thread_count);
    if (sysctlbyname("machdep.cpu.thread_count", &thread_count, &size, nullptr, 0) < 0) {
        perror("sysctl");
    }

    std::cout << model_info << " " << core_count << "C " << thread_count << "T" << std::endl;
    return;
}