package uk.co.tmdavies.shadowmod.client.data;

public class ClientPlayerManaData {

    private static int playerMana;

    public static void set(int mana) {

        ClientPlayerManaData.playerMana = mana;

    }

    public static int getPlayerMana() {

        return playerMana;

    }

}
