package designPatterns.Strategy;

/**
 * https://www.youtube.com/watch?v=Si3Eln6k7ZA&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=10
 */
public class VideoPlayerMain {
    public static void main(String[] args) {
    /*    Resolution resol = new Resol1080p();
        Device device = new TV();
        VideoPlayer player = new TVVideoPLayer(device,resol);
        player.display();*/

        Resolution resolution = new Resol480p();
        Device device1 = new Phone();

        VideoPlayer phonePlayer = new PhonePlayer(device1, resolution);
        phonePlayer.display();
    }
}
