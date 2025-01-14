package com.sirac.service.impl;

import com.sirac.dto.DtoSavedEntries;
import com.sirac.dto.dto_insert_update.DtoSavedEntriesIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.Entry;
import com.sirac.model.SavedEntries;
import com.sirac.model.Topic;
import com.sirac.model.User;
import com.sirac.repository.EntryRepository;
import com.sirac.repository.SavedEntriesRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.ISavedEntriesService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SavedEntriesServiceImpl implements ISavedEntriesService, SavedToDto {

    @Autowired
    private SavedEntriesRepository savedEntriesRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private UserRepository userRepository;

    private SavedEntries createSavedEntry(DtoSavedEntriesIU dtoSavedEntriesIU){
        Optional<Entry> optionalEntry = entryRepository.findById(dtoSavedEntriesIU.getEntryId());
        if(optionalEntry.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSavedEntriesIU.getEntryId().toString()));
        }
        Optional<User> optionalUser = userRepository.findById(dtoSavedEntriesIU.getUserId());
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSavedEntriesIU.getUserId().toString()));
        }

        SavedEntries savedEntries = new SavedEntries();
        savedEntries.setCreateTime(new Date());
        savedEntries.setUpdateTime(new Date());
        savedEntries.setUser(optionalUser.get());
        savedEntries.setEntry(optionalEntry.get());

        return savedEntries;
    }

    @Override
    public DtoSavedEntries saveEntry(DtoSavedEntriesIU dtoSavedEntriesIU) {
        SavedEntries savedEntries = savedEntriesRepository.save(createSavedEntry(dtoSavedEntriesIU));
        return savedtoDtoSavedEntry(savedEntries);
    }
}
