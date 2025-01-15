package com.sirac.controller.impl;

import com.sirac.controller.IRestSavedEntriesController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoSavedEntries;
import com.sirac.dto.dto_insert_update.DtoSavedEntriesIU;
import com.sirac.service.ISavedEntriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/saved-entries")
public class RestSavedEntriesControllerImpl extends RestBaseController implements IRestSavedEntriesController {

    @Autowired
    private ISavedEntriesService savedEntriesService;

    @PostMapping("/save-entry")
    @Override
    public RootEntity<DtoSavedEntries> saveEntry(@Valid @RequestBody DtoSavedEntriesIU dtoSavedEntriesIU) {
        return ok(savedEntriesService.saveEntry(dtoSavedEntriesIU));
    }

    @DeleteMapping("/delete-saved-entry")
    @Override
    public RootEntity<DtoSavedEntries> deleteSavedEntry(@Valid @RequestBody DtoSavedEntriesIU dtoSavedEntriesIU) {
        return ok(savedEntriesService.deleteSavedEntry(dtoSavedEntriesIU));
    }
}
