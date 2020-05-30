import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class additem extends Container {
    private JTabbedPane tabbedPane1;
    public JPanel panel_additem;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel lbl_additem_magical;
    private JList list1;
    private JButton button_additem_create;
    private JButton button_additem_removef;
    private JButton button_additem_addf;
    private JList list2;
    private JButton button_additem_createItem;
    private JList list_allitems;
    private JList list_myitems;
    private JTextField textField7;
    private JButton searchButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton okButton;
    private JButton cancelButton;

    character myCharacter = new character();
    List<Item> itemList = new ArrayList<Item>();

    public additem() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addItem(list_allitems.getSelectedIndex());
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeItem(list_myitems.getSelectedIndex());
            }
        });
    }

    public void removeItem(int itemIndex){
        itemList.remove(itemIndex);
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < itemList.size(); i++){
            model.addElement(itemList.get(i));
        }
        list_myitems.setModel(model);
    }

    public void addItem(int itemIndex){
        itemList.add(myCharacter.itemList.get(itemIndex));
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < itemList.size(); i++){
            model.addElement(itemList.get(i));
        }
        list_myitems.setModel(model);
    }

    public void loadCharacter(character ch){
        myCharacter = ch;
        DefaultListModel model = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        for(int i = 0; i < ch.itemList.size(); i++){
            model.addElement(ch.itemList.get(i));
        }

        for(int a = 0; a < ch.myItems.size(); a++){
            model.addElement(ch.myItems.get(a));
        }
        list_myitems.setModel(model);
    }

    public List<Item> returnItems(){
        return itemList;
    }

}
