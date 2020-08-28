package com.sndy.Hytools.StatManager;

public class Player {

    private int kills;
    private int deaths;
    private int cookies;
    private int chatMessages;
    private int parkourWins;
    private int eggHuntWins;
    private int playTime;
    private int fastestParkour;
    private int fastestEggHunt;

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }

    public int getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(int chatMessages) {
        this.chatMessages = chatMessages;
    }

    public int getParkourWins() {
        return parkourWins;
    }

    public void setParkourWins(int parkourWins) {
        this.parkourWins = parkourWins;
    }

    public int getEggHuntWins() {
        return eggHuntWins;
    }

    public void setEggHuntWins(int eggHuntWins) {
        this.eggHuntWins = eggHuntWins;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public int getFastestParkour() {
        return fastestParkour;
    }

    public void setFastestParkour(int fastestParkour) {
        this.fastestParkour = fastestParkour;
    }

    public int getFastestEggHunt() {
        return fastestEggHunt;
    }

    public void setFastestEggHunt(int fastestEggHunt) {
        this.fastestEggHunt = fastestEggHunt;
    }

    /**
     * Constructor for a player object.
     *
     * @param kills          Amount of player kills
     * @param deaths         Amount of player deaths
     * @param cookies        Amount of player cookies given
     * @param chatMessages   Amount of messages sent to chat
     * @param parkourWins    Amount of times the player has beaten the parkour
     * @param eggHuntWins    Amount of times the player has beaten the egg hunt
     * @param playTime       Amount of playtime
     * @param fastestParkour Fastest parkour time
     * @param fastestEggHunt Fastest egg hunt time
     */
    public Player(int kills, int deaths, int cookies, int chatMessages, int parkourWins, int eggHuntWins, int playTime, int fastestParkour, int fastestEggHunt) {
        this.kills = kills;
        this.deaths = deaths;
        this.cookies = cookies;
        this.chatMessages = chatMessages;
        this.parkourWins = parkourWins;
        this.eggHuntWins = eggHuntWins;
        this.playTime = playTime;
        this.fastestParkour = fastestParkour;
        this.fastestEggHunt = fastestEggHunt;

    }
}
