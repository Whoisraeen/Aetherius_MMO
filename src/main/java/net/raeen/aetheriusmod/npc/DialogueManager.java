package net.raeen.aetheriusmod.npc;

import java.util.ArrayList;
import java.util.List;

public class DialogueManager {
    private final List<Dialogue> dialogues = new ArrayList<>();

    public void addDialogue(Dialogue dialogue) {
        dialogues.add(dialogue);
    }

    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    public Dialogue getDialogue(int index) {
        return dialogues.get(index);
    }
}
