package com.qajayesh.designpattern.strategy.practice;

import java.util.Map;
import java.util.function.Supplier;

public class SearchOptionFactory {

    private static final Map<String, Supplier<SearchOption>> MAP = Map.of(
            "Return", ReturnTravel::new,
            "Oneway", OneWayTravel::new,
            "AdvSearch", AdvanceSearch::new
    );

    public static SearchOption get(String opt) {
        return MAP.get(opt).get();
    }
}
