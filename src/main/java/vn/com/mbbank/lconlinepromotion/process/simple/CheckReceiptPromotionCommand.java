package vn.com.mbbank.lconlinepromotion.process.simple;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import vn.com.mbbank.lconlinepromotion.process.PromotionContext;

public class CheckReceiptPromotionCommand implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        PromotionContext simpleContext = (PromotionContext) context;
        // checking xem da nhan khuyen mai chua

        // neu da nhan khuyen mai roi thi thoi
        return false;
    }
}
