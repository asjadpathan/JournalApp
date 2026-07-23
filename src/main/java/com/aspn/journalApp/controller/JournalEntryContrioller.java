package com.aspn.journalApp.controller;

import com.aspn.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Journal")
public class JournalEntryContrioller {


    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getId(), journalEntry);
        return true;

    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }
    @DeleteMapping
    public JournalEntry deleteById(@PathVariable Long myId) {
        return journalEntries.remove(myId);

    }
    @PutMapping("id/{myId}")
    public JournalEntry updateEntry(@PathVariable Long myId, @RequestBody JournalEntry journalEntry) {
        return journalEntries.put(myId, journalEntry);
    }
}
