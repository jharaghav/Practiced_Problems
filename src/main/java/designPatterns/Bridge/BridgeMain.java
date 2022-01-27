package designPatterns.Bridge;

/**
 * https://www.youtube.com/watch?v=SiUSGGUCWDU&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=8
 */
public class BridgeMain {
    public static void main(String[] args) {
        QRMessage qrMessage = new QRMessage(new Email());
        qrMessage.sendMessage();
    }
}
