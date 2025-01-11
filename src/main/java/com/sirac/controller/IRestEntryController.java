package com.sirac.controller;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.dto_insert_update.DtoEntryIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface IRestEntryController {

    public RootEntity<DtoEntry> saveEntry(@Valid @RequestBody DtoEntryIU dtoEntryIU);
}
