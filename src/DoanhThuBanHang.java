import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DoanhThuBanHang extends JFrame {
    private JTextField tfUsername;
    private JButton btnLogin, btnSearch, btnAdd, btnDelete, btnDisplay;
    private JTextArea taAlbumInfo;
    private Map<String, String> albumMap;

    public DoanhThuBanHang() {
        // Khởi tạo cửa sổ
        setTitle("Quản lý doanh thu bán hàng");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chứa các component
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Label và Textfield cho tên người dùng
        JLabel lblUsername = new JLabel("Tên người dùng:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblUsername, constraints);

        tfUsername = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(tfUsername, constraints);

        // Button đăng nhập
        btnLogin = new JButton("Đăng nhập");
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        panel.add(btnLogin, constraints);

        // Button tìm kiếm
        btnSearch = new JButton("Tìm kiếm");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(btnSearch, constraints);

        // Button thêm
        btnAdd = new JButton("Thêm");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(btnAdd, constraints);

        // Button xoá
        btnDelete = new JButton("Xoá");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(btnDelete, constraints);

        // Button hiển thị thông tin
        btnDisplay = new JButton("Hiển thị thông tin");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        panel.add(btnDisplay, constraints);

        // Text Area cho hiển thị thông tin album
        taAlbumInfo = new JTextArea(15, 25);
        taAlbumInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taAlbumInfo);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        panel.add(scrollPane, constraints);

        // Thêm panel vào frame
        add(panel);

        // Khởi tạo Map chứa thông tin album
        albumMap = new HashMap<>();
        albumMap.put("Mã album 1", "Thông tin album 1");
        albumMap.put("Mã album 2", "Thông tin album 2");
        albumMap.put("Mã album 3", "Thông tin album 3");

        // Xử lý sự kiện
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                // Xử lý đăng nhập ở đây
                // ...

                // Xóa nội dung của Text Area
                taAlbumInfo.setText("");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String albumCode = JOptionPane.showInputDialog(DoanhThuBanHang.this, "Nhập mã album:");
                // Xử lý tìm kiếm ở đây
                String albumInfo = albumMap.get(albumCode);
                if (albumInfo != null) {
                    taAlbumInfo.append(albumInfo + "\n");
                } else {
                    taAlbumInfo.append("Không tìm thấy album với mã " + albumCode + "\n");
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String albumCode = JOptionPane.showInputDialog(DoanhThuBanHang.this, "Nhập mã album:");
                String albumInfo = JOptionPane.showInputDialog(DoanhThuBanHang.this, "Nhập thông tin album:");
                // Xử lý thêm album ở đây
                albumMap.put(albumCode, albumInfo);
                taAlbumInfo.setText("Thêm album thành công\n");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String albumCode = JOptionPane.showInputDialog(DoanhThuBanHang.this, "Nhập mã album:");
                // Xử lý xoá album ở đây
                String albumInfo = albumMap.remove(albumCode);
                if (albumInfo != null) {
                    taAlbumInfo.setText("Xoá album thành công\n");
                } else {
                    taAlbumInfo.setText("Không tìm thấy album với mã " + albumCode + " để xoá\n");
                }
            }
        });

        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taAlbumInfo.setText("");
                // Hiển thị thông tin album
                for (Map.Entry<String, String> albumEntry : albumMap.entrySet()) {
                    taAlbumInfo.append(albumEntry.getKey() + ": " + albumEntry.getValue() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoanhThuBanHang().setVisible(true);
            }
        });
    }
}
