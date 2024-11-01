package me.dynomake.yookassa.model.request;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Amount;

import java.util.UUID;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class PaymentRequest {

    Amount amount;
    ConfirmationType confirmation;
    boolean capture;
    String description;
    PaymentMethodData payment_method_data;
    JsonElement metadata;
    boolean save_payment_method;
    UUID payment_method_id;

    public static PaymentRequest create(Amount amount, String urlRedirect, String description) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, null, new JsonObject(),false, null);
    }

    public static PaymentRequest create(Amount amount, String urlRedirect, String description, JsonElement metadata) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, null, metadata,false, null);
    }

    public static PaymentRequest create(Amount amount, String urlRedirect, String description, String paymentMethod, boolean save) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, new PaymentMethodData(paymentMethod), new JsonObject(), save, null);
    }

    public static PaymentRequest create(Amount amount, String urlRedirect, String description, String paymentMethod, JsonElement metadata, boolean save) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, new PaymentMethodData(paymentMethod), metadata, save, null);
    }

    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
    private static class PaymentMethodData {
        String type;
    }

    @FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
    private static class ConfirmationType {
        String type = "redirect";
        String return_url;

        public ConfirmationType(String url) {
            this.return_url = url;
        }
    }
}
