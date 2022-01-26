package designPatterns.Adapter;

/**
 * https://www.youtube.com/watch?v=VNL1NsS5Prs&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=6
 */
public class MediaPlayerAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;
    AdvanceFormat advanceFormat;

    public MediaPlayerAdapter(AdvanceFormat advanceFormat) {
        advanceMediaPlayer = new AVIPlayer();
        this.advanceFormat = advanceFormat;
    }

    @Override
    public void play(String fileToPlay, String formatToPlay) {
        advanceFormat.setFileToPlay(fileToPlay);
        advanceFormat.setFormatToPlay(formatToPlay);
        advanceMediaPlayer.playAdvanceFormat(advanceFormat);
    }
}
