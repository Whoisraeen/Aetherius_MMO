package net.raeen.aetheriusmod.npc;

public class Dialogue {
    private String text;
    private String response;

    public Dialogue(String text, String response) {
        this.text = text;
        this.response = response;
    }

    public String getText() {
        return text;
    }

    public String getResponse() {
        return response;
    }
}
