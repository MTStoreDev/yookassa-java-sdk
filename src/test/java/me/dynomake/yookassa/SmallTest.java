package me.dynomake.yookassa;

import com.google.gson.JsonObject;
import me.dynomake.yookassa.exception.BadRequestException;
import me.dynomake.yookassa.exception.UnspecifiedShopInformation;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SmallTest {

    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) throws UnspecifiedShopInformation, BadRequestException, IOException {
        Yookassa yookassa = Yookassa.initialize(1, "");

        // запросим платеж с банковской карты и сохраним её)))

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("somedata", "Some data");

        Payment payment = yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "RUB"), "Test Payment", "https://suuft.naifu.works", jsonObject);
        System.out.println(payment);
        System.out.println(payment.metadata);
        System.out.println(payment.confirmation);

    }
}
