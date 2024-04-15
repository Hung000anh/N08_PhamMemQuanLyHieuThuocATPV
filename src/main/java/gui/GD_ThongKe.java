	package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class GD_ThongKe extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnUser;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnThongKe;
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
		btnUser = new JButton();
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialog_User user=new Dialog_User();
				user.setVisible(true);
			}
		});
		btnUser.setBackground(Color.decode("#B5E6FB"));
		btnUser.setBorderPainted(false);
		btnUser.setIcon(new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png"));
		btnUser.setBounds(1092, 5, 45, 45);
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

		JPanel panel = new JPanel();
		panel.setBounds(0, 120, 1140, 125);
		add(panel);
		panel.setLayout(null);

		JLabel ngayBatDau = new JLabel("Ngày bắt đầu:");
		ngayBatDau.setFont(new Font("Arial", Font.BOLD, 16));
		ngayBatDau.setBounds(30, 85, 150, 20);
		panel.add(ngayBatDau);

		textField = new JTextField();
		textField.setBounds(190, 80, 220, 30);
		panel.add(textField);
		textField.setColumns(10);

		JLabel ngayKetThuc = new JLabel("Ngày kết thúc:");
		ngayKetThuc.setFont(new Font("Arial", Font.BOLD, 16));
		ngayKetThuc.setBounds(470, 85, 150, 20);
		panel.add(ngayKetThuc);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(630, 80, 220, 30);
		panel.add(textField_1);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(74, 131, 215));
		btnThongKe.setBounds(910, 75, 200, 40);
		panel.add(btnThongKe);

		JComboBox loaiTG = new JComboBox();
		loaiTG.setFont(new Font("Arial", Font.BOLD, 14));
		loaiTG.setModel(new DefaultComboBoxModel(new String[] {"Ngày", "Tháng", "Năm", "Khoảng thời gian"}));
		loaiTG.setBounds(190, 17, 220, 30);
		panel.add(loaiTG);

		JLabel lblThoiGianTK = new JLabel("Loại thời gian:");
		lblThoiGianTK.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGianTK.setBounds(30, 20, 150, 20);
		panel.add(lblThoiGianTK);

		panelBottom = new JPanel();
		panelBottom.setBounds(0, 255, 1140, 600);
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
