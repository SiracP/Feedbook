package com.sirac.controller;

import com.sirac.dto.DtoSavedEntries;
import com.sirac.dto.dto_insert_update.DtoSavedEntriesIU;

public interface IRestSavedEntriesController {

    public RootEntity<DtoSavedEntries> saveEntry(DtoSavedEntriesIU dtoSavedEntriesIU);

    public RootEntity<DtoSavedEntries> deleteSavedEntry(DtoSavedEntriesIU dtoSavedEntriesIU);
}
