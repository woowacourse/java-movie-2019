package service;

import org.junit.Assert;
import org.junit.Test;

public class PaymentServiceTest {
    private PaymentService paymentService = new PaymentService();

    @Test
    public void testCalculatePrice() {
        Assert.assertEquals(7600, paymentService.handlePayment(10000, 2000, PaymentType.CREDIT_CARD));
        Assert.assertEquals(7840, paymentService.handlePayment(10000, 2000, PaymentType.CASH));
    }
}
