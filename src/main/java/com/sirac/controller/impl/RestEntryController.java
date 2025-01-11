package com.sirac.controller.impl;

import com.sirac.controller.IRestEntryController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoEntry;
import com.sirac.dto.dto_insert_update.DtoEntryIU;
import com.sirac.service.IEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/entry")
public class RestEntryController extends RestBaseController implements IRestEntryController {

    @Autowired
    private IEntryService entryService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoEntry> saveEntry(DtoEntryIU dtoEntryIU) {
        return ok(entryService.saveEntry(dtoEntryIU));
    }
}
