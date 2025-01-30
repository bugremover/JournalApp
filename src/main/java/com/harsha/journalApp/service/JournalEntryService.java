



package com.harsha.journalApp.service;

import com.harsha.journalApp.entity.JournalEntry;
import com.harsha.journalApp.entity.User;
import com.harsha.journalApp.respository.JournalEntryRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Component public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    //we need to write this statement where were we need logging in file


@Transactional
//using transactional if any one service failed in the function then everything should not store in db
//after failing one service..successfully saved transactions should be rollback
public void saveEntry(JournalEntry journalEntry, String userName){
    try {
        User user= userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
    }
    catch (Exception e){

        throw new RuntimeException("An error occurred while saving the entry.",e);
    }

}
public void saveEntry(JournalEntry journalEntry ){
    journalEntryRepository.save(journalEntry);
    }
public List<JournalEntry> geteverything(){
    return journalEntryRepository.findAll();
}
public Optional<JournalEntry> findbyId(String id){
    return journalEntryRepository.findById(id);
}

@Transactional
public boolean deleteById(String  id, String userName){
    boolean removed = false;
    try{
        User user = userService.findByUserName(userName);
         removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        if(removed){
            userService.saveUser(user);
            journalEntryRepository.deleteById(id);
        }

    } catch (Exception e){
        System.out.println(e);
        throw new RuntimeException("An error occurred while deleting the entry");
    }return removed;


}

}




//controller --> service --> repository