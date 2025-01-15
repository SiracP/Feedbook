package com.sirac.service;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.dto_insert_update.DtoEntryIU;

public interface IEntryService {

    public DtoEntry saveEntry(DtoEntryIU dtoEntryIU);

    public DtoEntry deleteEntry(Long entryId);
}
