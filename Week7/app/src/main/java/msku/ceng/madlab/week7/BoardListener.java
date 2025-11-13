package msku.ceng.madlab.week7;

import android.widget.Toast;

public interface BoardListener {
    byte PLAYER_1 = 1;
    byte PLAYER_2 = 2;
    byte NO_ONE = 0;


    void playedAt(byte player, byte row, byte col);

    void gameEnded(byte winner);

    void invalidPlay(byte row, byte col);

}
