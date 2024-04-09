package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GD_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GD_ThongKe() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1200,800);
		
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
		btnUser.setBounds(1145, 5, 45, 45);
		ImageIcon iconProfile = new ImageIcon("D://BaiTapLonPTUD_NHOM4//icon//icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnUser.setIcon(iconProfile);
		pnNorth.add(btnUser);
		
		JLabel lblThng = new JLabel("Thống kê:");
		lblThng.setFont(new Font("Arial", Font.BOLD, 18));
		lblThng.setBounds(53, 96, 180, 47);
		add(lblThng);
		
		JComboBox<String> comBoBoxMaSP = new JComboBox<String>();
		comBoBoxMaSP.setFont(new Font("Arial", Font.PLAIN, 18));
		comBoBoxMaSP.setBounds(184, 105, 312, 28);
		add(comBoBoxMaSP);
		
		JLabel lblThng_1 = new JLabel("Loại hình thống kê:");
		lblThng_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblThng_1.setBounds(683, 96, 180, 47);
		add(lblThng_1);
		
		JComboBox<String> comBoBoxMaSP_1 = new JComboBox<String>();
		comBoBoxMaSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comBoBoxMaSP_1.setBounds(878, 105, 259, 28);
		add(comBoBoxMaSP_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246, 245, 255));
		panel.setBounds(0, 198, 1200, 602);
		add(panel);
	}
}
