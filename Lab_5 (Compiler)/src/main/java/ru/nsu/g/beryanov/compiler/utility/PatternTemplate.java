package ru.nsu.g.beryanov.compiler.utility;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PatternTemplate {
    @Value("[0-9]+")
    private String intTemplate;

    @Value(" *\".*\" *")
    private String stringTemplate;
}
