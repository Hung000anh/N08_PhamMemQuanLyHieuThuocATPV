package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMaiHoaDon;
import entity.NhanVien;
import entity.SanPham;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class GD_HoaDonLuuTam extends JFrame implements ActionListener{

	 DefaultTableModel model;
	 JTable table;
	 JScrollPane scroll;
	 GD_ChiTiecHoaDonTam gdCTHDTam=new GD_ChiTiecHoaDonTam();
	 private JButton btnInHoaDon ;
	 private HoaDon_DAO hd_dao=new HoaDon_DAO();
	private static final long serialVersionUID = 1L;
	private String col[] = {  "Mã HD", "Mã khách hàng", "Mã nhân viên", "Ngày xuất", "Loại hóa đơn", "Ghi chú", "Mã khuyến mãi"};
	/**
	 * Create the panel.
	 */
	public GD_HoaDonLuuTam() {
		getContentPane().setLayout(null);
		setSize(750,550);
		JPanel pnNorth1 = new JPanel();
		pnNorth1.setLayout(null);
		pnNorth1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
						"Danh sách hóa đơn tạm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
						Color.blue));
		pnNorth1.setBackground(Color.WHITE);
		pnNorth1.setBounds(10, 10, 680, 419);
		getContentPane().add(pnNorth1);
		
		
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(6).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 26, 660, 383);
		pnNorth1.add(scroll);
		
		btnInHoaDon= new JButton("In hóa đơn");
		btnInHoaDon.setOpaque(true);
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setFont(new Font("Arial", Font.BOLD, 18));
		btnInHoaDon.setBorderPainted(false);
		btnInHoaDon.setBackground(new Color(66, 160, 255));
		btnInHoaDon.setBounds(561, 433, 130, 34);
		btnInHoaDon.addActionListener(this);
		getContentPane().add(btnInHoaDon);
		
		JButton btnXemChiTic = new JButton("Xem chi tiếc hóa đơn");
		btnXemChiTic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHD;
				while (gdCTHDTam.table.getRowCount() > 0) {
					gdCTHDTam.model.removeRow(0);
					}
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xem chi tiếc hóa đơn!!");
				} else if (table.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 hóa đơn để xem!!");
				} else {
						int row = table.getSelectedRow();
						maHD=model.getValueAt(row, 0).toString();
					
						List<ChiTietHoaDon> results = DataManager.getDsCTHDTam().stream()
						        .filter(cthd -> cthd.getHoaDon().getMaHD().equals(maHD))
						        .collect(Collectors.toList());


						if (!results.isEmpty()) {
					        for (ChiTietHoaDon cthd : results) {
					            Object[] row1 = { cthd.getHoaDon().getMaHD(), cthd.getSanPham().getMaSP(),cthd.getSoLuong(),cthd.getThanhTien() };
					            gdCTHDTam.model.addRow(row1);
					        }
					        gdCTHDTam.setVisible(true);
					    } else {
					        System.out.println("Không tìm thấy CTHD với mã hóa đơn: " + maHD);
					    }


						
					}
				}
	
			
		});
		Boolean a=gdCTHDTam.isDisplayable();
		if(a==false) {
			
		}
		btnXemChiTic.setOpaque(true);
		btnXemChiTic.setForeground(Color.WHITE);
		btnXemChiTic.setFont(new Font("Arial", Font.BOLD, 18));
		btnXemChiTic.setBorderPainted(false);
		btnXemChiTic.setBackground(new Color(66, 160, 255));
		btnXemChiTic.setBounds(294, 433, 232, 34);
		getContentPane().add(btnXemChiTic);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnInHoaDon)) {
			String maHD;
			String maKH;
			String maNV;
			Date ngayXuat;
			String loai;
			String ghiChu;
			String maKM = null;
			while (gdCTHDTam.table.getRowCount() > 0) {
				gdCTHDTam.model.removeRow(0);
				}
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xem chi tiếc hóa đơn!!");
			} else if (table.getSelectedRowCount() > 1) {
				JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 hóa đơn để xem!!");
			} else {
					int row = table.getSelectedRow();
					maHD=model.getValueAt(row, 0).toString();
					maKH=model.getValueAt(row, 1).toString();
					maNV=model.getValueAt(row, 2).toString();
					ngayXuat=java.sql.Date.valueOf(model.getValueAt(row, 3).toString()) ;
					loai=model.getValueAt(row, 4).toString();
					ghiChu=model.getValueAt(row, 5).toString();
					if (row >= 0 && row < model.getRowCount() && 6 < model.getColumnCount()) {
					    Object value = model.getValueAt(row, 6);
					    if (value != null && !value.toString().equals("")) {
					        maKM = value.toString();
					    } else {
					        maKM = null;
					    }
					} else {
					    System.out.println("Không thể truy cập vào hàng " + row + " và cột 6");
					}

				
					HoaDon hd=new HoaDon(maHD, new KhachHang(maKH), new NhanVien(maNV), ngayXuat, loai, ghiChu, new KhuyenMaiHoaDon(maKM));
					
					if(hd_dao.them(hd)) {
					
					
					

						List<ChiTietHoaDon> results = DataManager.getDsCTHDTam().stream()
						        .filter(cthd -> cthd.getHoaDon().getMaHD().equals(maHD))
						        .collect(Collectors.toList());


						if (!results.isEmpty()) {
					        for (ChiTietHoaDon cthd : results) {			
					            ChiTietHoaDon cthd1 = new ChiTietHoaDon(cthd.getHoaDon(),cthd.getSanPham(),cthd.getSoLuong());
							    ChiTietHoaDon_DAO.them(cthd1);
					            
					        }
					        
					    } else {
					        System.out.println("Không tìm thấy CTHD với mã hóa đơn: " + maHD);
					    }
						JOptionPane.showMessageDialog(this, "In hóa đơn thành công");	
						model.removeRow(row);
					
				}
			}
			
			
			
			}
		}
		
	
}
