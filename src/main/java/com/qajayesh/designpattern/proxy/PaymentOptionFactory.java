package com.qajayesh.designpattern.proxy;

import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Map<String, Supplier<PaymentOption>> MAP = Map.of(
            "CC", CreditCard::new,
            "NB", NetBanking::new
    );

    public static PaymentOption get(String opt) {
        return MAP.get(opt).get();
    }
}
