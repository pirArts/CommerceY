package com.baymax.baymax.dao;

import com.baymax.baymax.model.PaymentType;

public interface PaymentTypeDAO{
    PaymentType getPaymentType(long paymentTypeId);
    PaymentType getPaymentTypeByName(String name);

    void insertPaymentType(PaymentType paymentType);
    void deletePaymentType(PaymentType paymentType);
}