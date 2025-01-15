package com.sirac.controller.impl;

import com.sirac.controller.IRestEntryController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoEntry;
import com.sirac.dto.dto_insert_update.DtoEntryIU;
import com.sirac.service.IEntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/entry")
public class RestEntryController extends RestBaseController implements IRestEntryController {

    @Autowired
    private IEntryService entryService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoEntry> saveEntry(@Valid @RequestBody DtoEntryIU dtoEntryIU) {
        return ok(entryService.saveEntry(dtoEntryIU));
    }

    @DeleteMapping("/delete/{entryId}")
    @Override
    public RootEntity<DtoEntry> deleteEntry(@RequestParam(name = "entryId") Long entryId) {
        return ok(entryService.deleteEntry(entryId));
    }
}
