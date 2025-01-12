package com.sirac.controller;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.dto_insert_update.DtoEntryIU;

public interface IRestEntryController {

    public RootEntity<DtoEntry> saveEntry(DtoEntryIU dtoEntryIU);
}
