package org.springframework.data.elasticsearch.core.bulk;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.bulk.response.BulkGenericResponseInterface;

import java.util.List;

public interface BulkResponsePage<T  extends BulkGenericResponseInterface> extends Page<T> {
    public boolean hasError();
    public int getTook();
    public void setBulkResponseEntries(List<T> bulkResponseEntries);
}
