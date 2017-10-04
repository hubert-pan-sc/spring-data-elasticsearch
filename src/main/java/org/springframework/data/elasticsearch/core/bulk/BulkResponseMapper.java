package org.springframework.data.elasticsearch.core.bulk;

import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.springframework.data.elasticsearch.core.bulk.impl.BulkResponsePageImpl;
import org.springframework.data.elasticsearch.core.bulk.response.BulkDeleteResponse;
import org.springframework.data.elasticsearch.core.bulk.response.BulkGenericResponse;
import org.springframework.data.elasticsearch.core.bulk.response.BulkGenericResponseInterface;
import org.springframework.data.elasticsearch.core.bulk.response.OpType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BulkResponseMapper {
    public BulkResponsePage<BulkGenericResponseInterface> map(BulkResponse bulkResponse){
        BulkResponsePage bulkResponsePage = new BulkResponsePageImpl();
        List<BulkGenericResponseInterface> bulkGenericResponses = Arrays.stream(bulkResponse.getItems()).map(this::generateSpringDataEsResponse).collect(Collectors.toList());
        bulkResponsePage.setBulkResponseEntries(bulkGenericResponses);
        return bulkResponsePage;

    }

    protected BulkGenericResponse generateSpringDataEsResponse(BulkItemResponse bulkItemResponse){
        BulkGenericResponse bulkResponse = new BulkGenericResponse();
        OpType opType = OpType.valueOf(bulkItemResponse.getOpType().name());

        if(opType.equals(OpType.DELETE)){
            bulkResponse = new BulkDeleteResponse();
        }
        bulkResponse.setActionType(opType);
        bulkResponse.setError(bulkItemResponse.getFailureMessage());
        bulkResponse.setId(bulkItemResponse.getId());
        bulkResponse.setIndex(bulkItemResponse.getIndex());
        bulkResponse.setStatus(bulkItemResponse.status().getStatus());
        bulkResponse.setType(bulkItemResponse.getType());
        bulkResponse.setVersion(String.valueOf(bulkItemResponse.getVersion()));

        return bulkResponse;
    }
}
