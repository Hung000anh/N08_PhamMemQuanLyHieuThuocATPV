	package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.SwingConstants;

import dao.ThongKe_Dao;
import entity.SanPham;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class GD_ThongKe extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnTKSP;
	private JButton btnTKDT;
	private final Dialog_ThongKeDoanhThu TKDT = new Dialog_ThongKeDoanhThu();
	private final Dialog_ThongKeSanPham TKSP = new Dialog_ThongKeSanPham();
	private JPanel panelBottom;

	/**
	 * Create the panel.
	 */
	public GD_ThongKe() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBackground(new Color(187, 231, 252));
		pnNorth.setBounds(0, 0, 1200, 60);

		add(pnNorth);

		JLabel lblTitle = new JLabel("Thống kê");
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setBounds(350, 10, 500, 40);
		pnNorth.add(lblTitle);

		JButton btnUser = new JButton();
		btnUser.setBorderPainted(false);
		btnUser.setBackground(new Color(181, 230, 251));
		btnUser.setBounds(1085, 7, 45, 45);
		ImageIcon iconProfile = new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnUser.setIcon(iconProfile);
		pnNorth.add(btnUser);

		btnTKSP = new JButton("Thống kê sản phẩm");
		btnTKSP.setFont(new Font("Arial", Font.BOLD, 16));
		btnTKSP.setBorderPainted(false);
		btnTKSP.setBackground(new Color(74, 131, 215));
		btnTKSP.setBounds(10, 70, 200, 40);
		add(btnTKSP);

		btnTKDT = new JButton("Thống kê doanh thu");
		btnTKDT.setFont(new Font("Arial", Font.BOLD, 16));
		btnTKDT.setBorderPainted(false);
		btnTKDT.setBackground(new Color(74, 131, 215));
		btnTKDT.setBounds(220, 70, 200, 40);
		add(btnTKDT);

		panelBottom = new JPanel();
		panelBottom.setBounds(0, 120, 1140, 725);
		panelBottom.setLayout(null);
		panelBottom.add(TKDT).setVisible(true);
		this.add(panelBottom);

		btnTKDT.addActionListener(this);
		btnTKDT.setBackground(Color.decode("#bad7eb"));
		btnTKSP.addActionListener(this);
	}

	public void resetBtnBackground() {
		btnTKDT.setBackground(new Color(74, 131, 215));
		btnTKSP.setBackground(new Color(74, 131, 215));
	}

	public void setVisibleFalse() {
		TKDT.setVisible(false);
		TKSP.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnTKDT) {
			setVisibleFalse();
			resetBtnBackground();
			btnTKDT.setBackground(Color.decode("#bad7eb"));
			panelBottom.add(TKDT).setVisible(true);
		}
		else if (o == btnTKSP) {
			setVisibleFalse();
			resetBtnBackground();
			btnTKSP.setBackground(Color.decode("#bad7eb"));
			panelBottom.add(TKSP).setVisible(true);
		}
	}
}
