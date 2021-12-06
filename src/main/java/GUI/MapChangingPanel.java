package GUI;

import GUI_Usecase.TextAdventureMap;

import javax.swing.*;

public class MapChangingPanel extends JPanel {
    public MapChangingPanel(TextAdventureFrame taf) {
        taf.setContentPane(this);
        this.setBorder(BorderFactory.createEmptyBorder(200, 400, 200, 400));

        for (TextAdventureMap textAdventureMap : taf.getMapManager().getMaps()) {
            showMap(textAdventureMap.getMapName(), taf);
        }
    }
    public void showMap(String name, TextAdventureFrame taf){
        JButton button = new JButton(name);
        button.addActionListener(e -> {
            taf.setCurrentMap(taf.getMapManager().find(name));
            taf.setContentPane(new MapPanel(taf));
            taf.pack();
        });
        this.add(button);
    }
}
