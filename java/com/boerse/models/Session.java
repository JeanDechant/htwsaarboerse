package com.boerse.models;

import java.sql.Timestamp;

public class Session {
    private int sessionId;
    private int kundenId;
    private int duration;
    private Timestamp time;
    private String ip;

    // This is how democracy dies. With thundering applause.

    public Session(int sessionId, int kundenId, int duration, Timestamp time, String ip) {
        this.sessionId = sessionId;
        this.kundenId = kundenId;
        this.duration = duration;
        this.time = time;
        this.ip = ip;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
