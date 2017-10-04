package org.springframework.data.elasticsearch.core.bulk.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.bulk.BulkResponsePage;
import org.springframework.data.elasticsearch.core.bulk.response.BulkGenericResponse;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class BulkResponsePageImpl<T extends BulkGenericResponse> implements BulkResponsePage<T>{
    private boolean error = false;
    private List<T> bulkResponseEntries;
    private int took;

    public void setBulkResponseEntries(List<T> bulkResponseEntries){
        this.bulkResponseEntries = bulkResponseEntries;
    }

    @Override
    public boolean hasError() {
        return error;
    }

    @Override
    public int getTook() {
        return took;
    }

    @Override
    public int getTotalPages() {
        return 1;
    }

    @Override
    public long getTotalElements() {
        return bulkResponseEntries.size();
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return bulkResponseEntries.size();
    }

    @Override
    public int getNumberOfElements() {
        return bulkResponseEntries.size();
    }

    @Override
    public List<T> getContent() {
        return bulkResponseEntries;
    }

    @Override
    public boolean hasContent() {
        boolean contentPresent = false;
        if(bulkResponseEntries != null && bulkResponseEntries.size() > 0){
            contentPresent = true;
        }
        return contentPresent;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return true;
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public <U> Page<U> map(Function<? super T, ? extends U> function) {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return bulkResponseEntries.iterator();
    }
}
