-- ====================================
-- DATABASE
-- ====================================
CREATE DATABASE IF NOT EXISTS db_watergo;
USE db_watergo;

-- ====================================
-- TABLE: admin
-- ====================================
DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
    id_user VARCHAR(255),
    nama TEXT,
    username TEXT,
    password TEXT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO admin VALUES
('ADM001', 'Admin Depot', 'admin123', 'admin123', '2025-01-01', '2025-01-01');

-- ====================================
-- TABLE: pelanggan
-- ====================================
DROP TABLE IF EXISTS pelanggan;
CREATE TABLE pelanggan (
    id_user VARCHAR(255),
    nama TEXT,
    username TEXT,
    password TEXT,
    telepon TEXT,
    alamat TEXT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO pelanggan VALUES
('PLG001', 'Budi Santoso', 'budi123', 'pass123', '081234567890', 'Jl. Melati No.1', '2025-01-01', '2025-01-01'),
('PLG002', 'Siti Aminah', 'siti123', 'pass123', '082345678901', 'Jl. Kenanga No.2', '2025-01-02', '2025-01-02'),
('PLG003', 'Rudi Hartono', 'rudi123', 'pass123', '083456789012', 'Jl. Mawar No.3', '2025-01-03', '2025-01-03'),
('PLG004', 'Anisa Putri', 'anisa123', 'pass123', '081111111111', 'Jl. Anggrek No.5', '2025-01-04', '2025-01-04'),
('PLG005', 'Dewi Lestari', 'dewi123', 'pass123', '081222222222', 'Jl. Flamboyan No.6', '2025-01-05', '2025-01-05');

-- ====================================
-- TABLE: produk
-- ====================================
DROP TABLE IF EXISTS produk;
CREATE TABLE produk (
    id_produk VARCHAR(255),
    nama_produk TEXT,
    deskripsi TEXT,
    harga DOUBLE,
    stok INT,
    satuan TEXT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY (id_produk)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO produk VALUES
('PRD001', 'Air Galon Isi Ulang', 'Air mineral isi ulang', 5000, 50, 'galon', '2025-01-01', '2025-01-01'),
('PRD002', 'Galon Kosong', 'Galon kosong tanpa isi', 25000, 20, 'galon', '2025-01-01', '2025-01-01');

-- ====================================
-- TABLE: pesanan
-- ====================================
DROP TABLE IF EXISTS pesanan;
CREATE TABLE pesanan (
    id_pesanan VARCHAR(255),
    id_pelanggan VARCHAR(255),
    tanggal_pesan DATE,
    total_harga INT,
    status ENUM('Proses','Batal','Selesai'),
    alamat_kirim TEXT,
    catatan TEXT,
    metode_bayar ENUM('COD','QRIS'),
    PRIMARY KEY (id_pesanan)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO pesanan VALUES
('ORD001', 'PLG001', '2025-01-05', 15000, 'Proses', 'Jl. Melati No.1', 'Antar cepat ya', 'COD'),
('ORD002', 'PLG002', '2025-01-06', 5000, 'Selesai', 'Jl. Kenanga No.2', '', 'QRIS'),
('ORD003', 'PLG003', '2025-01-07', 10000, 'Proses', 'Jl. Mawar No.3', 'Titip ke tetangga', 'QRIS'),
('ORD004', 'PLG004', '2025-01-08', 5000, 'Batal', 'Jl. Anggrek No.5', 'Salah alamat', 'COD'),
('ORD005', 'PLG001', '2025-01-09', 20000, 'Selesai', 'Jl. Melati No.1', 'Perlu cepat', 'QRIS');

-- ====================================
-- TABLE: detail_pesanan
-- ====================================
DROP TABLE IF EXISTS detail_pesanan;
CREATE TABLE detail_pesanan (
    id_detail VARCHAR(255),
    id_pesanan VARCHAR(255),
    id_product VARCHAR(255),
    jumlah INT,
    harga_satuan INT,
    subtotal DOUBLE,
    PRIMARY KEY (id_detail)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO detail_pesanan VALUES
('DTL001', 'ORD001', 'PRD001', 3, 5000, 15000),
('DTL002', 'ORD002', 'PRD001', 1, 5000, 5000),
('DTL003', 'ORD003', 'PRD001', 2, 5000, 10000),
('DTL004', 'ORD004', 'PRD001', 1, 5000, 5000),
('DTL005', 'ORD005', 'PRD001', 4, 5000, 20000);

-- ====================================
-- TABLE: pembayaran
-- ====================================
DROP TABLE IF EXISTS pembayaran;
CREATE TABLE pembayaran (
    id_payment VARCHAR(255),
    id_pesanan VARCHAR(255),
    jumlah DOUBLE,
    status_pembayaran ENUM('menunggu','dibayar','gagal','dikonfirmasi'),
    tanggal_bayar DATE,
    PRIMARY KEY (id_payment)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO pembayaran VALUES
('PAY001', 'ORD001', 15000, 'menunggu', '2025-01-05'),
('PAY002', 'ORD002', 5000, 'dikonfirmasi', '2025-01-06'),
('PAY003', 'ORD003', 10000, 'dibayar', '2025-01-07'),
('PAY004', 'ORD004', 5000, 'gagal', '2025-01-08'),
('PAY005', 'ORD005', 20000, 'dikonfirmasi', '2025-01-09');
