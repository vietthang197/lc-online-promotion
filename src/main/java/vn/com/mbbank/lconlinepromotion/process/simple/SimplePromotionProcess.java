package vn.com.mbbank.lconlinepromotion.process.simple;

import org.apache.commons.chain.impl.ChainBase;

public class SimplePromotionProcess extends ChainBase {
    public SimplePromotionProcess() {
        addCommand(new CheckReceiptPromotionCommand());
        addCommand(new InsertPromotionHistoryCommand());
        addCommand(new SendPromotionalEmailToCorpCommand());
    }
}
