import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FriendsContactApp app = new FriendsContactApp();
                app.setVisible(true);
            }
        });
    }
}
