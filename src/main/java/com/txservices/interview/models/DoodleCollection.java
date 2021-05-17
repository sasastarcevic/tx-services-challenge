package com.txservices.interview.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "DoodleCollection")
public class DoodleCollection {

    private String id;
    private String adminKey;
    private long latestChange;
    private long initiated;
    private int participantsCount;
    private int inviteesCount;
    private String type;
    private boolean hidden;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    private Initiator initiator;
    private List<Option> options;
    private String optionsHash;
    private List<Participant> participants;
    private List<Object> invitees;
    private String device;
    private String levels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public long getLatestChange() {
        return latestChange;
    }

    public void setLatestChange(long latestChange) {
        this.latestChange = latestChange;
    }

    public long getInitiated() {
        return initiated;
    }

    public void setInitiated(long initiated) {
        this.initiated = initiated;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public int getInviteesCount() {
        return inviteesCount;
    }

    public void setInviteesCount(int inviteesCount) {
        this.inviteesCount = inviteesCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getPreferencesType() {
        return preferencesType;
    }

    public void setPreferencesType(String preferencesType) {
        this.preferencesType = preferencesType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getOptionsHash() {
        return optionsHash;
    }

    public void setOptionsHash(String optionsHash) {
        this.optionsHash = optionsHash;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Object> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<Object> invitees) {
        this.invitees = invitees;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }
}
