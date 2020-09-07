package com.qajayesh.designpattern.strategy;

import java.util.Map;

public interface PaymentOption {

    void enterPaymentInformation(Map<String, String> paymentDetails);

}
