package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GD_ChiTiecHoaDonTam extends JFrame {

	 DefaultTableModel model;
	 JTable table;
	 JScrollPane scroll;
	private static final long serialVersionUID = 1L;
	private String col[] = {  "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Giá"};
	/**
	 * Create the panel.
	 */
	public GD_ChiTiecHoaDonTam() {
		getContentPane().setLayout(null);
		
		setBounds(800, 50, 550, 400);
		JPanel pnNorth1 = new JPanel();
		pnNorth1.setLayout(null);
		pnNorth1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),

						"Danh sách hóa đơn tạm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),

						Color.blue));
		pnNorth1.setBackground(Color.WHITE);
		pnNorth1.setBounds(10, 10, 515, 320);
		getContentPane().add(pnNorth1);
		
		
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(3).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(7, 26, 500, 280);
		pnNorth1.add(scroll);

	}
public static void main(String[] args) {
	new GD_ChiTiecHoaDonTam().setVisible(true);
}
}
