/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accesos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dylan
 */
public class PersonalizerTable extends DefaultTableCellRenderer
{
    private int rowColor1 = 0xFFE599; // Color 1 (gris claro)
    private int rowColor2 = 0xFFFFFF; // Color 2 (blanco)
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Alternar colores de fondo de filas
        if (row % 2 == 0) {
            setBackground(new Color(rowColor1));
        } else {
            setBackground(new Color(rowColor2));
        }
        
        return this;
    }
     }
