
create database ThuThu

create table PhieuMuon(
	TenDocGia nvarchar(20) primary key,
	LopHanhChinh varchar(10),
	SoDienThoai varchar(11),
	MaSach varchar(10),
	TenSach Nvarchar(20),
	ThoiGianMuon time,
	NgayMuon date
)
create table ThongTinTraSach(
	TenDocGia nvarchar(20) primary key,
	LopHanhChinh varchar(10),
	SoDienThoai varchar(11),
	MaSach varchar(10),
	TenSach Nvarchar(20),
	NgayDangKyMuon date,
	NgayTra date
)
create table ThongTinDocThuc(
	TenDocGia nvarchar(20) primary key,
	SoDienThoai varchar(11),
	MaSach varchar(10),
	TenSach Nvarchar(20),
	HanTra date,
	GhiChu nvarchar(100)
)

create table ThongTinTraSach(
	TenDocGia nvarchar(20) primary key,
	LopHanhChinh varchar(10),
	SoDienThoai varchar(11),
	MaSach varchar(10),
	TenSach Nvarchar(20),
	NgayDangKyMuon date,
	NgayTra date
)

create table ThongTinDangky(
	IdLog varchar(10) primary key,
	Email varchar(50),
	MatKhau varchar(20),
	XacNhanMK varchar(20)
)
