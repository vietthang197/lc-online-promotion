package vn.com.mbbank.lconlinepromotion.constant;

public interface LcPromotionCommonAttributeId {
    interface ALLOW_MULTIPLE { // cho phép khách hàng nhận nhiều lần cùng một ctkm hay không
        String ID = "ALLOW_MULTIPLE";

        enum VALUES {
            Y, N
        }
    }

    interface USES { // số lần nhận tối đa một ctkm của một kh
        String ID = "USES";
    }
}
