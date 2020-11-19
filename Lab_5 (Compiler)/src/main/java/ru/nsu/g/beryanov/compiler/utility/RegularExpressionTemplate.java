package ru.nsu.g.beryanov.compiler.utility;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RegularExpressionTemplate {
    @Value(" *new -> [0-9a-z_]+ *= *.+ *")
    private String variableInitializationTemplate;

    @Value(" *[0-9a-z_]+ *=.+ *")
    private String valueAssignmentTemplate;

    @Value(" *if \\(.+\\) *")
    private String ifConditionTemplate;

    @Value(" *for \\(new -> [0-9a-z_]+ *= *.+; *.+ *; *[0-9a-z_]+ *=.+\\) *")
    private String forCycleTemplate;

    @Value(" *while (.+) *")
    private String whileCycleTemplate;

    @Value(" *# +[0-9a-z_]+ *")
    private String labelTemplate;

    @Value("  * goto [0-9a-z_]+ * ")
    private String gotoTemplate;
}
