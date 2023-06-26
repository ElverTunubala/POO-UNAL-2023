import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FriendsContactApp extends JFrame {
    private JTextField nameField, numberField;

    public FriendsContactApp() {
        setTitle("Friends Contact App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel numberLabel = new JLabel("Number:");
        numberField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton listButton = new JButton("List");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String numberText = numberField.getText();

                if (name.isEmpty() || numberText.isEmpty()) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Please enter name and number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    long number = Long.parseLong(numberText);
                    addFriend(name, number);
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Friend added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    numberField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Error adding friend: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String numberText = numberField.getText();

                if (name.isEmpty() || numberText.isEmpty()) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Please enter name and number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    long number = Long.parseLong(numberText);
                    updateFriend(name, number);
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Friend updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    numberField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Error updating friend: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String numberText = numberField.getText();

                if (name.isEmpty() || numberText.isEmpty()) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Please enter name and number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    long number = Long.parseLong(numberText);
                    deleteFriend(name, number);
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Friend deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    numberField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Error deleting friend: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String contacts = listContacts();
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Contacts:\n" + contacts, "Contact List", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FriendsContactApp.this,
                            "Error listing contacts: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addFriend(String name, long number) throws IOException {
        String nameNumberString;
        String newName = name.trim();
        String newNumber = String.valueOf(number);

        File file = new File("friendsContact.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        boolean found = false;

        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            String existingName = lineSplit[0];

            if (lineSplit.length >= 2) {
                long existingNumber = Long.parseLong(lineSplit[1]);

                if (existingName.equals(newName) || existingNumber == number) {
                    found = true;
                    break;
                }
            }
        }


        if (!found) {
            nameNumberString = newName + "!" + newNumber;
            raf.writeBytes(nameNumberString);
            raf.writeBytes(System.lineSeparator());
            raf.close();
        } else {
            raf.close();
            throw new IOException("Contact already exists");
        }
    }

    private void updateFriend(String name, long number) throws IOException {
        String nameNumberString;
        String newName = name.trim();
        String newNumber = String.valueOf(number);

        File file = new File("friendsContact.txt");
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        boolean found = false;
        long pointer = 0;

        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            String existingName = lineSplit[0];
            long existingNumber = Long.parseLong(lineSplit[1]);

            if (existingName.equals(newName) || existingNumber == number) {
                found = true;
                break;
            }
            pointer = raf.getFilePointer();
        }

        if (found) {
            raf.seek(pointer);
            nameNumberString = newName + "!" + newNumber;
            raf.writeBytes(nameNumberString);
            raf.writeBytes(System.lineSeparator());
        } else {
            raf.close();
            throw new IOException("Contact does not exist");
        }

        raf.close();
    }
    private void deleteFriend(String name, long number) throws IOException {
        String nameNumberString;
        String newName = name.trim();
        String newNumber = String.valueOf(number);

        File file = new File("friendsContact.txt");
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }

        File tempFile = new File("temp.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        RandomAccessFile tempRaf = new RandomAccessFile(tempFile, "rw");

        boolean found = false;

        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            if (lineSplit.length >= 2) {  // Ensure the line contains at least two elements
                String existingName = lineSplit[0];
                long existingNumber = Long.parseLong(lineSplit[1]);

                if (existingName.equals(newName) && existingNumber == number) {
                    found = true;
                    continue;
                }
            }

            tempRaf.writeBytes(nameNumberString);
            tempRaf.writeBytes(System.lineSeparator());
        }

        raf.close();
        tempRaf.close();

        if (found) {
            file.delete();
            tempFile.renameTo(file);
        } else {
            tempFile.delete();
            throw new IOException("Contact does not exist");
        }
    }
    private String listContacts() throws IOException {
        StringBuilder contacts = new StringBuilder();
        String nameNumberString;

        File file = new File("friendsContact.txt");
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();

            if (nameNumberString.contains("!")) {
                String[] lineSplit = nameNumberString.split("!");
                String name = lineSplit[0].replace("!", " "); // Reemplazar "!" por un espacio

                contacts.append(name).append(" ").append(lineSplit[1]).append("\n");
            }
        }

        raf.close();

        return contacts.toString();
    }
}
