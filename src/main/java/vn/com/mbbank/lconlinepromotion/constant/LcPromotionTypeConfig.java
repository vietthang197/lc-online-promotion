package vn.com.mbbank.lconlinepromotion.constant;

public interface LcPromotionTypeConfig {

    interface CTKM_TYPE_ID_1 {
        String ID = "CTKM_TYPE_ID_1";

        interface CUSTOM_ATTRIBUTE {

        }
    }

    interface CTKM_TYPE_ID_2 {
        String ID = "CTKM_TYPE_ID_2";

        interface CUSTOM_ATTRIBUTE_ID {
            String  MIN_LC_AMOUNT = "MIN_LC_AMOUNT"; // trị giá LC tối thiểu
            String LC_CURRENCY = "LC_CURRENCY"; // đơn vị tiền tệ của trị giá LC
        }
    }
}
