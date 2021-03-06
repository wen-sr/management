package com.management.service.prd1;

import com.management.common.ServerResponse;
import com.management.vo.prd1.DeliveryVo;
import com.management.vo.prd1.LogisticsQueryVo;
import com.management.vo.prd1.ReceiptVo;

public interface ILogisticsQueryService {
    ServerResponse bookShipQuery(LogisticsQueryVo logisticsQueryVo);

    ServerResponse receiptQuery(ReceiptVo receiptVo);

    ServerResponse registerDetail(ReceiptVo receiptVo);

    ServerResponse differenceDetail(ReceiptVo receiptVo);

    ServerResponse rejectDetail(ReceiptVo receiptVo);

    ServerResponse deliveryQuery(DeliveryVo deliveryVo);

    ServerResponse orderCaseQuery(DeliveryVo deliveryVo);

    ServerResponse caseidQuery(DeliveryVo deliveryVo);

    ServerResponse caseSkuDetail(DeliveryVo deliveryVo);

    Integer ReceiptQty();

    ServerResponse getZhuPeiGouBao(String doc_number);
}
