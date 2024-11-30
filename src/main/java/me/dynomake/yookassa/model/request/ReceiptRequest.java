package me.dynomake.yookassa.model.request;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Amount;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ReceiptRequest {
    CustomerType customer;
    Set<ItemType> items;
    @Deprecated
    String phone;
    @Deprecated
    String email;
    Integer tax_system_code;
    Set<ReceiptIndustryDetails> receipt_industry_details;
    Set<ReceiptOperationalDetails> receipt_operational_details;

    @Data
    @FieldDefaults(level = AccessLevel.PUBLIC)
    public static class CustomerType {
        String full_name;
        String inn;
        String email;
        String phone;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PUBLIC)
    public static class ItemType {
        String description;
        Amount amount;
        Integer vat_code;
        Integer quantity;
        String measure;
        MarkQuantity mark_quantity;
        String payment_subject;
        String payment_mode;
        String country_of_origin_code;
        String customs_declaration_number;
        String excise;
        String product_code;
        String mark_code_info;

        @RequiredArgsConstructor
        @FieldDefaults(level = AccessLevel.PUBLIC)
        public static class MarkQuantity {
            Integer numerator;
            Integer denominator;
        }

        @RequiredArgsConstructor
        @FieldDefaults(level = AccessLevel.PUBLIC)
        public static class MarkCodeInfo {
            String mark_code_raw;
            String unknown;
            String ean_8;
            String ean_13;
            String itf_14;
            String gs_10;
            String gs_1m;
            @SerializedName("short")
            String shortCode;
            String fur;
            String egais_20;
            String egais_30;
        }
    }

    @Data
    @FieldDefaults(level = AccessLevel.PUBLIC)
    public static class ReceiptIndustryDetails {
        String federal_id;
        String document_date;
        String document_number;
        String value;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PUBLIC)
    public static class ReceiptOperationalDetails {
        String operation_id;
        String value;
        String created_at;
    }
}
