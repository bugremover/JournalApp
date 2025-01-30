package com.harsha.journalApp.respository;

import com.harsha.journalApp.entity.JournalEntry;
import com.harsha.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository <JournalEntry, String> {


}
