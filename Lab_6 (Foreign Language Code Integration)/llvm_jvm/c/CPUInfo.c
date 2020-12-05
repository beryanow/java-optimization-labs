#include <stdio.h>
#include <sys/sysctl.h>

void showCPUInfo() {
    char model_info[1024];
    size_t size = sizeof(model_info);
    if (sysctlbyname("machdep.cpu.brand_string", &model_info, &size, NULL, 0) < 0) {
        perror("sysctl");
    }
    
    int core_count = 0;
    size = sizeof(core_count);
    if (sysctlbyname("machdep.cpu.core_count", &core_count, &size, NULL, 0) < 0) {
        perror("sysctl");
    }
    
    int thread_count = 0;
    size = sizeof(thread_count);
    if (sysctlbyname("machdep.cpu.thread_count", &thread_count, &size, NULL, 0) < 0) {
        perror("sysctl");
    }
    
    printf("%s %d%s %d%s\n", model_info, core_count, "C", thread_count, "T");
}
