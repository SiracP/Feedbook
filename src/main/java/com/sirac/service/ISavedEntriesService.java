package com.sirac.service;

import com.sirac.dto.DtoSavedEntries;
import com.sirac.dto.dto_insert_update.DtoSavedEntriesIU;

public interface ISavedEntriesService {

    public DtoSavedEntries saveEntry(DtoSavedEntriesIU dtoSavedEntriesIU);

    public DtoSavedEntries deleteSavedEntry(DtoSavedEntriesIU dtoSavedEntriesIU);
}
